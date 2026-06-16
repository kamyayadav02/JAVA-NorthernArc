package entity;

public class Product {
    private int productId;
    private String name;
    private String brand;
    private String category;

    public Product(int productId, String name, String brand, String category) {
        this.productId = productId;
        this.name = name;
        this.brand = brand;
        this.category = category;
    }

    public Product(String name, String brand, String category) {
        this.name = name;
        this.brand = brand;
        this.category = category;
    }

    public Product() {
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", category='" + category + '\'' +
                '}';
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
