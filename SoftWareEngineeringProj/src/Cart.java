
import java.util.*;

/**
 * 
 */
public class Cart {


    public Cart() {
    }

    public ArrayList<Product> products = new ArrayList<Product> ();

    public double totalPrice;

    public double getTotalPrice() {
        // TODO implement here
        return totalPrice;
    }

    public void AddItem(Product item ) {
        products.add(item);
        
    }

    public void RemoveItem(Product item) {
        // TODO implement here
    }

  
    public ArrayList<Product> getProducts() {
        // TODO implement here
        return products;
    }
    

  
    /*public void Apply_vocher(voucher v) {
        // TODO implement here
    }*/

}