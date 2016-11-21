package ru.sdroman.start;

import ru.sdroman.models.Item;

/**
 * class StartUI. Starts the program.
 */
public class StartUI {

    /**
     * input.
     */
    private Input input;

    /**
     * Create a new StartUI object.
     * @param input Input
     */
    public StartUI(Input input) {
        this.input = input;
    }

    /**
     * Print menu.
     */
    private void showMenu() {
        System.out.println("1. add");
        System.out.println("2. edit");
        System.out.println("3. remove");
        System.out.println("4. find by name");
        System.out.println("5. find by id");
        System.out.println("6. show all");
        System.out.println("7. exit");
    }

    /**
     * Work with menu.
     * @param tracker Tracker
     */
    public void init(Tracker tracker) {
        this.showMenu();
        boolean flag = false;

        while (!flag) {

            switch (this.input.ask("Choose key: ")) {
                case "1":
                    tracker.add(new Item(input.ask("Name : "), input.ask("Description : ")));
                    break;
                case "2":
                    Item oldItem = tracker.findByName(input.ask("name to edit : "));
                    Item newItem = new Item(input.ask("new name : "), input.ask("new description : "));
                    newItem.setId(oldItem.getId());
                    if (tracker.edit(newItem)) {
                        System.out.println("success");
                    }
                    break;
                case "3":
                    Item removeItem = tracker.findByName(input.ask("name to remove : "));
                    if (tracker.remove(removeItem)) {
                        System.out.println("success");
                    }
                    break;
                case "4":
                    Item nameItem = tracker.findByName(input.ask("name : "));
                    System.out.println(String.format("%s %s ", nameItem.getName(), nameItem.getDescription()));
                    break;
                case "5":
                    Item idItem = tracker.findById(input.ask("id : "));
                    System.out.println(String.format("%s %s ", idItem.getName(), idItem.getDescription()));
                    break;
                case "6":
                    for (Item item : tracker.getAll()) {
                        System.out.println(String.format("%s %s ", item.getName(), item.getDescription()));
                    }
                    break;
                case "7":
                    flag = true;
                    break;
                default: break;
            }
        }
    }

    /**
     * Start program. method main().
     * @param args String[]
     */
    public static void main(String[] args) {
        Tracker tracker = new Tracker();
        Input input = new ConsoleInput();
        new StartUI(input).init(tracker);

    }
}
