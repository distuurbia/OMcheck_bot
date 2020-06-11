import org.telegram.telegrambots.meta.api.objects.Update;
import lombok.Data;

@Data
public class User {
    private CommandEnum state;
    private Update currentUpdate;
    private long chatId;

    public User(long chatId) {
        this.chatId = chatId;
    }

    public long getChatId(){
        return chatId;
    }

    public void setCurrentUpdate(Update update){
        currentUpdate = update;
    }

}