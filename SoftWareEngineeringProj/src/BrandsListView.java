import java.awt.BorderLayout;
import javax.swing.*;
import java.util.*;
import java.awt.event.ActionListener;
public class BrandsListView extends JFrame{
    public JButton Cancel = new JButton("Cancel");
    public JPanel AddedBrands ;
    public JPanel SuggestedBrands;
    BrandsListView(){
        AddedBrands = new JPanel();
        SuggestedBrands = new JPanel();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800,600);
        this.setLayout(new BorderLayout());
        AddedBrands.setLayout(new BoxLayout(AddedBrands,BoxLayout.Y_AXIS));
        SuggestedBrands.setLayout(new BoxLayout(SuggestedBrands,BoxLayout.Y_AXIS));
        
        AddedBrands.add(new JLabel("Added Brands :") );
        SuggestedBrands.add(new JLabel("Suggested Brands : ") );
        

        this.add(AddedBrands , BorderLayout.NORTH);
        this.add(SuggestedBrands,BorderLayout.CENTER);
        this.add(Cancel , BorderLayout.SOUTH);

    }
    
    public void UpdateView(Brand Added , Brand suggested)
    {
        if(Added !=null){
            AddedBrands.add(new JLabel(Added.name) );
        }
        if(suggested !=null)
        {
            SuggestedBrands.add(new JLabel(suggested.name));
        }
        this.pack();
    }
    
    public void CancelListener(ActionListener listenforcancel){
        Cancel.addActionListener(listenforcancel);
    }
}
