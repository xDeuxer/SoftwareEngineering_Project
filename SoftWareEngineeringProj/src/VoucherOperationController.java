import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class VoucherOperationController {
    UsersListView usersView ;
    Registeration Usersmodel;
    SiteProductsView siteView;
    VoucherOperationController(UsersListView usersView , Registeration model , SiteProductsView siteView){
        this.usersView=usersView;
        this.Usersmodel= model;
        this.siteView = siteView;
        this.usersView.GrantVoucherListener(new GrantVoucherListener());
        this.usersView.CancelListener(new cancelViewListener());
        this.siteView.goToGrantVoucherView(new gotoVoucherOperationListener() );
        
    }
    class gotoVoucherOperationListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            usersView.setVisible(true);
        }
        
    }
    class GrantVoucherListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String TypedinUsername = usersView.TypeUserName.getText();
            double VoucherValue = Double.valueOf(usersView.voucherValue.getText());
            Usersmodel.GrantVoucher(TypedinUsername , VoucherValue);
        }
        
    }
      class cancelViewListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            usersView.setVisible(false);
        }
        
    }
}
