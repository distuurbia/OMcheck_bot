public enum CommandEnum {
    MENU("/menu", "menu_item"),
    OTHER("undefined", "undefined_item"),
    ADDFAVORITES("/addfavorites", "add_favorites_item");


    private String command;
    private String name;


    CommandEnum(String command, String name) {
        this.command = command;
        this.name = name;
    }


    public String getCommand() {
        return command;
    }


}
