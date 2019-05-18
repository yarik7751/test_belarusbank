package by.yarik.core.core.models;

import android.os.Parcel;
import android.os.Parcelable;

import by.yarik.core.core.annotations.credit.CreditModelType;

public class CreditModel implements Parcelable {

    @CreditModelType
    private int type;

    private String id;

    private String groupName;

    private String currencyKey;

    private int term;

    private double percents;

    private int maxSize;

    public CreditModel(int type, String id, String groupName, String currencyKey, int term, double percents, int maxSize) {
        this.type = type;
        this.id = id;
        this.groupName = groupName;
        this.currencyKey = currencyKey;
        this.term = term;
        this.percents = percents;
        this.maxSize = maxSize;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getCurrencyKey() {
        return currencyKey;
    }

    public void setCurrencyKey(String currencyKey) {
        this.currencyKey = currencyKey;
    }

    public int getTerm() {
        return term;
    }

    public void setTerm(int term) {
        this.term = term;
    }

    public double getPercents() {
        return percents;
    }

    public void setPercents(double percents) {
        this.percents = percents;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    //-----------Parcelable-------------
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.type);
        dest.writeString(this.id);
        dest.writeString(this.groupName);
        dest.writeString(this.currencyKey);
        dest.writeInt(this.term);
        dest.writeDouble(this.percents);
        dest.writeInt(this.maxSize);
    }

    public CreditModel() {
    }

    protected CreditModel(Parcel in) {
        this.type = in.readInt();
        this.id = in.readString();
        this.groupName = in.readString();
        this.currencyKey = in.readString();
        this.term = in.readInt();
        this.percents = in.readDouble();
        this.maxSize = in.readInt();
    }

    public static final Creator<CreditModel> CREATOR = new Creator<CreditModel>() {
        @Override
        public CreditModel createFromParcel(Parcel source) {
            return new CreditModel(source);
        }

        @Override
        public CreditModel[] newArray(int size) {
            return new CreditModel[size];
        }
    };
}
