package sample;

public class Producto {

    private String id;
    private String name;
    private String description;
    private int row;

    public Producto(String id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Producto(String id, String name, String description, int row) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.row = row;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
