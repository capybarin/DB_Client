package sample.models;

public class PcDetail {
    private int id;
    private int pcDetailModelId;
    private String detailName;
    private double detailPrice;

    public PcDetail(int id, int pcDetailModelId, String detailName, double detailPrice) {
        this.id = id;
        this.pcDetailModelId = pcDetailModelId;
        this.detailName = detailName;
        this.detailPrice = detailPrice;
    }

    public void setId(int id){this.id = id;}

    public void setPcDetailModelId(int pcDetailModelId) {
        this.pcDetailModelId = pcDetailModelId;
    }

    public int getId() {
        return id;
    }

    public int getPcDetailModelId() {
        return pcDetailModelId;
    }

    public String getDetailName() {
        return detailName;
    }

    public double getDetailPrice() {
        return detailPrice;
    }

    public void setDetailName(String detailName) {
        this.detailName = detailName;
    }

    public void setDetailPrice(double detailPrice) {
        this.detailPrice = detailPrice;
    }
}
