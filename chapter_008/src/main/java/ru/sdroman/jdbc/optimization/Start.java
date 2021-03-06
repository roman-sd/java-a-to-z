package ru.sdroman.jdbc.optimization;

import java.util.List;

/**
 * Class Start.
 * @author sdroman
 * @since 12.2017
 */
public class Start {

    /**
     * Main.
     *
     * @param args String
     */
    public static void main(String[] args) {
        final String tableName = "TEST";
        Settings settings = new Settings("app.properties");
        String firstXML = settings.getValue("firstXML");
        String secondXML = settings.getValue("secondXML");
        String stylesheet = settings.getValue("styleXSL");
        String url = settings.getValue("dbConnection");
        int n = Integer.parseInt(settings.getValue("n"));

        SQLToList sql = new SQLToList(tableName, n, url);
        List<Entry> list = sql.sqlToList();

        ListToXml jaxb = new ListToXml();
        jaxb.createXml(list, firstXML);

        new TransformXML().transformer(firstXML, secondXML, stylesheet);

        ParseXML parse = new ParseXML();
        int result = parse.average(secondXML, n);
        System.out.println(String.format("%s%S", "result: ", result));
    }
}
