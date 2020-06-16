import org.telegram.telegrambots.meta.api.methods.send.SendLocation;
import org.telegram.telegrambots.meta.api.objects.Update;
import sun.plugin2.message.Message;
import sun.plugin2.message.Serializer;

import java.io.IOException;

public class GetLocation extends Command {

    public GetLocation(String s, User user) {
        super(s, user);
    }


    @Override
    public Response execute() {

        response = new Response();

        float latitude = user.getLatitude();
        float longitude = user.getLongitude();
        Coordinates coordinates = null;
        coordinates.setCoordinates(latitude, longitude);
        long chatId = user.getChatId();
        response.setMessage("OMcheck_bot bot menu:"
                + "\n" + "/menu: Shows all commands."
                + "\n" + "");
        response.setLocation(coordinates);
        return response;
    }

}