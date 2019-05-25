package by.yarik.core.core.models;

public class AtmModel {

    private String address;
    private String place;
    private String lat;
    private String lng;
    private boolean error;

    public AtmModel(String address, String place, String lat, String lng, boolean error) {
        this.address = address;
        this.place = place;
        this.lat = lat;
        this.lng = lng;
        this.error = error;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }
}
