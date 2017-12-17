
import java.util.*;
import java.awt.event.ActionListener;
import javax.swing.*;
/**
 * 
 */
public class CartView extends JFrame{

    /**
     * Default constructor
     */
    public CartView() {
        JPanel cartPanel = new JPanel();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600 , 200);
        cartPanel.setLayout(new BoxLayout(cartPanel,BoxLayout.Y_AXIS));
        for(int i = 0 ; i< ProductsView.size() ; i++)
        {
            cartPanel.add(ProductsView.get(i));
        }
        JLabel Cost = new JLabel("TotalCost ="+totalPrice.toString());
        cartPanel.add(Cost);
    }

    public ArrayList<JLabel> ProductsView;

    public JTextField totalPrice;

    public JButton CheckoutButton;

    public double currentPrice;
    
    void CheckoutListener(ActionListener listenforCheckout){
        CheckoutButton.addActionListener(listenforCheckout);
    }
   
    public void AddProductsToView(ArrayList<Product> Cartproducts) {
        ProductsView.clear();
        for(int i = 0  ; i < Cartproducts.size() ; i++)
            ProductsView.add(new JLabel(Cartproducts.get(i).name));
    }


    public void UpdatePrice(int price) {
        currentPrice += price;
        totalPrice.setText(Double.toString(currentPrice));
    }

}