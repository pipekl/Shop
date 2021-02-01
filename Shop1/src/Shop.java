import java.util.ArrayList;

public class Shop {
    private final int id;
    private String name;
    private String address;
    private ArrayList<Product> products = new ArrayList<>();
    private static int countId = 1;

    public Shop(String name, String address) {
        this.id = countId++;
        this.name = name;
        this.address = address;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void addProducts (Product prod, int quantity, int price) {
        for (int i = 0; i < quantity; i++) {
            prod.setPrice(price);
            products.add(prod);
        }
    }

    public void changePrice (Product prod, int price) {
        for (Product x : products) {
            if (prod.getName().equals(x.getName()))
                x.setPrice(price);
        }
    }

    public void removeProducts (int count, Product prod) {
        for (int i = 0; i < products.size(); i++) {
            if (count > 0 && getProducts().get(i).getName().equals(prod.getName())) {
                products.remove(i);
                count--;
                i--;
            }
        }
    }
}
