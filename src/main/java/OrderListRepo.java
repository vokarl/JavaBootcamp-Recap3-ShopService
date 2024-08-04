import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class OrderListRepo implements OrderRepo{
    private List<Order> orders = new ArrayList<>();

    public List<Order> getOrders() {
        return orders;
    }

    public Order getOrderById(String id) {
        for (Order order : orders) {
            if (order.id().equals(id)) {
                return order;
            }
        }
        return null;
    }



    public Order addOrder(Order newOrder) {
        orders.add(newOrder);
        return newOrder;
    }

    public void removeOrder(String id) {
        for (Order order : orders) {
            if (order.id().equals(id)) {
                orders.remove(order);
                return;
            }
        }
    }

    @Override
    public List<Order> findAllOrders(Order.Status status) {
        return orders.stream()
                .filter(order -> order.status() == status) //order - aus alle order suche
                                        // -> order mit dem status == status vom paramete
                .toList();
    }
}
