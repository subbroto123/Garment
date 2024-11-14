import java.util.ArrayList;
import java.util.List;
import java.util.Date;


class Garment {
    public String id;
    public String name;
    public String description;
    public String size;
    public String color;
    public double price;
    public int stockQuantity;

 // Update stock method
    void updateStock(int quantity) {
        this.stockQuantity = quantity;
    }

  // Calculate discount price (price after discount)
    double calculateDiscountPrice(double discountPercentage) {
        double discount = price * (discountPercentage / 100);
        return price - discount;  // Discounted price
    }
}

class Fabric {
    public String id;
    public String type;
    public String color;
    public double pricePerMeter;

    // Calculate fabric cost
    double calculateCost(double meters) {
        return pricePerMeter * meters;
    }
}

class Supplier {
    public String id;
    public String name;
    public String contactInfo;
    List<Fabric> suppliedFabric;

    // Constructor to initialize the supplied fabric list
    public Supplier() {
        suppliedFabric = new ArrayList<>();
    }

    // Add fabric to the supplied fabric list
    void addFabric(Fabric fabric) {
        suppliedFabric.add(fabric);
    }

    // Get all supplied fabrics
    List<Fabric> getSuppliedFabrics() {
        return suppliedFabric;
    }
}

class Order {
    public String orderId;
    public Date orderDate;
    public List<Garment> garments = new ArrayList<>();
    private double totalAmount;

    // Add a garment to the order
    void addGarment(Garment garment) {
        garments.add(garment);
    }

    // Calculate total order amount
    double calculateTotalAmount() {
        totalAmount = 0;  
        for (Garment g : garments) {
            totalAmount += g.price;
        }
        return totalAmount;
    }

    // Print order details
    void printOrderDetails() {
        System.out.println("*********************");
        System.out.println("Order Details");
        System.out.println("**********************");
        for (Garment g : garments) {
            System.out.println("Name: " + g.name);
            System.out.println("Price: " + g.price);
            System.out.println("Description: " + g.description);
            System.out.println("--------------------------");
        }
    }
}

class Customer {
    public String customerId;
    public String name;
    public String email;
    public String phone;

    // Place an order and print the order details
    void placeOrder(Order order) {
        order.printOrderDetails();
        System.out.println("Order Placed");
    }
}

class Inventory {
    List<Garment> garments;

    // Constructor to initialize the garments list
    public Inventory() {
        garments = new ArrayList<>();
    }

    // Add a garment to the inventory
    void addGarment(Garment garment) {
        garments.add(garment);
    }

    // Remove a garment by its ID
    void removeGarment(String id) {
        Garment garmentToRemove = findGarment(id);
        if (garmentToRemove != null) {
            garments.remove(garmentToRemove);
            System.out.println("Garment with ID " + id + " removed from inventory.");
        } else {
            System.out.println("Garment with ID " + id + " not found.");
        }
    }

    // Find a garment by its ID
    Garment findGarment(String id) {
        for (Garment g : garments) {
            if (g.id.equals(id)) {
                return g;
            }
        }
        return null;
    }
}

public class GarmentMinilabProject {
    public static void main(String[] args) {
        // Creating a garment
        Garment g1 = new Garment();
        g1.id = "D0001";
        g1.name = "Shirt";
        g1.description = "Best Product";
        g1.price = 1000;

        // Calculate discount price
        double discountedPrice = g1.calculateDiscountPrice(10);
        System.out.println("Discounted price: " + discountedPrice);

        // order and add garments to it
        Order order = new Order();
        order.addGarment(g1);

        // Print order details
        order.printOrderDetails();

        // Calculate total 
        double totalAmount = order.calculateTotalAmount();
        System.out.println("Total Amount: " + totalAmount);
    }
}
