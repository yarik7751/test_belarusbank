package by.yarik.test_belarusbank.api.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CurrencyExchangeResponse {

    @SerializedName("kurs_date_time")
    private String kursDateTime;

    @SerializedName("kurs_date")
    private String kursDate;

    @SerializedName("kurs_time")
    private String kursTime;

    @SerializedName("USDCARD_in")
    private String usdCardIn;

    @SerializedName("USDCARD_out")
    private String usdCardOut;

    @SerializedName("EURCARD_in")
    private String eurCardIn;

    @SerializedName("EURCARD_out")
    private String eurCardOut;

    @SerializedName("RUBCARD_in")
    private String rubCardIn;

    @SerializedName("RUBCARD_out")
    private String rubCardOut;

    public String getKursDateTime() {
        return kursDateTime;
    }

    public String getKursDate() {
        return kursDate;
    }

    public String getKursTime() {
        return kursTime;
    }

    public String getUsdCardIn() {
        return usdCardIn;
    }

    public String getUsdCardOut() {
        return usdCardOut;
    }

    public String getEurCardIn() {
        return eurCardIn;
    }

    public String getEurCardOut() {
        return eurCardOut;
    }

    public String getRubCardIn() {
        return rubCardIn;
    }

    public String getRubCardOut() {
        return rubCardOut;
    }
}
