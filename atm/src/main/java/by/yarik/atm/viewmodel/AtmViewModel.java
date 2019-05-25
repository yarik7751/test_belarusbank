package by.yarik.atm.viewmodel;

public class AtmViewModel {

    private String text;
    private String lat;
    private String lng;

    public AtmViewModel(String text, String lat, String lng) {
        this.text = text;
        this.lat = lat;
        this.lng = lng;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
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
}
