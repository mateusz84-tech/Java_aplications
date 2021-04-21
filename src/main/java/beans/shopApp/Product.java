package beans.shopApp;

import org.springframework.stereotype.Component;

@Component
public class Product {

    private String productName;
    private int quantity;
    private double price;

    public Product(String productName, int quantity, double price) {
        if(productName.isBlank() || productName.isEmpty()){
            throw new IllegalArgumentException("Nazwa nie może być pusta.");
        }
        if(quantity < 0){
            throw new IllegalArgumentException("Ilość nie może być mniejsza od zera.");
        }
        if(price < 0.0){
            throw new IllegalArgumentException("Cena nie może być mniejsza od zera.");
        }
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }
    // metoda zwracająca wartość pozycji zamówienia
    public double calculateValue(){
        return getPrice() * getQuantity();
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if(quantity < 0){
            throw new IllegalArgumentException("Ilość nie może być ujemna.");
        }
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if(price < 0.0){
            throw new IllegalArgumentException("Cena nie może być ujemna.");
        }
        this.price = price;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName (String productName) {
        this.productName = productName;
    }

    @Override
    public String toString(){
        return String.format("%s %15.02f zł %4d szt. %10.02f zł.%n",
                getProductName(),getPrice(), getQuantity(),calculateValue());
    }
}
