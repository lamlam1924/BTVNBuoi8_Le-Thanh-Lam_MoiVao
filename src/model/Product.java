
package model;

public class Product implements Comparable<Product>{

    private String name, id;
    private double price;

    public Product() {
    }
    
    

    public Product(String name, String id, double price) {
        this.name = name;
        this.id = id;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" + "productName = " + name + ", ProductID = " + id + ", Price = " + price + '}';
    }

    @Override
    public int compareTo(Product o) {
        return (int) (price - o.price);
    }
    
    
    
    
    
}
