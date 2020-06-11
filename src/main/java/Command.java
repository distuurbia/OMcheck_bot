import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

public abstract class Command {

    protected static CommandEnum commandName;
    protected Response response;
    protected String s;
    protected User user;

    public Command(String s, User user) {
        this.s = s;
        this.user = user;
    }

    public CommandEnum getCommandName() {
        return commandName;
    }

    public void setCommandName(CommandEnum commandName) {
        this.commandName = commandName;
    }

    public abstract Response execute();

//    public void sendMsg(Message message, String text){
//        SendMessage sendMessage = new SendMessage();
//        sendMessage.enableMarkdown(true);
//        sendMessage.setChatId(message.getChatId().toString());
//        sendMessage.setReplyToMessageId(message.getMessageId());
//        sendMessage.setText(text);
//        try{
//            execute(sendMessage);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }

}
