package by.yarik.test_belarusbank.screens.credits.viewmodel;

import android.os.Parcel;
import android.os.Parcelable;

import by.yarik.test_belarusbank.core.annotations.credit.CreditViewModelType;

public class CreditViewModel implements Parcelable {

    @CreditViewModelType
    int type;

    private String id;

    private String groupName;

    private String term;

    private String percents;

    private String maxSize;

    public CreditViewModel(int type, String id, String groupName, String term, String percents, String maxSize) {
        this.type = type;
        this.id = id;
        this.groupName = groupName;
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

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getPercents() {
        return percents;
    }

    public void setPercents(String percents) {
        this.percents = percents;
    }

    public String getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(String maxSize) {
        this.maxSize = maxSize;
    }

    //-------------Parcelable----------
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.type);
        dest.writeString(this.id);
        dest.writeString(this.groupName);
        dest.writeString(this.term);
        dest.writeString(this.percents);
        dest.writeString(this.maxSize);
    }

    public CreditViewModel() {
    }

    protected CreditViewModel(Parcel in) {
        this.type = in.readInt();
        this.id = in.readString();
        this.groupName = in.readString();
        this.term = in.readString();
        this.percents = in.readString();
        this.maxSize = in.readString();
    }

    public static final Parcelable.Creator<CreditViewModel> CREATOR = new Parcelable.Creator<CreditViewModel>() {
        @Override
        public CreditViewModel createFromParcel(Parcel source) {
            return new CreditViewModel(source);
        }

        @Override
        public CreditViewModel[] newArray(int size) {
            return new CreditViewModel[size];
        }
    };
}
