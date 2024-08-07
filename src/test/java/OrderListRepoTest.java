import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderListRepoTest {

    @Test
    void getOrders() {
        //GIVEN
        OrderListRepo repo = new OrderListRepo();

        Product product = new Product("1", "Apfel");
        Order newOrder = new Order("1", List.of(product), Order.Status.PROCESSING);
        repo.addOrder(newOrder);

        //WHEN
        List<Order> actual = repo.getOrders();

        //THEN
        List<Order> expected = new ArrayList<>();
        Product product1 = new Product("1", "Apfel");
        expected.add(new Order("1", List.of(product1), Order.Status.PROCESSING ));

        assertEquals(expected, actual);
    }

    @Test
    void getOrderById() {
        //GIVEN
        OrderListRepo repo = new OrderListRepo();

        Product product = new Product("1", "Apfel");
        Order newOrder = new Order("1", List.of(product), Order.Status.PROCESSING);
        repo.addOrder(newOrder);

        //WHEN
        Order actual = repo.getOrderById("1");

        //THEN
        Product product1 = new Product("1", "Apfel");
        Order expected = new Order("1", List.of(product1), Order.Status.PROCESSING);

        assertEquals(expected, actual);
    }

    @Test
    void addOrder() {
        //GIVEN
        OrderListRepo repo = new OrderListRepo();
        Product product = new Product("1", "Apfel");
        Order newOrder = new Order("1", List.of(product), Order.Status.PROCESSING);

        //WHEN
        Order actual = repo.addOrder(newOrder);

        //THEN
        Product product1 = new Product("1", "Apfel");
        Order expected = new Order("1", List.of(product1), Order.Status.PROCESSING);
        assertEquals(expected, actual);
        assertEquals(expected, repo.getOrderById("1"));
    }

    @Test
    void removeOrder() {
        //GIVEN
        OrderListRepo repo = new OrderListRepo();

        //WHEN
        repo.removeOrder("1");

        //THEN
        assertNull(repo.getOrderById("1"));
    }
    @Test
    void findAllOrders(){
        //GIVEN
        OrderListRepo repo = new OrderListRepo();
        repo.addOrder(new Order("1", List.of(), Order.Status.PROCESSING));
        Order orderA = new Order("2", List.of(), Order.Status.IN_DELIVERY);
        repo.addOrder(orderA);
        Order orderB = new Order("3", List.of(), Order.Status.IN_DELIVERY);
        repo.addOrder(orderB);
        repo.addOrder(new Order("4", List.of(), Order.Status.DELIVERED));
        //WHEN
        List<Order> actual = repo.findAllOrders(Order.Status.IN_DELIVERY);
        //THEN
        assertEquals(List.of(orderA, orderB), actual);
    }
}
