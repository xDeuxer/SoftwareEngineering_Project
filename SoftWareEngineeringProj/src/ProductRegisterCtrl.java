
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
public class ProductRegisterCtrl {
        public ProductRegView RegView ;
        public SiteProductsView SiteView;
        public SiteProducts Sitemodel;
        ProductSelectionCtrl ProdSelectionCtrl;

         ProductRegisterCtrl(ProductRegView RegView ,SiteProductsView SiteView , SiteProducts model ,ProductSelectionCtrl ProdSelectionCtrl)


         {
             this.ProdSelectionCtrl=ProdSelectionCtrl;
             this.Sitemodel=model;
             
             this.RegView=RegView;
             this.RegView.AddListener(new AddProductListener());
             
             this.SiteView=SiteView;
             this.SiteView.goToAddProductPageListener(new goToAddProductPageListener());

         }
         
        class AddProductListener implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {

                    Product item = new Product(RegView.getName(),RegView.getPrice() ,RegView.getBrand() , RegView.getCategory() ,RegView.getID() );
                    boolean isProductAdded =    Sitemodel.AddProduct(item);
                    if(isProductAdded)
                    {

                        updateSiteView(item , ProdSelectionCtrl);
                        RegView.setVisible(false);

                   }

            }
        }
        class goToAddProductPageListener implements ActionListener{

                @Override
                public void actionPerformed(ActionEvent e) {
                    RegView.setVisible(true);
                }

        
        }
        
        
        public void updateSiteView(Product item ,ProductSelectionCtrl ProdSelectionCtrl)
        {
            SiteView.AddProductsToView(item , ProdSelectionCtrl);
        }

    

        
}

