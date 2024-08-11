import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ShopServiceTest {

    @Test
    void addOrderTest() throws ProductNotAvailableException {
        //GIVEN
        ShopService shopService = new ShopService();
        List<String> productsIds = List.of("1");

        //WHEN
        Order actual = shopService.addOrder(productsIds);

        //THEN
        Order expected = new Order("-1", List.of(new Product("1", "Apfel")), Order.Status.PROCESSING);
        assertEquals(expected.products(), actual.products());
        assertNotNull(expected.id());
    }

    @Test
    void addOrderTest_whenInvalidProductId_expectException() {
        //GIVEN
        ShopService shopService = new ShopService();
        List<String> productsIds = List.of("invalid", "invalid");    /*List<String> productsIds = List.of("1", "2");*/

        //WHEN
        try {
            shopService.addOrder(productsIds);
            //Exception not thrown
            fail("expected ProductNotAvailableException not thrown, even though product not available");
        }catch(ProductNotAvailableException e){
           //all good: expected exception was thrown

        }
    }
}
