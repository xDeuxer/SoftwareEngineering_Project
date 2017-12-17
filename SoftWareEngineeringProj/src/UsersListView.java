import java.awt.BorderLayout;
import javax.swing.*;
import java.util.*;
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
public class UsersListView extends JFrame{
     
        public JPanel usersPanel ;
        public JPanel GrantVoucherPanel;
        public JButton GrantVoucher = new JButton("Grant Voucher");
        public JButton Cancel = new JButton("Cancel");
        public JLabel userName = new JLabel("UserName :");
        public JTextField TypeUserName = new JTextField(15);
        
        public JLabel voucher = new JLabel("Value :");
        public JTextField voucherValue = new JTextField(15);
        UsersListView(){
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setSize(1000,600);
            this.setLayout(new BorderLayout());
            usersPanel = new JPanel();
            GrantVoucherPanel = new JPanel();
            usersPanel.setLayout(new BoxLayout(usersPanel,BoxLayout.Y_AXIS));
            setVoucherPanel();
            this.add(usersPanel , BorderLayout.NORTH);
            this.add(GrantVoucherPanel , BorderLayout.SOUTH);
            
            
        }
        public void UpdateUsersList(User user){
            usersPanel.add(new JLabel("Name : "+user.getName()+"     Email : "+user.getEmail()+"      balance : "+user.getBalance()+"      Type : "+user.getType()));
            this.pack();
        }
        public void setVoucherPanel(){
            GrantVoucherPanel.add(userName);
            GrantVoucherPanel.add(TypeUserName);
            GrantVoucherPanel.add(voucher);
            GrantVoucherPanel.add(voucherValue);
            GrantVoucherPanel.add(GrantVoucher);
            GrantVoucherPanel.add(Cancel ,BorderLayout.AFTER_LAST_LINE );
        }
        
        public void GrantVoucherListener(ActionListener listenforaction)
        {
            GrantVoucher.addActionListener(listenforaction);
        }
        public void CancelListener(ActionListener listenforCancel){
            Cancel.addActionListener(listenforCancel);
        }
        
}
