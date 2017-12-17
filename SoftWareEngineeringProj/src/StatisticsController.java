
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hesham
 */
public class StatisticsController {
    SiteProductsView siteView=new SiteProductsView();
    StatisticsView statView=new StatisticsView();
    User loggeduser;
    public StatisticsController(SiteProductsView siteView,StatisticsView statView)
    {
        this.siteView=siteView;
        siteView.StatListener(new Slistner());
        this.statView.CancelListener(new CancelListener());

    }
        class CancelListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            statView.setVisible(false);
            
        }
        
    }
    class Slistner implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {
            statView.SetUserDetails(loggeduser);

            if(loggeduser.getType().equals("store owner"))
            {
                
                statView.setStoreOwnerSpecificDetails((StoreOwner)loggeduser);
                statView.StoreOwnerView();
            }
            else if(loggeduser.getType().equals("Admin")){
                statView.defaultView();
            }
            else{
                statView.setNormalUserSpecificDetails(loggeduser);
                statView.userView();
            }
            statView.setVisible(true);
        }
        
    }
    public void SetLoggedInUser(User user){
        loggeduser=user;
    }
}
