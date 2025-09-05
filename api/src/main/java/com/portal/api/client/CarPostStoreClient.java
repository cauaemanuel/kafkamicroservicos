package com.portal.api.client;

import com.portal.api.dto.CarPostDTO;
import com.portal.api.dto.OwnerPostDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;

@Component
public class CarPostStoreClient {

    private final String USER_STORE_SERVICE_URI = "http://localhost:8081/user" ;
    private final String POST_STORE_SERVICE_URI = "http://localhost:8082/sales" ;

    @Autowired
    private RestTemplate restTemplate;

    public List<CarPostDTO> carForSaleClient(){
        ResponseEntity<CarPostDTO[]> response = restTemplate.getForEntity(POST_STORE_SERVICE_URI+"/cars", CarPostDTO[].class);
        return List.of(Objects.requireNonNull(response.getBody()));
    }

    public void ownerPostClient(OwnerPostDTO newUser){
        restTemplate.postForEntity(POST_STORE_SERVICE_URI, newUser, OwnerPostDTO.class);
    }

    public void changeCarForSaleClient(CarPostDTO carPost, String id){
        restTemplate.put(POST_STORE_SERVICE_URI+"/cars/"+id, carPost,CarPostDTO.class);
    }

    public void removeCarForSaleClient(String id){
        restTemplate.delete(POST_STORE_SERVICE_URI+"/cars/"+id);
    }
}
