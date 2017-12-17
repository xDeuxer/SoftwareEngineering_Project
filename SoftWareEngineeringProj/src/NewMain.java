
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
public class NewMain {

  public static void main(String args[])
    {
        // models Declaration
        SiteProducts SiteModel = new SiteProducts();
        Registeration RegisterationModel=new Registeration();
        
        //View Declaration
        StatisticsView stat_view=new StatisticsView();
        SiteProductsView sitePage = new SiteProductsView();
        ProductRegView Regview = new ProductRegView();
        StoreRegisterationView StoreRegview=new StoreRegisterationView();
        ProductSelection prodView = new ProductSelection();
        BrandAdditionView brandsAdditionView = new BrandAdditionView();
        BrandsListView SystemBrandsView = new BrandsListView();
        UsersListView usersView = new UsersListView();
        //controllers Declaration
        StatisticsController statCont=new StatisticsController(sitePage, stat_view);
        BrandController brandCtrl = new BrandController(brandsAdditionView ,sitePage ,SiteModel ,  SystemBrandsView);
        WebSiteController webSitecontroller = new WebSiteController(sitePage ,prodView);
        VoucherOperationController voucherCtrl= new VoucherOperationController(usersView , RegisterationModel , sitePage);
        StoreRegisterationController StoreRegCtrl=new StoreRegisterationController(StoreRegview, prodView , sitePage);
        PaymentController paymentCtrl = new PaymentController(prodView);
        ProductSelectionCtrl prodSelectCtrl = new ProductSelectionCtrl(prodView, sitePage , paymentCtrl);
        ProductRegisterCtrl ProductRegCtrl = new ProductRegisterCtrl(Regview ,sitePage ,SiteModel,prodSelectCtrl);


        
        while(true)
        {
            User LoggedInUser = null;
            RegisterationView v=new RegisterationView();
            UserRegisterationController c=new UserRegisterationController(RegisterationModel, v , usersView);

            while(LoggedInUser==null){
                System.out.println("no user registered");
                LoggedInUser=c.getLoggedUserType();
                if(LoggedInUser!=null)
                    break;
            }
            
            brandCtrl.setLoggedinUser(LoggedInUser);
            prodSelectCtrl.setLoggedinUser(LoggedInUser);
            StoreRegCtrl.setLoggedinUser(LoggedInUser);
            webSitecontroller.setLoggedinUser(LoggedInUser);
            paymentCtrl.setLogedinUSer(LoggedInUser);
            statCont.SetLoggedInUser(LoggedInUser);
            webSitecontroller.SetVisibilityOptions();
            webSitecontroller.isLoggedOut=false;
            
            

            while ( !webSitecontroller.isLoggedOut ){
                
                System.out.println("Current Logout state :"+webSitecontroller.isLoggedOut);
            }
            System.out.println("got out");
        
        }
       
    }
}
