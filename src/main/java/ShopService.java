import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class ShopService {
    private ProductRepo productRepo = new ProductRepo();
    private OrderRepo orderRepo = new OrderMapRepo();

    public Order addOrder(List<String> productIds)throws ProductNotAvailableException {
        List<Product> products = new ArrayList<>();
        for (String productId : productIds) {
            Product productToOrder = productRepo.getProductById(productId).orElseThrow(()->new ProductNotAvailableException("Product with ID " + productId + " is not available."));
            products.add(productToOrder);
            }
        Order newOrder = new Order(UUID.randomUUID().toString(), products, Order.Status.PROCESSING, Instant.now());

        return orderRepo.addOrder(newOrder);
    }
    public List<Order> findAllOrders(Order.Status status){
        return orderRepo.findAllOrders(status);
    }

    public void updateOrder(String orderId, Order.Status newStatus){
    Order oldOrder = orderRepo.getOrderById(orderId);
    orderRepo.removeOrder(orderId);
    Order newOrder = oldOrder.withStatus(newStatus);
    orderRepo.addOrder(newOrder);
    }

}
