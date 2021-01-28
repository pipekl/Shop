package Products;

public class Bread extends Products {
    private final int id = 2;
    private final String name = "Bread";
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
        return "Bread{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}' + "\n";
    }
}
