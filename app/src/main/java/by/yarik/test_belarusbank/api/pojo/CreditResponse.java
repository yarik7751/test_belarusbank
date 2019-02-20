
package by.yarik.test_belarusbank.api.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CreditResponse {

    @SerializedName("inf_id")
    private String infId;

    @SerializedName("kredit_type")
    private String kreditType;

    @SerializedName("group_name_ru")
    private String groupNameRu;

    @SerializedName("val_key")
    private String valKey;

    @SerializedName("usl_name")
    private String uslName;

    @SerializedName("inf_time")
    private int infTime;

    @SerializedName("inf_proc_formula")
    private double infProcFormula;

    @SerializedName("platName")
    @Expose
    private String platName;
    @SerializedName("inf_koe")
    private String infKoe;

    @SerializedName("inf_odolg")
    private String infOdolg;

    @SerializedName("inf_oproc")
    private String infOproc;

    @SerializedName("inf_max_size")
    private int infMaxSize;

    public String getInfId() {
        return infId;
    }

    public String getKreditType() {
        return kreditType;
    }

    public String getGroupNameRu() {
        return groupNameRu;
    }

    public String getValKey() {
        return valKey;
    }

    public String getUslName() {
        return uslName;
    }

    public int getInfTime() {
        return infTime;
    }

    public double getInfProcFormula() {
        return infProcFormula;
    }

    public String getPlatName() {
        return platName;
    }

    public String getInfKoe() {
        return infKoe;
    }

    public String getInfOdolg() {
        return infOdolg;
    }

    public String getInfOproc() {
        return infOproc;
    }

    public int getInfMaxSize() {
        return infMaxSize;
    }
}
