package sample.models;

public class Manufacture {
    private int id;
    private String name;

    public Manufacture(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id){this.id = id;}

    public void setName(String name_short){this.name = name_short;}


}
