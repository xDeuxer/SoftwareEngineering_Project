
import java.util.*;
import javax.swing.*;
/**
 * 
 */
public class Product {

    Product(){}
    
      public Product(String name, String price,String brandName , String category , String serialCode) {
        this.name=name;
        this.Price = price;
        this.brandName=brandName;
        this.category = category ;
        this.serialCode=serialCode;
        }
    Product thisProduct = this;
    
    public String name;

    public String Price;

    public String category;

    public String brandName;

    public int orderedCounter;
    
    public String serialCode;
    
    public SelectButton selectButton = new SelectButton();
    
    public void incrementOrderedCounter() {
        orderedCounter++;
    }
    public class SelectButton{
        public Product selectedProduct = thisProduct;
        public JButton selectedButton  = new JButton("Select Product");
        
    }

}