package by.yarik.atm.model;

import java.util.HashMap;

public class AtmParamsModel {

    private String city;
    private HashMap<String, Boolean> currencies;

    public AtmParamsModel() {
        currencies = new HashMap<>();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void addCurrency(String city, boolean checked) {
        currencies.put(city, checked);
    }

    public HashMap<String, Boolean> getCurrencies() {
        return currencies;
    }
}
