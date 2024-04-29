package com.example.horelo.service.inface;

import com.example.horelo.dto.company.*;
import com.example.horelo.model.Company;

import java.util.List;

public interface CompanyService {
    Company addNewCompany(Company newCompany);
    List<CompanyResponse> getAllCompany();
    List<CompanyItemResponse> getCompanyItems(Long id);
    List<CompanyUserResponse> getCompanyUsers(Long id);
    List<CompanyAddressResponse> getCompanyAddress(Long id);
    List<CompanyOrderItemResponse> getCompanyOrderItems(Long id);
    List<CompanyOrderResponse> getCompanyOrders(Long id);
    List<CompanyIngredientResponse> getCompanyIngredients(Long id);
}
