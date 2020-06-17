import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.Arrays;

public class LocationCommand extends Command {
    public LocationCommand(String s, User user) {
        super(s, user);
    }



    @Override
    public Response execute() {
        response = new Response();
        KeyboardRow row = new KeyboardRow();
        row.add(new KeyboardButton("Show your location.").setRequestLocation(true));
        response.setButton(new ReplyKeyboardMarkup(Arrays.asList(row)));
        return response;
    }
}
