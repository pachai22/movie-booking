package com.project.movie_booking.service;

import com.project.movie_booking.model.User;
import com.project.movie_booking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
       return (List<User>) userRepository.findAll();

    }
    public User getUserById(Long id){
        return userRepository.findById(id).get();
    }

    public User createUser(User user) {
     return userRepository.save(user);

    }

    public void deleteUserById(Long id)
    {
         userRepository.deleteById(id);
    }

    public Boolean authUser(String mailid, String pswd) {
        Optional<User> userOptional=userRepository.findByMailidAndPswd(mailid,pswd);
        if(userOptional.isPresent()){
            return true;
        }
        return  false;
    }
}
