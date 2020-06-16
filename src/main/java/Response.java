import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;

public class Response {
    private String message = null;

    private int editMessageId;
    private Coordinates coordinates;
    public Response() {

        editMessageId = -1;
    }

    public boolean hasMessage() {
        return message != null;
    }

    public int getEditMessageId(){
       return editMessageId;
    }

    public String getMessage(){
        return message;
    }

    public float getLatitude(){return coordinates.getLatitude();}
    public float getLongitude(){return coordinates.getLongitude();};

    public void setMessage(String message){
        this.message = message;
    }

    public void setLocation(Coordinates coordinates){this.coordinates = coordinates;}

}