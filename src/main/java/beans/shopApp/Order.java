package beans.shopApp;

import java.util.ArrayList;
import java.util.List;

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
        return String.format("%.02f zł.",value);
    }
}
