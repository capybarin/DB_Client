package sample.models;

public class PcDetail {
    private int id;
    private String pcDetailModelId;
    private String detailName;
    private String detailPrice;


    public void setId(int id){this.id = id;}

    public void setPcDetailModelId(String pcDetailModelId) {
        this.pcDetailModelId = pcDetailModelId;
    }

    public void setDetailName(String detailName) {
        this.detailName = detailName;
    }

    public void setDetailPrice(String detailPrice) {
        this.detailPrice = detailPrice;
    }
}
