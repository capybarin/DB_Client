package sample.models;

public class PcDetailModel {
    private int id;
    private String model;
    private String manufactureId;
    private String pcDetailTypeId;


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
