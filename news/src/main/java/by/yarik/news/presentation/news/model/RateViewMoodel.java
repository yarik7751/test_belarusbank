package by.yarik.news.presentation.news.model;

public class RateViewMoodel {

    private String date;
    private String usdIn;
    private String usdOut;
    private String eurIn;
    private String eurOut;

    public RateViewMoodel(String date, String usdIn, String usdOut, String eurIn, String eurOut) {
        this.date = date;
        this.usdIn = usdIn;
        this.usdOut = usdOut;
        this.eurIn = eurIn;
        this.eurOut = eurOut;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getUsdIn() {
        return usdIn;
    }

    public void setUsdIn(String usdIn) {
        this.usdIn = usdIn;
    }

    public String getUsdOut() {
        return usdOut;
    }

    public void setUsdOut(String usdOut) {
        this.usdOut = usdOut;
    }

    public String getEurIn() {
        return eurIn;
    }

    public void setEurIn(String eurIn) {
        this.eurIn = eurIn;
    }

    public String getEurOut() {
        return eurOut;
    }

    public void setEurOut(String eurOut) {
        this.eurOut = eurOut;
    }
}
