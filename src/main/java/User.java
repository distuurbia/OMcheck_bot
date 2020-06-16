import org.telegram.telegrambots.meta.api.objects.Update;
import lombok.Data;

@Data
public class User {
    private CommandEnum state;
    private Update currentUpdate;
    private long chatId;
    private Coordinates coordinates;

    public User(long chatId, Coordinates coordinates) {
        this.chatId = chatId;
        this.coordinates = coordinates;
    }

    public long getChatId(){
        return chatId;
    }

    public float getLatitude(){ return coordinates.getLatitude(); }
    public float getLongitude(){ return coordinates.getLongitude(); }


    public void setCurrentUpdate(Update update){
        currentUpdate = update;
    }

}