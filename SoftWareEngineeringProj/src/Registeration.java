import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Hesham
 */
public class Registeration {
    private ArrayList<User> users=new ArrayList<User>();
    Registeration(){
        users.add(new User("Yasser","20150295","quanturt@gmail.com","Admin"));
    }
    public User signUp(User user)
    {
            User LoggedinUser =null;
            if(user.getName().length()==0||user.getPassword().length()==0||user.getEmail().length()==0||user.getType().length()==0)
            {
                JOptionPane.showMessageDialog(null, " all fields must be filled");
                return null;
            }
            if(user.getType().equals("normal member"))
                LoggedinUser = user;
            else if(user.getType().equals("store owner"))
                LoggedinUser = new StoreOwner(user.getName() , user.getPassword() , user.getEmail() , user.getType());
            users.add(LoggedinUser);
            return LoggedinUser;

            
    }
    public int getNumberOfUsers()
    {
        return users.size();
    }
    public User signIn(String email,String password)
    {
        for(int i=0;i<users.size();i++)
        {
            if(users.get(i).getEmail().equals(email)&&users.get(i).getPassword().equals(password)){
                return users.get(i);
            }
        }
        return null;
    }
    public void GrantVoucher(String userName  ,double VoucherValue)
    {
        for(int i=0;i<users.size();i++)
        {
            if(users.get(i).getName().equals(userName)){
                users.get(i).GrantVoucher(VoucherValue);
                JOptionPane.showMessageDialog(null, "Voucher of value : "+VoucherValue+" added to User: "+userName);
                return;
            }
        }
        JOptionPane.showMessageDialog(null,"no user found with this name !");
    }
    
}
