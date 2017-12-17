
import java.util.*;

/**
 * 
 */
public class Admin extends User {



    public SiteProducts Products;

    public Registeration Database;

    /**
     *
     */
    public Admin(String name,String email,String password,String type) {
        super(name , email , password , type);
    }



    public void addNewBrand() {
        // TODO implement here
    }

  
    public void addNewProduct() {
        // TODO implement here
    }

 
    public void suspendAccount(User u) {
        // TODO implement here
    }

}