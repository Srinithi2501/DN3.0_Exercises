

import java.util.Arrays;

class Product {
    private String productId;
    private String productName;
    private String category;

    public Product(String productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    // Getters
    public String getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId='" + productId + '\'' +
                ", productName='" + productName + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}

class SearchAlgorithms {

    // Linear search for a product by product name
    public static Product linearSearch(Product[] products, String productName) {
        for (Product product : products) {
            if (product.getProductName().equalsIgnoreCase(productName)) {
                return product;
            }
        }
        return null;
    }

    // Binary search for a product by product name
    public static Product binarySearch(Product[] products, String productName) {
        Arrays.sort(products, (p1, p2) -> p1.getProductName().compareToIgnoreCase(p2.getProductName()));
        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = products[mid].getProductName().compareToIgnoreCase(productName);

            if (comparison == 0) {
                return products[mid];
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return null;
    }
}

public class Ecommerce {
    public static void main(String[] args) {
        Product[] products = {
            new Product("001", "Laptop", "Electronics"),
            new Product("002", "Smartphone", "Electronics"),
            new Product("003", "Headphones", "Accessories"),
            new Product("004", "Coffee Maker", "Appliances"),
            new Product("005", "Desk Lamp", "Furniture")
        };

        String searchName = "Smartphone";

        // Linear search
        Product foundProductLinear = SearchAlgorithms.linearSearch(products, searchName);
        System.out.println("Linear Search Result: " + (foundProductLinear != null ? foundProductLinear : "Product not found"));

        // Binary search
        Product foundProductBinary = SearchAlgorithms.binarySearch(products, searchName);
        System.out.println("Binary Search Result: " + (foundProductBinary != null ? foundProductBinary : "Product not found"));
    }
}