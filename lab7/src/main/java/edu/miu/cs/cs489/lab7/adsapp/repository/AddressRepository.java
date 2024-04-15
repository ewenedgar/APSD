package edu.miu.cs.cs489.lab7.adsapp.repository;

import edu.miu.cs.cs489.lab7.adsapp.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {
}
