package Shops;

import Products.*;
import java.util.ArrayList;

public class Magnit extends Shops {
    private final int id = 1;
    private final String name = "Magnit";
    private final String address = "Moscow";
    private ArrayList<Products> products = new ArrayList<>();

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public ArrayList<Products> getProducts() {
        return products;
    }

    @Override
    public void setProducts(ArrayList<Products> products) {
        this.products = products;
    }

    @Override
    public void addProduct (Products product) {
        setPrice(product);
        products.add(product);
    }

    public void removeProducts (int count, Products prod) {
        for (int i = 0; i < products.size(); i++) {
            if (count > 0 && getProducts().get(i).getId() == prod.getId()) {
                products.remove(i);
                count--;
                i--;
            }
        }
    }

    @Override
    void setPrice (Products product) {
        switch (product.getId()) {
            case 1:
                product.setPrice(10);
                break;
            case 2:
                product.setPrice(14);
                break;
            case 3:
                product.setPrice(3);
                break;
            case 4:
                product.setPrice(23);
                break;
            case 5:
                product.setPrice(44);
                break;
            case 6:
                product.setPrice(11);
                break;
            case 7:
                product.setPrice(7);
                break;
            case 8:
                product.setPrice(24);
                break;
            case 9:
                product.setPrice(36);
                break;
            case 10:
                product.setPrice(54);
                break;
        }
    }

    @Override
    public String toString() {
        return "Magnit{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", products=" + products.toString() +
                '}';
    }
}
