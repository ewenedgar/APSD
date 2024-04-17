package edu.miu.cs.cs489.lab7.adsapp.service.impl;

import edu.miu.cs.cs489.lab7.adsapp.model.User;
import edu.miu.cs.cs489.lab7.adsapp.repository.UserRepository;
import edu.miu.cs.cs489.lab7.adsapp.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getUserByUsername(String username) {
        return userRepository.findUserByUsername(username)
                .orElse(null);
    }

    @Override
    public User registerNewUser(User user) {
        return null;
    }
}
