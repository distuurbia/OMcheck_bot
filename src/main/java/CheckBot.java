import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendLocation;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

public class CheckBot extends TelegramLongPollingBot {
    private ResponseService responseService;


    public CheckBot() {
        responseService = new ResponseServiceImpl();
    }
    public static void main(String[] args) {
        ApiContextInitializer.init();
        TelegramBotsApi botApi = new TelegramBotsApi();
        try {
            botApi.registerBot(new CheckBot());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }



    public void onUpdateReceived(Update update) {

        long chatId = getChatId(update);


        Response response = responseService.getResponse(update);


        for (BotApiMethod method : extractMessages(response, chatId)) {
            try {
                execute(method);

            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }

    }


    private long getChatId(Update update) {
        if (update.hasMessage()) {
            return update.getMessage().getChatId();
        } else {
            return update.getCallbackQuery().getMessage().getChatId();
        }
    }

    private List<BotApiMethod> extractMessages(Response response, long chatId) {
        List<BotApiMethod> methods = new ArrayList<>();
        if (response.getEditMessageId() == -1) {
            SendMessage sendMessage = new SendMessage()
                    .setChatId(chatId)
                    .setText(response.getMessage());

            SendLocation sendLocation = new SendLocation(response.getLatitude(),
                    response.getLongitude())
                    .setChatId(String.valueOf(chatId));

            methods.add(sendMessage);
            methods.add(sendLocation);
        }
        if (response.getEditMessageId() != -1) {
            methods.add(new EditMessageText()
                    .setChatId(chatId)
                    .setMessageId(response.getEditMessageId())
                    .setText(response.getMessage()));
        }

        return methods;
    }


    public String getBotUsername() {
        return "OMcheck_bot";
    }

    public String getBotToken() {
        return "1110520519:AAFYq8QMK8HWQODNzR2cDwCcOgPr0EiFYrc";
    }
}
