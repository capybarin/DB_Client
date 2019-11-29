package sample.models;

public class PcDetailModel {
    private int id;
    private String model;
    private int manufactureId;
    private int pcDetailTypeId;

    public PcDetailModel(int id, String model, int manufactureId, int pcDetailTypeId) {
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

    public int getManufactureId() {
        return manufactureId;
    }

    public int getPcDetailTypeId() {
        return pcDetailTypeId;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setManufactureId(int manufactureId) {
        this.manufactureId = manufactureId;
    }

    public void setPcDetailTypeId(int pcDetailTypeId) {
        this.pcDetailTypeId = pcDetailTypeId;
    }

    public void setId(int id){this.id = id;}
}
