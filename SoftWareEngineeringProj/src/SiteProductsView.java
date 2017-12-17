import java.awt.BorderLayout;
import javax.swing.*;
import java.util.*;
import java.awt.event.ActionListener;
public class SiteProductsView extends JFrame{
    JPanel ProductsPanel = null;
    JPanel ButtonsPanel = null;
    public JButton AddProduct = new JButton ("AddProduct");
    public JButton AddStore = new JButton ("AddStore");
    public JButton AddBrand = new JButton("AddBrand");
    public JButton SuggestBrand = new JButton("SuggestBrand");
    public JButton ShowBrands = new JButton("Show Brands");
    public JButton Statistics = new JButton("Statistics");
    public JButton GrantVoucher = new JButton("Grant Voucher");
    public JButton Logout = new JButton("LogOut");
    
    public ArrayList<Product.SelectButton> selectButtons = new ArrayList<Product.SelectButton>();
    
    public SiteProductsView() {
        ProductsPanel = new JPanel();
        ButtonsPanel = new JPanel();
        
        this.DefaultSiteView();       
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800,600);
        ProductsPanel.setLayout(new BoxLayout(ProductsPanel,BoxLayout.Y_AXIS));
        Addbuttons();

        this.add(ProductsPanel , BorderLayout.NORTH);
        this.add(ButtonsPanel , BorderLayout.SOUTH);
    }
    

   
    public void AddProductsToView(Product siteProduct , ProductSelectionCtrl SelectButtonsActionAdder) {   
          
            ProductsPanel.add(new JLabel("Name : "+siteProduct.name+"                            Price :"+siteProduct.Price));
            ProductsPanel.add(siteProduct.selectButton.selectedButton,BorderLayout.EAST);
            selectButtons.add(siteProduct.selectButton);
            SelectButtonsActionAdder.AddActionToSelectButtons(siteProduct.selectButton);
            
            ProductsPanel.revalidate();
            ProductsPanel.repaint();
    }


    private void Addbuttons(){
        ButtonsPanel.add(AddProduct , BorderLayout.SOUTH);
        ButtonsPanel.add(AddStore , BorderLayout.SOUTH);
        ButtonsPanel.add(AddBrand , BorderLayout.SOUTH);
        ButtonsPanel.add(SuggestBrand , BorderLayout.SOUTH);
        ButtonsPanel.add(ShowBrands , BorderLayout.SOUTH);
        ButtonsPanel.add(GrantVoucher , BorderLayout.SOUTH);
        ButtonsPanel.add(Statistics , BorderLayout.SOUTH);
        ButtonsPanel.add(Logout , BorderLayout.AFTER_LAST_LINE);
    }

    public void goToAddProductPageListener(ActionListener  listenforAdd) {
        AddProduct.addActionListener(listenforAdd);
    }
    public void StatListener(ActionListener  listenforStat) {
        Statistics.addActionListener(listenforStat);
    }
    public void goToBrandsPageListener(ActionListener listenfortransition)
    {
        ShowBrands.addActionListener(listenfortransition);
    }
    public void goToStoreRegisterationListener(ActionListener listenforStoreReg){
        AddStore.addActionListener(listenforStoreReg);
    }
    
    public void goToBrandAdditionView(ActionListener listenforTranistion)
    {
        AddBrand.addActionListener(listenforTranistion);
        SuggestBrand.addActionListener(listenforTranistion);
    }
    public void goToGrantVoucherView(ActionListener listenforVoucherButton)
    {
        GrantVoucher.addActionListener(listenforVoucherButton);
    }
    
    public void LogoutListener(ActionListener listenforLogout){
        Logout.addActionListener(listenforLogout);
    }
    public void DefaultSiteView(){
        this.setVisible(false);
        
        
        AddBrand.setVisible(false);
        SuggestBrand.setVisible(true);
        AddProduct.setVisible(false);
        AddStore.setVisible(false);
        GrantVoucher.setVisible(false);
        
    }
}
