package cs544.videohouse.service;

import cs544.videohouse.dao.IUserDAO;
import cs544.videohouse.domain.User;
import javax.transaction.Transactional;
import org.hibernate.SessionFactory;

public class UserService implements IUserService {

    private IUserDAO userDAO;    
    private SessionFactory sf;

    public UserService(IUserDAO u,SessionFactory sf) {
        userDAO = u;
        this.sf = sf;
    }

    @Override
    public User createUser(User user) {            
        userDAO.saveUser(user);        
        return user;
    }
    
    @Override
    public User getUser(String email) {       
        User user = userDAO.loadUser(email);
        return user;
    }
   
    @Override
    @Transactional
    public void changeDetails(String email, User usr) {
        User loadedUsr=userDAO.loadUser(email);
        if(!usr.getEmail().equals(loadedUsr.getEmail()))
            loadedUsr.setEmail(usr.getEmail());
        if(!usr.getFirstName().equals(loadedUsr.getFirstName()))
            loadedUsr.setFirstName(usr.getFirstName());
        if(!usr.getLastName().equals(loadedUsr.getLastName()))
            loadedUsr.setLastName(usr.getLastName());
        if(!usr.getFacebookId().equals(loadedUsr.getFacebookId()) && usr.getFacebookId()!=null)
            loadedUsr.setFacebookId(usr.getFacebookId());
        userDAO.updateUser(loadedUsr);
    }   
}