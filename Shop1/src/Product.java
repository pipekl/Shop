public class Product {
    private final int id;
    private String name;
    private int price;
    private static int countId = 1;

    public Product(String name) {
        this.id = countId++;
        this.name = name;
    }

    public int getId() {
        return id;
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
