package by.yarik.test_belarusbank.api.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NewsResponse {

    @SerializedName("name_ru")
    private String nameRu;

    @SerializedName("name_be")
    private String nameBe;

    @SerializedName("html_ru")
    private String htmlRu;

    @SerializedName("html_be")
    private String htmlBe;

    @SerializedName("img")
    private String img;

    @SerializedName("create_time")
    private String createTime;

    @SerializedName("change_time")
    private String changeTime;

    @SerializedName("start_date")
    private String startDate;

    public String getNameRu() {
        return nameRu;
    }

    public void setNameRu(String nameRu) {
        this.nameRu = nameRu;
    }

    public NewsResponse withNameRu(String nameRu) {
        this.nameRu = nameRu;
        return this;
    }

    public String getNameBe() {
        return nameBe;
    }

    public void setNameBe(String nameBe) {
        this.nameBe = nameBe;
    }

    public NewsResponse withNameBe(String nameBe) {
        this.nameBe = nameBe;
        return this;
    }

    public String getHtmlRu() {
        return htmlRu;
    }

    public void setHtmlRu(String htmlRu) {
        this.htmlRu = htmlRu;
    }

    public NewsResponse withHtmlRu(String htmlRu) {
        this.htmlRu = htmlRu;
        return this;
    }

    public String getHtmlBe() {
        return htmlBe;
    }

    public void setHtmlBe(String htmlBe) {
        this.htmlBe = htmlBe;
    }

    public NewsResponse withHtmlBe(String htmlBe) {
        this.htmlBe = htmlBe;
        return this;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public NewsResponse withImg(String img) {
        this.img = img;
        return this;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public NewsResponse withCreateTime(String createTime) {
        this.createTime = createTime;
        return this;
    }

    public String getChangeTime() {
        return changeTime;
    }

    public void setChangeTime(String changeTime) {
        this.changeTime = changeTime;
    }

    public NewsResponse withChangeTime(String changeTime) {
        this.changeTime = changeTime;
        return this;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public NewsResponse withStartDate(String startDate) {
        this.startDate = startDate;
        return this;
    }
}
