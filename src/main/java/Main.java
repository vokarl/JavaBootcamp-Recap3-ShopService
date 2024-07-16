import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ShopService myShop = new ShopService();

        List<String> productId = new ArrayList<>();
        productId.add("1");
        productId.add("1");
        Order newOrder = myShop.addOrder(productId);
        System.out.println(newOrder);
    }
}
