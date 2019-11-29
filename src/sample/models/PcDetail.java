package sample.models;

public class PcDetail {
    private int id;
    private String pcDetailModelId;
    private String detailName;
    private String detailPrice;

    public PcDetail(int id, String pcDetailModelId, String detailName, String detailPrice) {
        this.id = id;
        this.pcDetailModelId = pcDetailModelId;
        this.detailName = detailName;
        this.detailPrice = detailPrice;
    }

    public void setId(int id){this.id = id;}

    public void setPcDetailModelId(String pcDetailModelId) {
        this.pcDetailModelId = pcDetailModelId;
    }

    public int getId() {
        return id;
    }

    public String getPcDetailModelId() {
        return pcDetailModelId;
    }

    public String getDetailName() {
        return detailName;
    }

    public String getDetailPrice() {
        return detailPrice;
    }

    public void setDetailName(String detailName) {
        this.detailName = detailName;
    }

    public void setDetailPrice(String detailPrice) {
        this.detailPrice = detailPrice;
    }
}
