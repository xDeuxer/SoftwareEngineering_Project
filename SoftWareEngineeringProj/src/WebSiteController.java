import java.awt.event.ActionEvent;
import java.awt.event.ActionEvent;
import java.util.*;
import java.awt.event.ActionListener;
import javax.swing.*;
/**
 * 
 */
public class WebSiteController {

    public SiteProductsView SiteView;   
    public ProductSelection productSelectionView;
    
    public boolean isLoggedOut=false;
    public static User LoggedinUser;
    public WebSiteController(SiteProductsView SiteView , ProductSelection productSelectionView) {
        this.SiteView = SiteView;
        this.productSelectionView=productSelectionView;
        this.SiteView.LogoutListener(new LogoutListener());
    }

    
    class LogoutListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            SiteView.DefaultSiteView();

            productSelectionView.getDropDown().removeAllItems();
            productSelectionView.setAddToStoreButtonOptions(false);
            isLoggedOut = true;
        }
        
    }
    public void SetVisibilityOptions(){
        if(LoggedinUser.getType().equals("store owner"))
        {
            //stat_view.StoreOwnerView();
            SiteView.AddStore.setVisible(true);
            productSelectionView.setAddToStoreButtonOptions(true);

        }else if(LoggedinUser.getType().equals("Admin")){
            //stat_view.defaultView();
            SiteView.SuggestBrand.setVisible(false);
            SiteView.AddBrand.setVisible(true);
            SiteView.AddProduct.setVisible(true);
            SiteView.GrantVoucher.setVisible(true);

        }else{
            productSelectionView.setAddToStoreButtonOptions(false);
        }
        SiteView.setVisible(true);
    }
         
    public void setLoggedinUser(User user)
    {
        LoggedinUser = user;
    }
   
    
}