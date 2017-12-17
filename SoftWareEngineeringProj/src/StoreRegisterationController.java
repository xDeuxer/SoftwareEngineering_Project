
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;


public class StoreRegisterationController {
        StoreOwner StoreOwner;
        StoreRegisterationView StoreRegView;
        SiteProductsView SiteView;   
        ProductSelection prodView;
        
        public StoreRegisterationController(StoreRegisterationView view , ProductSelection prodView ,SiteProductsView SiteView)  

        {
            this.StoreRegView=view;
            this.StoreRegView.addListner(new StoreRegisterListner());

            this.prodView=prodView;
            
            this.SiteView=SiteView;
            this.SiteView.goToStoreRegisterationListener(new StoreRegListener());

        }
        class StoreRegisterListner implements ActionListener
        {
            @Override
            public void actionPerformed(ActionEvent arg0)
            {
                String storeName=StoreRegView.getStoreName();
                String storeType=StoreRegView.getStoreType();
                String ADD_URL=StoreRegView.getStoreADD_URL();
                boolean isStoreAdded = StoreOwner.addStore(storeName, storeType, ADD_URL);
                if(isStoreAdded)
                {
                    JOptionPane.showMessageDialog(null, "Store added successfully !");
                    addStoreToDropDown(storeName);
                    StoreRegView.setVisible(false);
                }
                
            }
        }
        
        
        
        
        class StoreRegListener implements ActionListener{      
            @Override
            public void actionPerformed(ActionEvent e) {
                StoreRegView.setVisible(true);
            }

        }
        
        public void addStoreToDropDown(String StoreName){
            prodView.getDropDown().addItem(StoreName);
        }
        
        public void setLoggedinUser(User user)
        {
            if(user.getType().equals("store owner"))
                 this.StoreOwner = (StoreOwner)user;
        }
        
    }

