
import java.util.*;
import javax.swing.JOptionPane;

/**
 * 
 */
public class User {
    private String username;
    private String email;
    private String password;
    private String type;
    private double balance;
    private Cart cart = new Cart(); 
    private double voucherValue;
    
    public User(String name,String password,String email,String type)
    {
        this.username=name;
        this.password=password; //setname+setpassword+setEmail
        this.email=email;
        this.type=type;
        balance= 1000;
    }
    public String getName(){
        return username;
    }
    public String getEmail()
    {
        return email;
    }
    public String getPassword()
    {
        return password;
    }
    public String getType(){
        return type;
    }
    public double getBalance(){
        return balance;
    }
    public double getVoucherValue(){
        return this.voucherValue;
    }
    public void GrantVoucher(double voucherValue)
    {
        this.voucherValue+=voucherValue;
    }
    public void ApplyVoucher(Product item)
    {
        double itemPrice = Double.valueOf(item.Price);
        double discountedPrice=0;
        if(voucherValue > itemPrice)
        {
            voucherValue -= itemPrice;
        }
        else
        {
            voucherValue=0;
            discountedPrice =itemPrice - voucherValue;
        }
        
        if(this.balance>discountedPrice)
        {

            this.balance-=discountedPrice;
            JOptionPane.showMessageDialog(null, "Product Purchased & added to cart");
            this.cart.AddItem(item);
            return;
        }
        JOptionPane.showMessageDialog(null, "balance not enough !");
    }
    public String[] getProductsNames()
    {
        
        String[] productNames={"empty"};
        if(!this.cart.products.isEmpty()){
            for(int i=0;i<this.cart.products.size();i++)
                productNames[i]+=this.cart.products.get(i).name;
        }
        return productNames;
    }

    public Double getTotalCost()
    {
        return this.cart.getTotalPrice();
    }
        
}
    
    

