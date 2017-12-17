
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author YasserOsama
 */
public class BrandController {
    BrandAdditionView view;
    SiteProductsView sitePage;
    BrandsListView BrandsView;
    
    SiteProducts siteModel;
    
    public BrandController(BrandAdditionView view , SiteProductsView sitePage , SiteProducts siteModel ,BrandsListView BrandsView )
    {
        this.siteModel=siteModel;
        
        this.view=view;
        this.sitePage=sitePage;
        this.BrandsView=BrandsView;
        sitePage.goToBrandAdditionView(new BrandAdditionViewListener());
        sitePage.goToBrandsPageListener(new BrandsListViewListener());
        
        view.addBrandListner(new AddBrandListener());
        view.suggestBrandListner(new SuggestBrandListener());
        
        BrandsView.CancelListener(new cancelViewListener());
    }
     
    class cancelViewListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            BrandsView.setVisible(false);
        }
        
    }
    class BrandAdditionViewListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            view.setVisible(true);
        }
        
    }
    class BrandsListViewListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            BrandsView.setVisible(true);
        }
        
    }
    class AddBrandListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            Brand brand = new Brand ( view.getName() , view.getCompany());
            boolean isBrandAdded = siteModel.AddBrand(brand);
            if(isBrandAdded)
            {
                BrandsView.UpdateView(brand, null);
                view.setVisible(false);
            }
        }
        
    }
    
    class SuggestBrandListener implements ActionListener{

        
        @Override
        public void actionPerformed(ActionEvent e) {
            Brand brand = new Brand ( view.getName() , view.getCompany());
            boolean isBrandSuggestionAdded = siteModel.AddSuggestedBrand(brand);
            if(isBrandSuggestionAdded)
            {
                BrandsView.UpdateView(null, brand);
                view.setVisible(false);
            }
        }
        
    }
    public void setLoggedinUser(User user)
    {
        if(user.getType()=="Admin")
        {
            view.setbuttonsVisibility(true);
        }else{
            view.setbuttonsVisibility(false);
        }
        
    }
      
}
    

