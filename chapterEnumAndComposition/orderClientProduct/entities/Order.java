package FUNDAMENTALS.enumEComposicao.orderClientProduct.entities;

import FUNDAMENTALS.enumEComposicao.orderClientProduct.entities.enums.OrderStatus;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {

    private Date momment;
    private OrderStatus status;
    private List<OrderItem> items  = new ArrayList<>();

    Client client;

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    public Order(Date momment, OrderStatus status, Client client) {
        this.momment = momment;
        this.status = status;
        this.client = client;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public Date getMomment() {
        return momment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public void addItem(OrderItem item){
        items.add(item);
    }

    public void removeItem(OrderItem item){
        items.remove(item);
    }

    public Double total(){
        double sum = 0.0;
        for(OrderItem i : items){
            sum += i.subTotal();
        }
        return sum;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Order moment: ");
        sb.append(sdf.format(momment) + "\n");
        sb.append("Order status: ");
        sb.append(status + "\n");
        sb.append("Client: ");
        sb.append(client + "\n");
        sb.append("Order items:\n");
        for (OrderItem item : items) {
            sb.append(item + "\n");
        }
        sb.append("Total price: $");
        sb.append(String.format("%.2f", total()));
        return sb.toString();
    }
}
