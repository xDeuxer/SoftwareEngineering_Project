
import java.util.*;


import java.util.ArrayList;
import javax.swing.JOptionPane;


public abstract class Store {
    public String name; 
    public String type;
    public ArrayList<Product>products = new ArrayList<Product>();
    Store(String name , String type )
    {
        this.name=name ; 
        this.type = type;
    }
    public void  addProduct(Product item){
        for(int i=0 ;i<products.size() ; i++)  //search to add by serial code
        {
            if (products.get(i).serialCode.equals(item.serialCode)){
                JOptionPane.showMessageDialog(null,"this product already exsits in the store ! ");
                return;
            }
        }
        products.add(item);
        JOptionPane.showMessageDialog(null, "Product added to : "+name);      

    }

    public  void showProducts()
    {
        System.out.println(products);
    }
}
