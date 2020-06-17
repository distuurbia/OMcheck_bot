import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;


public class Response {
    private String message = null;

    private int editMessageId;
    private Coordinates coordinates;
    private ReplyKeyboard button;
    public Response() {
        editMessageId = -1;
    }

    public boolean hasMessage() {
        return message != null;
    }


    public String getMessage(){
        return message;
    }

    public void setMessage(String message){
        this.message = message;
    }

    public void setButton(ReplyKeyboard button) {
        this.button = button;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public ReplyKeyboard getButton() {
        return button;
    }

}