package FUNDAMENTALS.enumEComposicao.orderClientProduct.application;

import FUNDAMENTALS.enumEComposicao.orderClientProduct.entities.Client;
import FUNDAMENTALS.enumEComposicao.orderClientProduct.entities.Order;
import FUNDAMENTALS.enumEComposicao.orderClientProduct.entities.OrderItem;
import FUNDAMENTALS.enumEComposicao.orderClientProduct.entities.Product;
import FUNDAMENTALS.enumEComposicao.orderClientProduct.entities.enums.OrderStatus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat ("dd/MM/yyyy");
        LocalDateTime now  =  LocalDateTime.now();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter client data: ");
        System.out.print("Name: ");
        String clientName = scanner.next();
        System.out.print("E-mail: ");
        String clientEmail =scanner.next();
        System.out.print("Birth date (DD/MM/YYYY): ");
        Date clientBirthDate = sdf.parse(scanner.next());
        Client client = new Client(clientName, clientEmail, clientBirthDate);

        System.out.println("\nEnter order data: ");
        System.out.print("Status: ");
        String orderStatus = scanner.next();

        Order order = new Order(new Date(), OrderStatus.valueOf(orderStatus), client);

        System.out.println("How many items to this order? ");
        int n = scanner.nextInt();

        for ( int i = 0; i < n; i++){

            System.out.println("\nEnter #" + (i + 1) + " item data: ");
            System.out.print("Product name: ");
            String productName = scanner.next();
            System.out.print("Product price: ");
            double productPrice = scanner.nextDouble();
            System.out.print("Quantity: ");
            int productQuantity = scanner.nextInt();

            Product product = new Product(productName, productPrice);
            OrderItem orderItem = new OrderItem(productPrice, productQuantity, product);
            order.addItem(orderItem);
        }

        System.out.println();
        System.out.println("Order summary: ");
        System.out.println(order);

        scanner.close();

    }
}
