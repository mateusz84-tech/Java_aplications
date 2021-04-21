package beans.shopApp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Order {

    private List<Product> productsList = new ArrayList<>();
    private int numberOfProduct;
    public Order(){
        this.productsList = List.of();
        this.numberOfProduct = 0;
    }

    // metoda dodająca produkt, w sytuacji gdy dodawany produkt już istnieje zostaje zwiększona ilość
    public void addProduct(Product product){

        for(Product item : productsList){
            if(item.getProductName().equalsIgnoreCase(product.getProductName())){
                item.setQuantity(item.getQuantity() + product.getQuantity());
            }
            else{
                productsList.add(product);
                numberOfProduct++;
                System.out.println("Dodano nową pozycję");
                System.out.println(product);
            }
        }
    }
    // metoda wyświetlająca wszystkie produkty w zamówieniu
    public void displayAllProductInOrder(){

        for(Product item : productsList){
            System.out.printf("%s %15.02f zł. %5d szt. %5.02f zł",
                    item.getProductName(),item.getPrice(),item.getQuantity(),(item.getQuantity()*item.getPrice()));
        }
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
