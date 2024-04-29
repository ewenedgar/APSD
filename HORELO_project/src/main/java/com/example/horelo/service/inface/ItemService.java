package com.example.horelo.service.inface;

import com.example.horelo.dto.item.ItemCompanyResponse;
import com.example.horelo.model.Item;

import java.util.List;

public interface ItemService {
    Item addNewItem(Item newItem);
    List<Item> getAllItems();
    List<ItemCompanyResponse> getAllItemsByCompany(Long id);
}
