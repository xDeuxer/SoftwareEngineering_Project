
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author YasserOsama
 */
public class ProductSelectionCtrl {
        Product selectedItem ;
        
        ProductSelection prodView;
        SiteProductsView SiteView;
        PaymentController paymentCtrl;
        
        User LoggedUser;
        ProductSelectionCtrl(ProductSelection prodView , SiteProductsView SiteView , PaymentController paymentCtrl ){
            this.prodView=prodView;
            this.SiteView=SiteView;
            this.paymentCtrl=paymentCtrl;
            this.prodView.CancelListener(new CancelListener());
            this.prodView.AddtoStoreListener(new AddProducttoStoreListener());
            


        }
        
        
        class AddProducttoStoreListener implements ActionListener{    
            @Override
            public void actionPerformed(ActionEvent e) {
                if("store owner".equals(LoggedUser.getType())){
                    StoreOwner currentUser = (StoreOwner)LoggedUser;
                    for(int i =0 ; i<currentUser.my_stores.size() ; i++){
                        String currentStoreName= currentUser.my_stores.get(i).name;
                        if(prodView.getDropDown().getSelectedItem()==currentStoreName){
                            currentUser.my_stores.get(i).addProduct(selectedItem);
                            prodView.setVisible(false);
                            return;
                        }
                    }
                    JOptionPane.showMessageDialog(null, "No Stores Found , please add a store first !");
                }
            }
        
        }
        
        class SelectProductListener implements ActionListener{

            @Override
            public void actionPerformed(ActionEvent e) {
                Object event = e.getSource();
                for( int i =0 ; i < SiteView.selectButtons.size() ; i++){
                    if(SiteView.selectButtons.get(i).selectedButton == event){
                        selectedItem = SiteView.selectButtons.get(i).selectedProduct; 
                        paymentCtrl.SelectedProduct=selectedItem;
                        selectedItem.incrementOrderedCounter();
                        prodView.updateView(selectedItem);
                        prodView.setVisible(true);
                    }

                }

            }
        }
        
        
          
    class CancelListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            prodView.setVisible(false);
            
        }
        
    }
    
    
    public void AddActionToSelectButtons(Product.SelectButton selectButton){

               selectButton.selectedButton.addActionListener(new SelectProductListener());

    }
    
    public void setLoggedinUser(User user)
    {
        LoggedUser = user;
       
    }
}
