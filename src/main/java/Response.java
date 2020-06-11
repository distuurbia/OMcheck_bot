import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;

public class Response {
    private String message = null;
    private ReplyKeyboard markup;
    private int editMessageId;

    public Response() {
        markup = new InlineKeyboardMarkup();
        editMessageId = -1;
    }

    public boolean hasMessage() {
        return message != null;
    }

    public boolean hasKeyboardMarkup() {
        return markup != null;
    }

    public int getEditMessageId(){
       return editMessageId;
    }

    public String getMessage(){
        return message;
    }

    public void setMessage(String message){
        this.message = message;
    }

}