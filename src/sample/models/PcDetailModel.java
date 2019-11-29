package sample.models;

public class PcDetailModel {
    private int id;
    private String model;
    private String manufactureId;
    private String pcDetailTypeId;

    public PcDetailModel(int id, String model, String manufactureId, String pcDetailTypeId) {
        this.id = id;
        this.model = model;
        this.manufactureId = manufactureId;
        this.pcDetailTypeId = pcDetailTypeId;
    }

    public int getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public String getManufactureId() {
        return manufactureId;
    }

    public String getPcDetailTypeId() {
        return pcDetailTypeId;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setManufactureId(String manufactureId) {
        this.manufactureId = manufactureId;
    }

    public void setPcDetailTypeId(String pcDetailTypeId) {
        this.pcDetailTypeId = pcDetailTypeId;
    }

    public void setId(int id){this.id = id;}
}
