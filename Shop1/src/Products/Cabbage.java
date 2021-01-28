package Products;

public class Cabbage extends Products {
    private final int id = 3;
    private final String name = "Cabbage";
    private int price;

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Cabbage{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}' + "\n";
    }
}
