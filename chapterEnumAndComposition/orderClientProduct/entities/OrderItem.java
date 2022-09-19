package FUNDAMENTALS.enumEComposicao.orderClientProduct.entities;

import java.util.ArrayList;
import java.util.List;

public class OrderItem {

    private Double price;
    private Product products;
    private Integer quantity;
    private List<Product> product = new ArrayList<>();

    public Product getProducts() {
        return products;
    }
    public void setProducts(Product products) {
        this.products = products;
    }
    public OrderItem(Double price, Integer quatity, Product products) {
        this.price = price;
        this.quantity = quatity;
        this.products = products;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuatity() {
        return quantity;
    }

    public void setQuatity(Integer quatity) {
        this.quantity = quatity;
    }

    public  Double subTotal(){
        return price * quantity;
    }

    public String toString() {
        return getProducts().getName()
                + ", $"
                + String.format("%.2f", price)
                + ", Quantity: "
                + quantity
                + ", Subtotal: $"
                + String.format("%.2f", subTotal());
    }
}
