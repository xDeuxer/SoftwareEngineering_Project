
import java.util.*;

/**
 * 
 */
public class CartController {

  
    public CartController() {
    }

    public Cart model;

    public CartView view;



    public void UpdateView() {
        view.AddProductsToView(model.getProducts());
        view.currentPrice = model.getTotalPrice();
    }

  
    public void UpdateCart() {
        // TODO implement here
    }

}