// Product.java
public class Product implements Comparable<Product> {
    private Integer id;
    private String name;
    private double price;
    private int stock;

    // constructors, getters, setters, and toString method

    @Override
    public int compareTo(Product otherProduct) {
        return Double.compare(this.price, otherProduct.getPrice());
    }
}
