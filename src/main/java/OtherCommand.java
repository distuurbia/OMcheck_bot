public class OtherCommand extends Command {
    public OtherCommand(String s, User user) {
        super(s, user);
    }


    @Override
    public Response execute() {

        response = new Response();
        response.setMessage("smth");
        return response;
    }
}
