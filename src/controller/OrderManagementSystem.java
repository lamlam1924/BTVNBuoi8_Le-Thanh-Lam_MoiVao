package controller;

import View.Menu;
import View.Utils;
import model.Customer;
import model.Order;
import model.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class OrderManagementSystem extends Menu {

    private Scanner sc = new Scanner(System.in);
    private List<Product> productList;
    private List<Order> orderList;

    static String[] mainArr = {
        "Add a new product to the Store",
        "Update price for a particular product",
        "List all available products in the Store",
        "Create a new Order",
        "Print information of an Order by Order ID",
        "Sort all products by product price as ascending",
        "Print all information of all Customers (Name, Sex, Language)",
        "Quit"
    };

    public OrderManagementSystem() {
        super("Order Management System", mainArr);
        this.productList = new ArrayList<>();
        this.orderList = new ArrayList<>();
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                addProduct();
                break;
            case 2:
                updateProductPrice();
                break;
            case 3:
                listProducts();
                break;
            case 4:
                createOrder();
                break;
            case 5:
                printOrderById();
                break;
            case 6:
                sortProductsByPrice();
                break;
            case 7:
                printAllCustomers();
                break;
            case 8:
                System.out.println("Tam biet!");
                System.exit(0);
                
        }
    }

    private void addProduct() {
        String name = Utils.getValue("Enter product name: ");
        String id = Utils.getValue("Enter product ID: ");
        double price = Double.parseDouble(Utils.getValue("Enter product price: "));
        Product product = new Product(name, id, price);
        productList.add(product);
        System.out.println("Product added successfully.");
    }

    private void updateProductPrice() {
        String productId = Utils.getValue("Enter product ID to update: ");
        double newPrice = Double.parseDouble(Utils.getValue("Enter new product price: "));
        for (Product product : productList) {
            if (product.getId().equals(productId)) {
                product.setPrice(newPrice);
                System.out.println("Product price updated successfully.");
                return;
            }
        }
        System.out.println("Product with ID " + productId + " not found.");
    }

    private void listProducts() {
        System.out.println("List of all available products in the store:");
        for (Product product : productList) {
            System.out.println(product);
        }
    }

    private void createOrder() {
        String orderId = Utils.getValue("Enter order ID: ");
        String date = Utils.getValue("Enter order date: ");
        String customerName = Utils.getValue("Enter customer name: ");
        String customerAge = Utils.getValue("Enter customer age: ");
        String customerSex = Utils.getValue("Enter customer sex: ");
        String customerCountry = Utils.getValue("Enter customer country (USA/VN/JP): ");
        Customer customer = new Customer(customerCountry, customerName, customerAge, customerSex);

        List<Product> products = new ArrayList<>();
        while (true) {
            String productName = Utils.getValue("Enter product name (or type 'done' to finish): ");
            if (productName.equalsIgnoreCase("done")) {
                break;
            }
            String productId = Utils.getValue("Enter product ID: ");
            double price = Double.parseDouble(Utils.getValue("Enter product price: "));
            Product product = new Product(productName, productId, price);
            products.add(product);
        }

        Order order = new Order(orderId, date, customer, products);
        orderList.add(order);
        System.out.println("Order created successfully.");
    }

    private void printOrderById() {
        String orderId = Utils.getValue("Enter order ID to print: ");
        for (Order order : orderList) {
            if (order.getId().equals(orderId)) {
                System.out.println(order);
                return;
            }
        }
        System.out.println("Order with ID " + orderId + " not found.");
    }

    private void sortProductsByPrice() {
        Collections.sort(productList);
        System.out.println("Products sorted by price in ascending order:");
        for (Product product : productList) {
            System.out.println(product);
        }
    }

    private void printAllCustomers() {
        System.out.println("Information of all customers:");
        for (Order order : orderList) {
            System.out.println(order.getCustomer());
        }
    }

    public static void main(String[] args) {
        OrderManagementSystem mainobj = new OrderManagementSystem();
        mainobj.run();
    }
}
