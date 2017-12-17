import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Hesham
 */
public class UserRegisterationController {
    private Registeration model;
    private RegisterationView view;
    private UsersListView usersView;
    public User LoggedinUser = null;
    public UserRegisterationController(Registeration model,RegisterationView view , UsersListView usersView)
    {
            this.model=model;
            this.view=view;
            this.view.setVisible(true);
            this.usersView=usersView;
            
            this.view.addListner( new registerListner());
            this.view.loginListner(new loginListner());
        
    }
    class registerListner implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent arg0)
        {
            User user = new User(view.getName(),view.getPassword(),view.getEmail(),view.getUserType());
            LoggedinUser=model.signUp(user);
            if(LoggedinUser!=null){
                view.setVisible(false);
                view.successful_msg();
                usersView.UpdateUsersList(LoggedinUser);
            }
                
        }
    }
    class loginListner implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent arg0)
        {

            LoggedinUser = model.signIn(view.getMemberEmail(),view.getMemberPassword());
            if(LoggedinUser !=null){
                 view.setVisible(false);
                 view.welcome_msg();
                 return;
            }
            view.error_msg();
        }
    }
    public User getLoggedUserType(){
        if(LoggedinUser!=null){
            
            return LoggedinUser;
        }
        return null;

    }
}