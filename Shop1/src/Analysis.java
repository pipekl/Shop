import Shops.*;
import Products.*;

import java.util.ArrayList;
import java.util.HashMap;

public class Analysis {

    public void priceProduct (Shops shop, Products prod) {
        int price = searchPrice(shop, prod);

        if (price > 0) {
        System.out.println("Цена " + prod.getName() + " в магазине " +
                shop.getName() + ": " + price);
        } else {
            System.out.println("Такого продукта нет в магазине.");
        }
    }

    public void lowPrice (Shops shop1, Shops shop2, Products prod) {
        int priceShop1 = searchPrice(shop1, prod);
        int priceShop2 = searchPrice(shop2, prod);

        if (priceShop1 < priceShop2)
            System.out.println("В магазине " + shop1.getName() + " самая низкая цена на " +
                    prod.getName() + ": " + priceShop1);
        else
            System.out.println("В магазине " + shop2.getName() + " самая низкая цена на " +
                    prod.getName() + ": " + priceShop2);
    }

    public void lowPrice (Shops shop1, Shops shop2, Shops shop3, Products prod) {
        int priceShop1 = searchPrice(shop1, prod);
        int priceShop2 = searchPrice(shop2, prod);
        int priceShop3 = searchPrice(shop3, prod);

        if (priceShop1 < priceShop2 && priceShop1 < priceShop3)
            System.out.println("В магазине " + shop1.getName() + " самая низкая цена на " +
                    prod.getName() + ": " + priceShop1);
        if (priceShop2 < priceShop1 && priceShop2 < priceShop3)
            System.out.println("В магазине " + shop2.getName() + " самая низкая цена на " +
                    prod.getName() + ": " + priceShop2);
        else
            System.out.println("В магазине " + shop3.getName() + " самая низкая цена на " +
                    prod.getName() + ": " + priceShop3);
    }

    private int searchPrice (Shops shop, Products prod) {
        int price = 0;

        for (Products x : shop.getProducts()) {
            if (x.getId() == prod.getId()) {
                price = x.getPrice();
            }
        }
        return price;
    }

    private int searchQuantity (Shops shop, Products prod) {
        int quantity = 0;

        for (Products x : shop.getProducts()) {
            if (x.getId() == prod.getId()) {
                quantity++;
            }
        }
        return quantity;
    }

    public void whatProductsCanBuy (Shops shop, int money) {
        System.out.println("В магазине " + shop.getName() + " на " + money + " руб. можно купить:");
        int quantity = 0;
        int sumPrice = 0;
        String countId;
        int i =0;
        while (i < shop.getProducts().size()) {
            countId = shop.getProducts().get(i).getName();
            while (i < shop.getProducts().size() && shop.getProducts().get(i).getName().equals(countId)) {
                if (sumPrice + shop.getProducts().get(i).getPrice() <= money) {
                    sumPrice += shop.getProducts().get(i).getPrice();
                    quantity++;
                }
                i++;
            }
            System.out.println(countId + " количество: " + quantity +
                    " за " + sumPrice + " руб. (всего в магазине " +
                    searchQuantity(shop, shop.getProducts().get(i-1)) + " шт.)");

            sumPrice = 0;
            quantity = 0;
        }
    }

    public void buyProducts (Shops shop, int count, Products prod) {
        if (count > searchQuantity(shop, prod)) {
            System.out.println("В магазине " + shop.getName() + " на складе недостаточно товара.");
            System.out.println("Вы хотите купить " + count + ", а в наличии " + searchQuantity(shop, prod));
        }
        else {
            System.out.println("В магазине " + shop.getName() + " в наличии " + searchQuantity(shop, prod)
                            + " " + prod.getName());
            int priceProd = (searchPrice(shop, prod)*count);
            shop.removeProducts(count, prod);

            System.out.println("Вы купили " + count + " " + prod.getName() + " за " + priceProd);
            System.out.println("В магазине " + shop.getName() + " осталось " +
                    searchQuantity(shop, prod) + " " + prod.getName());
        }
    }

    public void setProductsBuy (ArrayList<Shops> shops, HashMap<Integer, Products> setProd) {
        String whenShop = "";
        int minPriceAllShops = 999999999;
        int setPrice;
        int quantityYes;
        int quantity;
        Integer[] key = new Integer[setProd.size()];
        setProd.keySet().toArray(key);

        for (Shops shop : shops) {
            quantityYes = 0;
            setPrice = 0;
            for (int i = 0; i < setProd.size(); i++) {
                quantity = searchQuantity(shop, setProd.get(key[i]));
                if (quantity >= key[i]) {
                    setPrice += searchPrice(shop, setProd.get(key[i]))*key[i];
                    quantityYes ++;
                }
                else {
                    System.out.println("Недостаточно товара " + setProd.get(key[i]).getName() +
                            " в магазине " + shop.getName());
                }
            }
            if (quantityYes == setProd.size()) {
                if (minPriceAllShops > setPrice) {
                    minPriceAllShops = setPrice;
                    whenShop = shop.getName();
                }
            }
        }
        if (!whenShop.equals("")) {
            System.out.println("Следующий набор товаров: ");

            for (int i = 0; i < setProd.size(); i++) {
                System.out.println(setProd.get(key[i]).getName() + " клоличество: " +
                        key[i] + " шт.");
            }
            System.out.println("Дешевле всего купить в магазине " + whenShop + " за " +
                    minPriceAllShops + " руб.");
        }
        else {
            System.out.println("В магазинах нет столько товара!");
        }
    }
}

