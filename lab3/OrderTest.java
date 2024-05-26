import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

public class OrderTest {
    private Order order;
    private Product product1;
    private Product product2;
    private List<Product> productList;

    @BeforeEach
    public void setUp() {
        product1 = new Product(1, "Phone", 500);
        product2 = new Product(2, "Laptop", 1000);
        productList = new ArrayList<>();
        productList.add(product1);
        productList.add(product2);
        order = new Order(1, productList);
    }

    @Test
    public void testGetOrderId() {
        assertEquals(1, order.getOrderId());
    }

    @Test
    public void testGetProducts() {
        assertEquals(2, order.getProducts().size());
        assertTrue(order.getProducts().contains(product1));
        assertTrue(order.getProducts().contains(product2));
    }

    @Test
    public void testGetStatus() {
        assertEquals("Pending", order.getStatus());
    }

    @Test
    public void testSetStatus() {
        order.setStatus("Completed");
        assertEquals("Completed", order.getStatus());
    }
}
