import Products.*;
import Shops.*;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Magnit magnit = new Magnit();
        Ashan ashan = new Ashan();
        Ikea ikea = new Ikea();
        Analysis analysis = new Analysis();

        //3. Добавляем товары в магазины
        magnit.addAllProducts();
        ashan.addAllProducts();
        ikea.addAllProducts();

        System.out.println("4. Узнать цену и количество определенного товара");
        analysis.priceProduct(magnit, new Orange());
        analysis.priceProduct(ashan, new Orange());
        analysis.priceProduct(ikea, new Orange());
        System.out.println();

        System.out.println("4. В каком магазине минимальная цена на определенный товар");
        analysis.lowPrice(magnit, ashan, ikea, new Orange());
        System.out.println();

        System.out.println("5. Сколько товара можно купить на определенную сумму");
        analysis.whatProductsCanBuy(magnit, 100);
        System.out.println();

        System.out.println("6. Купить 5 товара в магазине, если это возможно");
        analysis.buyProducts(magnit, 5, new Meat());
        System.out.println();
        analysis.buyProducts(ashan, 5, new Meat());
        System.out.println();
        analysis.buyProducts(ikea, 5, new Meat());
        System.out.println();

        System.out.println("7. В каком магазине можно купить набор товаров дешевле всего");
        ArrayList<Shops> arrShops = new ArrayList<>();
        arrShops.add(magnit);
        arrShops.add(ashan);
        arrShops.add(ikea);

        HashMap<Integer, Products> setProd = new HashMap<>();
        setProd.put(1, new Kiwi());
        setProd.put(7, new Onion());
        setProd.put(5, new Chocolate());

        analysis.setProductsBuy (arrShops, setProd);
    }
}
