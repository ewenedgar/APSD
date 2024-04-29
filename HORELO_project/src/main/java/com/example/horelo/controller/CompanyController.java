package com.example.horelo.controller;

import com.example.horelo.dto.company.CompanyOrderItemResponse;
import com.example.horelo.dto.company.CompanyOrderResponse;
import com.example.horelo.service.inface.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/horelo")
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    @GetMapping("/company/{id}")
    public List<CompanyOrderItemResponse> getCompanyItems(@PathVariable Long id){
        return companyService.getCompanyOrderItems(id);
    }
}
