package Shops;

import Products.*;
import java.util.ArrayList;

public abstract class Shops {
    private int id;
    private String name;
    private String address;
    private ArrayList<Products> products = new ArrayList<>();

    public ArrayList<Products> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Products> products) {
        this.products = products;
    }

    abstract public String getName();

    abstract public void removeProducts (int count, Products prod);

    abstract public void addProduct (Products product);
    abstract void setPrice (Products product);

    public void addAllProducts () {
        quantityProducts(new Apple());
        quantityProducts(new Bread());
        quantityProducts(new Cabbage());
        quantityProducts(new Carrot());
        quantityProducts(new Chocolate());
        quantityProducts(new Kiwi());
        quantityProducts(new Meat());
        quantityProducts(new Onion());
        quantityProducts(new Orange());
        quantityProducts(new Potato());
    }

    private void quantityProducts (Products prod) {
        int quantity = (int) (Math.random() * ((30 - 1) + 1)) + 1;
        for (int i = 0; i < quantity; i++)
            addProduct(prod);
    }

    @Override
    public String toString() {
        return "Shops{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", products=" + products +
                '}';
    }
}
