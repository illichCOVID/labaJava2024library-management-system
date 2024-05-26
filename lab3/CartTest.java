import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CartTest {
    private Cart cart;
    private Product product1;
    private Product product2;

    @BeforeEach
    public void setUp() {
        cart = new Cart();
        product1 = new Product(1, "Phone", 500);
        product2 = new Product(2, "Laptop", 1000);
    }

    @Test
    public void testAddProduct() {
        cart.addProduct(product1);
        cart.addProduct(product2);
        assertEquals(2, cart.getProducts().size());
        assertTrue(cart.getProducts().contains(product1));
        assertTrue(cart.getProducts().contains(product2));
    }

    @Test
    public void testRemoveProduct() {
        cart.addProduct(product1);
        cart.addProduct(product2);
        cart.removeProduct(product1);
        assertEquals(1, cart.getProducts().size());
        assertFalse(cart.getProducts().contains(product1));
        assertTrue(cart.getProducts().contains(product2));
    }
}
