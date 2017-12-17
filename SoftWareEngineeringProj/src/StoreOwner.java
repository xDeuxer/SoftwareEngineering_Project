
import java.util.*;
import javax.swing.JOptionPane;

/**
 * 
 */
public class StoreOwner extends User {

    
     StoreOwner(String name,String email,String password,String type){
         super(name,email,password,type);
     }
    
    public ArrayList<Store> my_stores=new ArrayList<Store>();
    
    public boolean addStore(String storeName , String storeType , String ADD_URL )
    {
            if(storeName.trim().length()==0||storeType.trim().length()==0||ADD_URL.trim().length()==0)
            {
                JOptionPane.showMessageDialog(null,"all fields must be filled");
                return false;
            }
            if(storeType.equals("normal store")||storeType.equals("normalStore") || storeType.equals("Normal Store"))
            {
                NormalStore normal_store=new NormalStore(storeName, storeType, ADD_URL);
                my_stores.add(normal_store);
                return true;
            }
            else if(storeType.equals("online store")||storeType.equals("onlinestore")||storeType.equals("Online Store")){
                OnlineStore online_store=new OnlineStore(storeName, storeType, ADD_URL);
                my_stores.add(online_store);
                return true;

            }
            else{
                JOptionPane.showMessageDialog(null, "wrong store type entered ! ");
                return false;
            }
    }
    public String[] getStoreNames()
    {
        String[] names = {"empty"};
        for(int i=0;i<my_stores.size();i++)
            names[i]=my_stores.get(i).name;
        return names;
    }
    public String getMostViewedProduct(){
        
        String MostViewedProduct="" ;
        int numberofView = 0;
        for(int i = 0 ; i <my_stores.size();i++){
            for(int j = 0 ; j < my_stores.get(i).products.size() ;j++)
            {
                if(my_stores.get(i).products.get(i).orderedCounter > numberofView){
                    numberofView = my_stores.get(i).products.get(i).orderedCounter;
                    MostViewedProduct =  my_stores.get(i).products.get(i).name;
                }
            }
        }
        return MostViewedProduct;
    }
}