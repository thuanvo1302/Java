package tdtu.edu.vn.lab05.Model;

public class product {
    protected int id;
    protected String name;
    protected int price;

    public product() {
    }

    public product(String name, int price) {
        super();
        this.name = name;
        this.price = price;
    }

    public product(int id, String name, int price) {
        super();
        this.id = id;
        this.name = name;
        this.price = price;
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
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }

}
