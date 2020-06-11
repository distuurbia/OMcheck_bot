import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ResponseServiceImplementation implements ResponseService {

    private UserDao userDao = ArrayListUserDao.getInstance();
    private Map<CommandEnum, CommandCreator> commandCreator = getCommands();

    public Response getResponse(Update update) {
        String request = "undefined";

        long chatId = 0L;
        if (update.hasMessage()) {
            request = update.getMessage().getText();
            chatId = update.getMessage().getChatId();
        } else if (update.hasCallbackQuery()) {
            request = update.getCallbackQuery().getData();
            chatId = update.getCallbackQuery().getMessage().getChatId();
        }

        validatePresentUser(chatId);

        String[] words = request.split("\\s+");

        CommandEnum commandEnum = defineCommand(words[0]);
        System.out.println(commandEnum.getCommand());

        CommandCreator creator = commandCreator.get(commandEnum);

        User user = userDao.getUserById(chatId);
        user.setCurrentUpdate(update);

        Command command = creator.create(request, user);

        System.out.println("shit");

        return command.execute();
    }

    private void validatePresentUser(long chatId) {
        if (!userDao.containsChatId(chatId)) {
            userDao.addUser(new User(chatId));
        }
    }

    private CommandEnum defineCommand(String request) {
        return Arrays.stream(CommandEnum.values())
                .filter(command -> command.getCommand().equals(request.trim().toLowerCase()))
                .findAny()
                .orElse(CommandEnum.OTHER);
    }


    private Map<CommandEnum, CommandCreator> getCommands() {
        Map<CommandEnum, CommandCreator> commands = new HashMap<>();

        commands.put(CommandEnum.MENU, MenuCommand::new);
        commands.put(CommandEnum.OTHER, OtherCommand::new);
//        commands.put(CommandEnum.ADDFAVORITES, AddFavouritesCommand::new);

        return commands;
    }
}