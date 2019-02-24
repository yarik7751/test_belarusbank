package by.yarik.test_belarusbank.screens.credits.viewmodel;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class CreditSection implements Parcelable {

    private String sectionTitle;
    private List<CreditViewModel> creditViewModels;

    public CreditSection(String sectionTitle, List<CreditViewModel> creditViewModels) {
        this.sectionTitle = sectionTitle;
        this.creditViewModels = creditViewModels;
    }

    public String getSectionTitle() {
        return sectionTitle;
    }

    public void setSectionTitle(String sectionTitle) {
        this.sectionTitle = sectionTitle;
    }

    public List<CreditViewModel> getCreditViewModels() {
        return creditViewModels;
    }

    public void setCreditViewModels(List<CreditViewModel> creditViewModels) {
        this.creditViewModels = creditViewModels;
    }

    //-------Parcelable---------
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.sectionTitle);
        dest.writeTypedList(this.creditViewModels);
    }

    protected CreditSection(Parcel in) {
        this.sectionTitle = in.readString();
        this.creditViewModels = in.createTypedArrayList(CreditViewModel.CREATOR);
    }

    public static final Parcelable.Creator<CreditSection> CREATOR = new Parcelable.Creator<CreditSection>() {
        @Override
        public CreditSection createFromParcel(Parcel source) {
            return new CreditSection(source);
        }

        @Override
        public CreditSection[] newArray(int size) {
            return new CreditSection[size];
        }
    };
}
