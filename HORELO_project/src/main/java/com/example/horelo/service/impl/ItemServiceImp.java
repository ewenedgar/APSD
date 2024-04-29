package com.example.horelo.service.impl;

import com.example.horelo.dto.item.ItemCompanyResponse;
import com.example.horelo.model.Company;
import com.example.horelo.model.Item;
import com.example.horelo.respository.CompanyRepository;
import com.example.horelo.respository.ItemRepository;
import com.example.horelo.service.inface.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemServiceImp implements ItemService {
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private CompanyRepository companyRepository;
    @Override
    public Item addNewItem(Item newItem) {
        return null;
    }

    @Override
    public List<Item> getAllItems() {

        return itemRepository.findAll();
    }

    @Override
    public List<ItemCompanyResponse> getAllItemsByCompany(Long id) {
        Optional<Company> cOpt = companyRepository.findById(id);
        if(cOpt.isPresent()){
            Company c = cOpt.get();
            //List<ItemCompanyResponse> itemCompanyResponses = c.getItemList()
        }
        return null;
    }
}
