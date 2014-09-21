/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cs544.videohouse.dao;

import cs544.videohouse.domain.User;
import java.util.Collection;
import javax.transaction.Transactional;
import org.hibernate.Query;
import org.hibernate.SessionFactory;

/**
 *
 * @author Bishal Timilsina
 */
@Transactional
public class UserDAO implements IUserDAO{
    
    private SessionFactory sf;

    public UserDAO(SessionFactory sf) {
        this.sf = sf;
    }
        
    @Override
    public void saveUser(User usr) {
        System.out.println("UserDAO: saving user with id =" + usr.getId());       
        sf.getCurrentSession().persist(usr);
    }

    @Override
    public void updateUser(User usr) {
        System.out.println("UserDAO: updating user with id =" + usr.getId());       
        sf.getCurrentSession().update(usr);
    }

    @Override
    public User loadUser(long id) {
        System.out.println("UserDAO: loading user with id =" + id);       
        return (User)sf.getCurrentSession().get(User.class, id);
    }
    
    @Override
    public User loadUser(String email) {
        System.out.println("UserDAO: loading user with email-ID = :email"); 
        Query q=sf.getCurrentSession().createQuery("from User u where u.email= :email");
        q.setParameter("email", email);
        return (User)q.uniqueResult();
    }

    @Override
    public void removeUser(User usr) {
        System.out.println("UserDAO: removing user with id =" + usr.getId());       
        sf.getCurrentSession().delete(usr);
    }

    @Override
    public Collection<User> getUsers() {
        System.out.println("UserDAO: loading all users...");       
        return sf.getCurrentSession().createQuery("from User").list();
    }
    
}
