import java.util.ArrayList;
import java.util.List;


class Product {
    private String name;
    private double price;
    private int quantity;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

 
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}


class Customer {
    private String name;
    private String email;

    public Customer(String name, String email) {
        this.name = name;
        this.email = email;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}


class Seller {
    private String name;
    private String companyName;

    public Seller(String name, String companyName) {
        this.name = name;
        this.companyName = companyName;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}

class Purchase {
    private Customer customer;
    private Product product;
    private int quantity;

    public Purchase(Customer customer, Product product, int quantity) {
        this.customer = customer;
        this.product = product;
        this.quantity = quantity;
    }


    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}


public class StoreManagementSystem {
    private List<Product> products = new ArrayList<>();
    private List<Purchase> purchaseHistory = new ArrayList<>();


    public void addProduct(Product product) {
        products.add(product);
    }


    public void updateProduct(String productName, double price, int quantity) {
        for (Product product : products) {
            if (product.getName().equals(productName)) {
                product.setPrice(price);
                product.setQuantity(quantity);
                break;
            }
        }
    }

    public void displayProducts() {
        for (Product product : products) {
            System.out.println("Product: " + product.getName() + ", Price: $" + product.getPrice() + ", Quantity: " + product.getQuantity());
        }
    }

    public void recordPurchase(Customer customer, Product product, int quantity) {
        Purchase purchase = new Purchase(customer, product, quantity);
        purchaseHistory.add(purchase);
    }

    public void displayPurchaseHistory() {
        for (Purchase purchase : purchaseHistory) {
            System.out.println("Customer: " + purchase.getCustomer().getName() + ", Product: " + purchase.getProduct().getName() + ", Quantity: " + purchase.getQuantity());
        }
    }

    public static void main(String[] args) {
        StoreManagementSystem store = new StoreManagementSystem();

     
        Product product1 = new Product("Laptop", 999.99, 10);
        Product product2 = new Product("Smartphone", 599.99, 20);

        store.addProduct(product1);
        store.addProduct(product2);


        store.updateProduct("Laptop", 899.99, 5);

  
        store.displayProducts();

     
        Customer customer = new Customer("John Doe", "john@example.com");
        Product purchasedProduct = product1; // Assuming the customer purchased a Laptop
        int quantityPurchased = 2;
        store.recordPurchase(customer, purchasedProduct, quantityPurchased);

        store.displayPurchaseHistory();
    }
}
