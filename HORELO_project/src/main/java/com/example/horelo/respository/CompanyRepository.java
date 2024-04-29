package com.example.horelo.respository;

import com.example.horelo.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CompanyRepository extends JpaRepository<Company, Long> {

    @Query(value = "select * from company c join on address a where c.address_id = a.address_id", nativeQuery = true)
    List<Company> getCompaniesByCity();

    @Query(value="select f.name, f.couisine_type from company c join item f where f.company_id = c.company_id", nativeQuery = true)
    List<Company> getAllItems(Long id);
}
