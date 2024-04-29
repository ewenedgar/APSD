package com.example.horelo.service.impl;

import com.example.horelo.dto.allergy.AllergyResponse;
import com.example.horelo.dto.allergy.AllergyUserResponse;
import com.example.horelo.dto.user.UserResponse;
import com.example.horelo.model.Allergy;
import com.example.horelo.respository.AllergyRepository;
import com.example.horelo.service.inface.AllergyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AllergyServiceImp implements AllergyService {
    @Autowired
    private AllergyRepository allergyRepository;

    @Override
        public Allergy addNewAllergy(Allergy newAllergy) {
            return allergyRepository.save(newAllergy);
        }

        @Override
        public List<AllergyResponse> getAllAllergies() {
            return allergyRepository.findAll()
                    .stream()
                    .map(a -> new AllergyResponse(
                            a.getAllergy_id(),
                            a.getName(),
                            a.getDescription()

                    )).toList();
    }

    @Override
    public List<AllergyUserResponse> getAllergiesByUser() {
        return allergyRepository.findAll()
                .stream()
                .map(
                        a -> new AllergyUserResponse(
                                a.getAllergy_id(),
                                a.getName(),
                                a.getDescription(),
                                (a.getUser() != null ? new UserResponse(
                                        a.getUser().getUser_id(),
                                        a.getUser().getFirst_name(),
                                        a.getUser().getLast_name(),
                                        a.getUser().getPhone_number(),
                                        a.getUser().getEmail()
                                ):null)
                        )
                ).toList();
    }
}
