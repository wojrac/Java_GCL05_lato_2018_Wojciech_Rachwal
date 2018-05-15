package main;

public class Gallery {
    private int id;
    private String name;
    private String resolution;
    private int size;
    private int created;

    public Gallery(int id, String name, String resolution, int size, int created) {
        this.id = id;
        this.name = name;
        this.resolution = resolution;
        this.size = size;
        this.created = created;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getCreated() {
        return created;
    }

    public void setCreated(int created) {
        this.created = created;
    }

    public Gallery() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
