public class OtherCommand extends Command {
    public OtherCommand(String s, User user) {
        super(s, user);
    }


    @Override
    public Response execute() {
        response = new Response();
        if (user.getCurrentUpdate().getMessage().getLocation() != null) {
            Coordinates coordinates = new Coordinates();
            coordinates.setCoordinates(user.getCurrentUpdate().getMessage().getLocation().getLatitude(),
                    user.getCurrentUpdate().getMessage().getLocation().getLongitude());
            response.setCoordinates(coordinates);
        }
        response.setMessage("smth");
        return response;
    }
}
