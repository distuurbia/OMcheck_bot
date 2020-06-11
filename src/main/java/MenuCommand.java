public class MenuCommand extends Command {

    public MenuCommand(String s, User user) {
        super(s, user);
    }


    @Override
    public Response execute() {

        response = new Response();
        response.setMessage("OMcheck_bot bot menu:"
                            + "\n" + "/menu: Shows all commands."
                            + "\n" + "");
        return response;
    }

}