/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cs544.videohouse.dao;

import cs544.videohouse.domain.User;
import java.util.Collection;

/**
 *
 * @author Bishal Timilsina
 */
public interface IUserDAO {
   public void saveUser(User usr);
   public void updateUser(User usr);
   public User loadUser(long id);
   public User loadUser(String email);
   public void removeUser(User usr);
   public Collection<User> getUsers();
}
