package edu.miu.cs.cs489.lab7.adsapp.service;

import edu.miu.cs.cs489.lab7.adsapp.model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    User getUserByUsername(String username);

    User registerNewUser(User user);
}
