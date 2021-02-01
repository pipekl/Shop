import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Analysis analysis = new Analysis();

        Shop magnit = new Shop("Magnit", "Moscow");
        Shop ashan = new Shop("Ashan", "Vladivostok");
        Shop ikea = new Shop("Ikea", "Tambov");

        // 3. Завезти партию товаров в магазин (набор товар-количество
        // с возможностью установить/измениь цену)
        magnit.addProducts(new Product("Apple"), 3, 21);
        magnit.addProducts(new Product("Bread"), 41, 26);
        magnit.addProducts(new Product("Cabbage"), 23, 9);
        magnit.addProducts(new Product("Carrot"), 12, 33);
        magnit.addProducts(new Product("Chocolate"), 8, 17);
        magnit.addProducts(new Product("Kiwi"), 13, 25);
        magnit.addProducts(new Product("Meat"), 15, 36);
        magnit.addProducts(new Product("Onion"), 19, 63);
        magnit.addProducts(new Product("Orange"), 24, 18);
        magnit.addProducts(new Product("Potato"), 52, 18);

        ashan.addProducts(new Product("Apple"), 25, 12);
        ashan.addProducts(new Product("Bread"), 51, 13);
        ashan.addProducts(new Product("Cabbage"), 26, 25);
        ashan.addProducts(new Product("Carrot"), 29, 14);
        ashan.addProducts(new Product("Chocolate"), 12, 26);
        ashan.addProducts(new Product("Kiwi"), 9, 44);
        ashan.addProducts(new Product("Meat"), 21, 9);
        ashan.addProducts(new Product("Onion"), 58, 35);
        ashan.addProducts(new Product("Orange"), 15, 19);
        ashan.addProducts(new Product("Potato"), 23, 23);

        ikea.addProducts(new Product("Apple"), 13, 31);
        ikea.addProducts(new Product("Bread"), 24, 23);
        ikea.addProducts(new Product("Cabbage"), 44, 8);
        ikea.addProducts(new Product("Carrot"), 3, 28);
        ikea.addProducts(new Product("Chocolate"), 7, 33);
        ikea.addProducts(new Product("Kiwi"), 16, 66);
        ikea.addProducts(new Product("Meat"), 34, 31);
        ikea.addProducts(new Product("Onion"), 15, 31);
        ikea.addProducts(new Product("Orange"), 73, 7);
        ikea.addProducts(new Product("Potato"), 36, 27);

        // 4. Найти магазин, в котором определенный товар самый дешевый
        ArrayList<Shop> shops = new ArrayList<>();
        shops.add(magnit);
        shops.add(ashan);
        shops.add(ikea);

        analysis.shopWithLowestPrice(shops, new Product("Apple"));
        analysis.shopWithLowestPrice(shops, new Product("Meat"));
        analysis.shopWithLowestPrice(shops, new Product("Potato"));
        System.out.println();

        // 5. Понять, какие товары можно купить в магазине на некоторую
        // сумму (например, на 100 рублей можно купить три кг огурцов
        // или две шоколадки)
        analysis.whatProductsCanBuy(magnit, 150);
        System.out.println();

        // 6. Купить партию товаров в магазине (параметры - сĸольĸо ĸаĸих
        // товаров ĸупить, метод возвращает общую стоимость поĸупĸи
        // либо её невозможность, если товара не хватает)
        analysis.buyProducts(magnit, 15, new Product("Potato"));
        System.out.println();
        analysis.buyProducts(ashan, 5, new Product("Onion"));
        System.out.println();
        analysis.buyProducts(ikea, 10, new Product("Carrot"));
        System.out.println();

        // 7. Найти, в ĸаĸом магазине партия товаров (набор товар-
        // ĸоличество имеет наименьшую сумму (в целом). Например, «в
        // ĸаĸом магазине дешевле всего ĸупить 10 гвоздей и 20
        // шурупов». Наличие товара в магазинах учитывается!
        HashMap<Integer, Product> setProd = new HashMap<>();
        setProd.put(10, new Product("Kiwi"));
        setProd.put(7, new Product("Onion"));
        setProd.put(5, new Product("Chocolate"));

        analysis.setProductsBuy (shops, setProd);
    }
}
