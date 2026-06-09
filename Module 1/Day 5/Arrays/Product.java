package arraysDemo;

public class Product implements Comparable<Product> {
    private int id;
    private String name;
    private String category;
    private String brand;
    private int price;
    private int discount;
    private int rating;

    public Product(int id, String name, String category, String brand, int price, int discount, int rating) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.brand = brand;
        this.price = price;
        this.discount = discount;
        this.rating=rating;
    }


    public String toString(){
        return id+ " " + name+ " " +category + " " + brand+ " " + price+ " "+ discount+ " "+ rating;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    @Override
    public int compareTo(Product o) {
        return 0;
    }
}
