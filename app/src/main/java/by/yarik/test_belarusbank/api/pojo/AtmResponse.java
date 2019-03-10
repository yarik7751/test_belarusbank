package by.yarik.test_belarusbank.api.pojo;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AtmResponse {

    @SerializedName("id")
    private String id;

    @SerializedName("area")
    private String area;

    @SerializedName("city_type")
    private String cityType;

    @SerializedName("city")
    private String city;

    @SerializedName("address_type")
    private String addressType;

    @SerializedName("address")
    private String address;

    @SerializedName("house")
    private String house;

    @SerializedName("install_place")
    private String installPlace;

    @SerializedName("work_time")
    private String workTime;

    @SerializedName("gps_x")
    private String gpsX;

    @SerializedName("gps_y")
    private String gpsY;

    @SerializedName("install_place_full")
    private String installPlaceFull;

    @SerializedName("work_time_full")
    private String workTimeFull;

    @SerializedName("ATM_type")
    private String aTMType;

    @SerializedName("ATM_error")
    private String aTMError;

    @SerializedName("currency")
    private String currency;

    @SerializedName("cash_in")
    private String cashIn;

    @SerializedName("ATM_printer")
    private String aTMPrinter;

    public String getId() {
        return id;
    }

    public String getArea() {
        return area;
    }

    public String getCityType() {
        return cityType;
    }

    public String getCity() {
        return city;
    }

    public String getAddressType() {
        return addressType;
    }

    public String getAddress() {
        return address;
    }

    public String getHouse() {
        return house;
    }

    public String getInstallPlace() {
        return installPlace;
    }

    public String getWorkTime() {
        return workTime;
    }

    public String getGpsX() {
        return gpsX;
    }

    public String getGpsY() {
        return gpsY;
    }

    public String getInstallPlaceFull() {
        return installPlaceFull;
    }

    public String getWorkTimeFull() {
        return workTimeFull;
    }

    public String getaTMType() {
        return aTMType;
    }

    public String getaTMError() {
        return aTMError;
    }

    public String getCurrency() {
        return currency;
    }

    public String getCashIn() {
        return cashIn;
    }

    public String getaTMPrinter() {
        return aTMPrinter;
    }
}