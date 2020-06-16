public class Coordinates {
    private float latitude;
    private float longitude;

    public Coordinates() {
        latitude = 0f;
        longitude = 0f;
    }
    public void setCoordinates(float latitude, float longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }
    public float getLatitude(){
        return latitude;
    }
    public float getLongitude(){
        return longitude;
    }
}