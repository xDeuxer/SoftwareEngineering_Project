
import java.util.*;
import javax.swing.JOptionPane;

/**
 * 
 */
public class SiteProducts {


    public SiteProducts() {
    }

    public ArrayList<Product> products = new ArrayList<Product>();
    public ArrayList<Brand> brands = new ArrayList<Brand>();
    public ArrayList<Brand> Suggestedbrands = new ArrayList<Brand>();
    
    public boolean AddProduct(Product item) {
                
        if(item.name.length()==0||item.Price.length()==0||item.serialCode.length()==0)
        {
            JOptionPane.showMessageDialog(null,"needed Fields are empty !");
            return false;
        }
        for(int i=0 ;i<products.size() ; i++)  //search to add by serial code
        {
            if (products.get(i).serialCode == item.serialCode){
                JOptionPane.showMessageDialog(null,"this product already exsits in the system ! ");
                return false;
            }
        }
        products.add(item);
        JOptionPane.showMessageDialog(null, item.name +" added to the system !");      
        return true;

    }
    public boolean AddBrand(Brand item){
        if(item.name.length()==0||item.company.length()==0)
        {
            JOptionPane.showMessageDialog(null, "all fields must be filled !");
            return false;
        }
        for(int i=0 ;i<brands.size() ; i++)  
        {
            if (brands.get(i).name == item.name){
                JOptionPane.showMessageDialog(null,"this brand already exsits in the system ! ");
                return false;
            }
        }
        brands.add(item);
        JOptionPane.showMessageDialog(null, item.name +" Brand added to the system !");  
        return true;

    }
    
    public boolean AddSuggestedBrand(Brand item){
        if(item.name.length()==0||item.company.length()==0)
        {
            JOptionPane.showMessageDialog(null, "all fields must be filled !");
            return false;
        }
        for(int i=0 ;i<brands.size() ; i++)  
        {
            if (brands.get(i).name == item.name ||Suggestedbrands.get(i).name==item.name ){
                JOptionPane.showMessageDialog(null,"this brand already exsits in the system ! ");
                return false;
            }
        }
        Suggestedbrands.add(item);
        JOptionPane.showMessageDialog(null, item.name +" Brand suggestion added to the system !");  
        return true;
    }

 
    

}