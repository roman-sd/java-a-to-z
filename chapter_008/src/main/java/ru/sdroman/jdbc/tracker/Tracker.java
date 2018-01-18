package ru.sdroman.jdbc.tracker;

import ru.sdroman.jdbc.optimization.Settings;
import ru.sdroman.jdbc.tracker.models.Comment;
import ru.sdroman.jdbc.tracker.models.Item;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @author sdroman
 * @since 12.2017
 */
public class Tracker {

    /**
     * Url.
     */
    private String url;

    /**
     * Setting.
     */
    private Settings settings;

    /**
     * Constructs a new Tracker object.
     */
    public Tracker() {
        this.settings = new Settings("tracker.properties");
        this.url = this.settings.getValue("dbConnection");
    }

    /**
     * Is empty.
     *
     * @return true if items table is not exists
     */
    public boolean isEmpty() {
        boolean isEmpty;
        String query = this.settings.getValue("selectAllItems");
        try (Connection conn = DriverManager.getConnection(url);
             Statement statement = conn.createStatement()) {

            statement.executeQuery(query);
            isEmpty = false;

        } catch (SQLException e) {
            isEmpty = true;
        }
        return isEmpty;
    }

    /**
     * Creates date.
     *
     * @return String
     */
    private String createDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH:mm");
        Date date = new Date(System.currentTimeMillis());
        return dateFormat.format(date);
    }

    /**
     * Removes table.
     *
     * @param name String table name
     */
    public void dropTable(String name) {
        String dropQuery = this.settings.getValue("dropTable");
        try (Connection conn = DriverManager.getConnection(url);
             Statement st = conn.createStatement()) {
            st.execute(dropQuery.replace("%tableName", name));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Creates tables.
     */
    public void createTable() {
        String items = this.settings.getValue("createItemsTable");
        String comments = this.settings.getValue("createCommentsTable");
        try (Connection conn = DriverManager.getConnection(url);
             Statement st = conn.createStatement()) {
            st.addBatch(items);
            st.addBatch(comments);
            st.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Gets id from database.
     *
     * @param connection Connection
     * @return String
     * @throws SQLException exception
     */
    private String getIdFromDb(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet result = statement.getGeneratedKeys();
        return result.getString("last_insert_rowid()");
    }

    /**
     * Creates item from database.
     *
     * @param result ResultSet
     * @return Item
     * @throws SQLException exception
     */
    private Item createItem(ResultSet result) throws SQLException {
        Item item = new Item(result.getString("name"), result.getString("desc"));
        item.setId(result.getString("id"));
        item.setTimeCreation(result.getString("createDate"));
        return item;
    }

    /**
     * Initializes database.
     */
    public void initDataBase() {
        Item item = new Item("item", "item desc");
        Comment itemComment1 = new Comment("item comment_01");
        Comment itemComment2 = new Comment("item comment_02");
        Item bug = new Item("bug", "bug desc");
        Comment bugComment1 = new Comment("bug comment_01");
        Comment bugComment2 = new Comment("bug comment_02");
        Comment bugComment3 = new Comment("bug comment_03");
        createTable();
        addItem(item);
        addItem(bug);
        addComment(itemComment1, item);
        addComment(itemComment2, item);
        addComment(bugComment1, bug);
        addComment(bugComment2, bug);
        addComment(bugComment3, bug);
    }

    /**
     * Adds item.
     *
     * @param item Item
     */
    public void addItem(Item item) {
        String query = this.settings.getValue("insertItems");
        item.setTimeCreation(createDate());
        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, item.getName());
            ps.setString(2, item.getDescription());
            ps.setString(3, item.getTimeCreation());
            ps.executeUpdate();
            item.setId(getIdFromDb(conn));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Adds comment.
     *
     * @param comment Comment
     * @param item    Item
     * @return true if successful
     */
    public boolean addComment(Comment comment, Item item) {
        boolean done = false;
        comment.setCreateDate(createDate());
        String query = this.settings.getValue("insertComments");
        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, comment.getComment());
            ps.setString(2, item.getId());
            ps.setString(3, comment.getCreateDate());
            ps.executeUpdate();
            done = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return done;
    }

    /**
     * Edits item.
     *
     * @param item    Item old item
     * @param newItem Item
     */
    public void updateItem(Item item, Item newItem) {
        String updateQuery = this.settings.getValue("updateItems");
        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement ps = conn.prepareStatement(updateQuery)) {
            ps.setString(1, newItem.getName());
            ps.setString(2, newItem.getDescription());
            ps.setString(3, item.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Removes all comment from item.
     *
     * @param item Item
     */
    private void removeAllCommentsFromItem(Item item) {
        String query = this.settings.getValue("removeComments");
        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, item.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Removes item.
     *
     * @param item Item
     */
    public void removeItem(Item item) {
        String removeItem = this.settings.getValue("removeItem");
        removeAllCommentsFromItem(item);
        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement psItem = conn.prepareStatement(removeItem)) {
            psItem.setString(1, item.getId());
            psItem.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns comments from item.
     *
     * @param id item's id
     * @return List
     */
    private List<Comment> getComments(String id) {
        String query = this.settings.getValue("getComments");
        Comment comment;
        List<Comment> comments = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    comment = new Comment(rs.getString("comment"));
                    comment.setCreateDate(rs.getString("createDate"));
                    comments.add(comment);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return comments;
    }

    /**
     * Finds item by id.
     *
     * @param id String
     * @return Item
     */
    public Item findById(String id) {
        String itemQuery = this.settings.getValue("getItem");
        Item item = null;
        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement psItem = conn.prepareStatement(itemQuery)) {
            psItem.setString(1, id);

            try (ResultSet rs = psItem.executeQuery()) {
                if (rs.next()) {
                    item = createItem(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (item != null) {
            item.addComments(getComments(id));
        }
        return item;
    }

    /**
     * Returns item's list.
     *
     * @return List
     */
    public List<Item> itemsList() {
        String itemQuery = this.settings.getValue("selectAllItems");
        List<Item> itemList = new ArrayList<>();
        Item item;
        List<Comment> comments;
        try (Connection conn = DriverManager.getConnection(this.url);
             Statement stItem = conn.createStatement();
             ResultSet rs = stItem.executeQuery(itemQuery)) {
            while (rs.next()) {
                item = createItem(rs);
                comments = getComments(item.getId());
                item.addComments(comments);
                itemList.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return itemList;
    }
}
