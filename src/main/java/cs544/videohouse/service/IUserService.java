package cs544.videohouse.service;

import cs544.videohouse.domain.User;

public interface IUserService {
    public User createUser(String fName, String lName, String email);
    public User getUser(String email);
    public void changeDetails (String email,User usr);   
}