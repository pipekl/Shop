package Products;

public class Onion extends Products {
    private final int id = 8;
    private final String name = "Onion";
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
        return "Onion{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}' + "\n";
    }
}
