package Products;

public class Potato extends Products {
    private final int id = 10;
    private final String name = "Potato";
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
        return "Potato{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}' + "\n";
    }

}
