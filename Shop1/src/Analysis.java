import java.util.ArrayList;
import java.util.HashMap;

public class Analysis {

    private int searchPrice (Shop shop, Product prod) {
        int price = 0;

        for (Product x : shop.getProducts()) {
            if (x.getName().equals(prod.getName())) {
                price = x.getPrice();
            }
        }
        return price;
    }

    private int searchQuantity (Shop shop, Product prod) {
        int quantity = 0;

        for (Product x : shop.getProducts()) {
            if (x.getName().equals(prod.getName())) {
                quantity++;
            }
        }
        return quantity;
    }

    public void shopWithLowestPrice (ArrayList <Shop> shops, Product prod) {
        int resultPrice = 999;
        String resultShop = "";
        int shopPrice;

        for (Shop shop : shops) {
            shopPrice = 0;
            for (int i = 0; i < shop.getProducts().size(); i++) {
                if (shop.getProducts().get(i).getName().equals(prod.getName())) {
                    shopPrice = shop.getProducts().get(i).getPrice();
                    break;
                }
            }
            if (resultPrice > shopPrice) {
                resultPrice = shopPrice;
                resultShop = shop.getName();
            }
        }
        System.out.println("Самая низкая цена на " + prod.getName() + " в магазине " + resultShop
            + " " + resultPrice + " руб.");
    }

    public void whatProductsCanBuy (Shop shop, int money) {
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

    public void buyProducts (Shop shop, int quantity, Product prod) {
        if (quantity > searchQuantity(shop, prod)) {
            System.out.println("В магазине " + shop.getName() + " на складе недостаточно товара.");
            System.out.println("Вы хотите купить " + quantity + ", а в наличии " + searchQuantity(shop, prod));
        }
        else {
            System.out.println("В магазине " + shop.getName() + " в наличии " + searchQuantity(shop, prod)
                    + " " + prod.getName());
            int priceProd = (searchPrice(shop, prod)*quantity);
            shop.removeProducts(quantity, prod);

            System.out.println("Вы купили " + quantity + " " + prod.getName() + " за " + priceProd);
            System.out.println("В магазине " + shop.getName() + " осталось " +
                    searchQuantity(shop, prod) + " " + prod.getName());
        }
    }

    public void setProductsBuy (ArrayList<Shop> shops, HashMap<Integer, Product> setProd) {
        String whenShop = "";
        int minPriceAllShops = 999;
        int setPrice;
        int quantityYes;
        int quantity;
        Integer[] key = new Integer[setProd.size()];
        setProd.keySet().toArray(key);

        for (Shop shop : shops) {
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
