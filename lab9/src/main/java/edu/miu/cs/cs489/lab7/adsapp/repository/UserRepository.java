package edu.miu.cs.cs489.lab7.adsapp.repository;

import edu.miu.cs.cs489.lab7.adsapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findUserByUsername(String username);

}
