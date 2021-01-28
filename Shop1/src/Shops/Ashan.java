package Shops;

import Products.Products;
import java.util.ArrayList;

public class Ashan extends Shops {
    private final int id = 1;
    private final String name = "Ashan";
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
                product.setPrice(23);
                break;
            case 2:
                product.setPrice(44);
                break;
            case 3:
                product.setPrice(6);
                break;
            case 4:
                product.setPrice(99);
                break;
            case 5:
                product.setPrice(74);
                break;
            case 6:
                product.setPrice(5);
                break;
            case 7:
                product.setPrice(22);
                break;
            case 8:
                product.setPrice(76);
                break;
            case 9:
                product.setPrice(15);
                break;
            case 10:
                product.setPrice(51);
                break;
        }
    }

    @Override
    public String toString() {
        return "Ashan{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", products=" + products +
                '}';
    }
}
