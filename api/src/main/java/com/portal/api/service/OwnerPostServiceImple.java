package com.portal.api.service;

import com.portal.api.client.CarPostStoreClient;
import com.portal.api.dto.OwnerPostDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OwnerPostServiceImple implements OwnerPostService{

    @Autowired
    private CarPostStoreClient carPostStoreClient;


    @Override
    public void crateOwnerCar(OwnerPostDTO ownerPostDTO) {
        carPostStoreClient.ownerPostClient(ownerPostDTO);
    }
}
