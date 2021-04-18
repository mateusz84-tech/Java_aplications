package beans.shopApp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Stream;

public class Order {

    private List<Product> productsList;
    private int numberOfProduct;
    public Order(){
        productsList = new ArrayList<>();
        this.numberOfProduct = 0;
    }

    public void addProduct(Product product){
        productsList.add(product);
        numberOfProduct++;
        System.out.println("Dodano nową pozycję");
        System.out.println(product.toString());
    }

    public String calculateOrderValue(){
        double value = 0;
        for(Product price : productsList){
            value += price.calculateValue();
        }
        return String.format("%s %40.02f zł.","Razem",value);
    }
    // metoda usuwająca pozycję z listy
    public void deleteProduct(String name){
        for(Product product : productsList){
            if(!product.getProductName().equals(name)){
                break;
            }
        }
        productsList.removeIf(products -> products.getProductName().equals(name));
    }

    // metoda edytująca dane produktu
    public void editProduct(String name) {
        for (Product products : productsList) {
            if (products.getProductName().equalsIgnoreCase (name)) {
                Scanner input = new Scanner (System.in);
                System.out.print ("Podaj nową nazwę produktu: ");
                String productName = input.next ();
                System.out.print ("Podaj ilość: ");
                int quantity = input.nextInt ();
                System.out.print ("Podaj cenę: ");
                double price = input.nextDouble ();
                products.setProductName (productName);
                products.setQuantity (quantity);
                products.setPrice (price);
                System.out.println("Zaktualizowano produkt.");
            }
        }
    }



}
