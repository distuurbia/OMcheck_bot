import org.telegram.telegrambots.meta.api.objects.Message;

public enum CommandEnum {
    MENU("/menu", "menu_item"),
    OTHER("undefined", "undefined_item"),
    LOCATION("/location", "location");


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
