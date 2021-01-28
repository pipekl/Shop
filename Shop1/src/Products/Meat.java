package Products;

public class Meat extends Products {
    private final int id = 7;
    private final String name = "Meat";
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
        return "Meat{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}' + "\n";
    }
}
