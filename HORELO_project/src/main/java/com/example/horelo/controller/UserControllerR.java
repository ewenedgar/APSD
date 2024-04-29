package com.example.horelo.controller;

import com.example.horelo.model.*;
import com.example.horelo.respository.*;
import com.example.horelo.service.impl.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
//@RequestMapping("/user")
public class UserControllerR {
    @Autowired
    private FoodItemRepository foodItemRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private UserServiceImp userServiceImp;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AllergyRepository allergyRepository;

    @GetMapping("/hello")
    public String printHello(){
        return "hello";
    }


    @GetMapping("/allergy")
    public List<Allergy> getAllAllergy(){
        return allergyRepository.findAll();
    }
    @PostMapping("/allergy")
    public ResponseEntity<Allergy> addAllergy(@RequestBody Allergy allergy){
        return ResponseEntity.ok(allergyRepository.save(allergy));
    }
    @PutMapping("/allergy/{id}")
    public ResponseEntity<Allergy>  updateAllergy(@RequestBody Allergy newAllergy, @PathVariable Integer id){
        return allergyRepository.findById(id)
                .map(oldAllergy ->{
                    oldAllergy.setDescription(newAllergy.getDescription());
                    oldAllergy.setName(newAllergy.getName());

                    return ResponseEntity.ok(allergyRepository.save(oldAllergy));
                }).orElseGet(() -> {
                    newAllergy.setAllergy_id(id);
                    return ResponseEntity.ok(allergyRepository.save(newAllergy));
                });

    }

    @PostMapping("/user")
    public User addUser(@RequestBody User user){
        return userRepository.save(user);
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<User> updateUser(@RequestBody User newUser, @PathVariable Long id) {
        return userRepository.findById(id)
                .map(oldUser -> {
                    oldUser.setFirst_name(newUser.getFirst_name());
                    oldUser.setLast_name(newUser.getLast_name());
                    oldUser.setPhone_number(newUser.getPhone_number());
                    oldUser.setPrimary_address(newUser.getPrimary_address());
                    return ResponseEntity.ok(userRepository.save(oldUser));
                })
                .orElseGet(() -> {
                    newUser.setUser_id(id);
                    return ResponseEntity.ok(userRepository.save(newUser));
                });
    }
    @GetMapping("/user")
    public List<User> getAllUser(){
        return userRepository.findAll();
    }
    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable Long id){
        Optional<User> user = userRepository.findById(id);
        return user.orElse(null);
    }
    @GetMapping("/user/{id}/allergy")
    public User getUserAllergy(@PathVariable Long id){
        Optional<User> user = userRepository.getCustomerAllergies(id);

        return user.orElse(null);
    }
    /*
   @GetMapping("/company")
   public List<Company> getAllCompany(){
       return companyRepository.findAll();
   }

   @GetMapping("/company/{id}")
   public Company getCompanyById(@PathVariable Long id){
       Optional<Company> c = companyRepository.findById(id);
       return c.orElse(null);
   }
   @GetMapping("/company/{city}")
   public List<Company> getCompanyByCity(@PathVariable String city){
       return companyRepository.getCompaniesByCity();
   }

   @GetMapping("/company/{id}/")
   public List<Company> getCompanyMenuById(@PathVariable Long id){

       return companyRepository.getAllItems(id);
   }
*/
    @GetMapping("/address")
    public List<Address> getAlAddress(){

    return addressRepository.findAll();
    }
    @PostMapping("/address")
    public ResponseEntity<Address> addAddress(@RequestBody Address address){

        return ResponseEntity.ok(addressRepository.save(address));
    }
    @GetMapping("/fooditems")
    public List<FoodItem> getAllMenuItems(){
        return foodItemRepository.findAll();
    }

}
