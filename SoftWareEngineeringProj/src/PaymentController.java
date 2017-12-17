/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Hesham
 */
public class PaymentController {
    private User LoggedUser= null;
    public Product SelectedProduct;
    private final PaymentView PaymentOptionsView=new PaymentView();
    private final PaymentModel model=new PaymentModel();
    private final OnDeliveryView cash_view=new OnDeliveryView();
    private final OnlineView online_view=new OnlineView();
    private final VoucherPaymentView voucherPayView = new VoucherPaymentView();
    private final ProductSelection selectedProductView ;
    
    public PaymentController(ProductSelection selectedProductView)
    {
        this.selectedProductView = selectedProductView;
        this.PaymentOptionsView.addCashListner(new cash_Listner());
        this.PaymentOptionsView.addOnlineListner(new online_listner());
        this.PaymentOptionsView.useVoucherView(new useVoucherListener());
        this.cash_view.CashListner(new pay_delivery());
        this.online_view.addCheckoutListner(new pay_online());
        this.voucherPayView.ApplyVoucherListener(new ApplyVoucherListener());
        this.voucherPayView.CancelListener(new CancelListener());
        this.selectedProductView.BuyLsitener(new buy_Listener());
        
    }
        class CancelListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            voucherPayView.setVisible(false);
            
        }
        
    }
    
    
    class buy_Listener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            PaymentOptionsView.setVisible(true);
        }
        
    }
    class useVoucherListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
             PaymentOptionsView.setVisible(false);
            voucherPayView.UpdateView(LoggedUser , SelectedProduct.Price);
            voucherPayView.setVisible(true);
        }
        
    }
    class ApplyVoucherListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            LoggedUser.ApplyVoucher(SelectedProduct);
        }
        
    }
    class cash_Listner implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e){
            cash_view.setVisible(true);
            PaymentOptionsView.setVisible(false);
        }

    }
    class online_listner implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            online_view.setVisible(true);
            PaymentOptionsView.setVisible(false);
        }

    }
    class pay_delivery implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String address=cash_view.getAddress();
            onDelivery cash=new onDelivery(address);
            if(model.pay(cash))
                PaymentOptionsView.done_msg();
            else
                PaymentOptionsView.error_msg();
        }


    }
    class pay_online implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String card_type=online_view.getCardType();
            String card_number=online_view.getCardNumber();
            String expired_date=online_view.getCardDate();
            online checkout=new online(card_type, card_number, expired_date);
            if(model.pay(checkout))
                PaymentOptionsView.done_msg();
            else
                PaymentOptionsView.error_msg();

        }


    }
    void setLogedinUSer(User user){
        this.LoggedUser=user;
    }
    
    
}
    
    
    

