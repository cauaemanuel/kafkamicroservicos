package com.portal.api.controller;

import com.portal.api.dto.CarPostDTO;
import com.portal.api.service.CarPostStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/car")
public class CarPostController {

    @Autowired
    private CarPostStoreService carPostStoreService;

    @GetMapping("/posts")
    public ResponseEntity<List<CarPostDTO>> getCarForSales(){
        List<CarPostDTO> carPosts = carPostStoreService.getCarForSales();
        return ResponseEntity.status(HttpStatus.FOUND).body(carPosts);
    }

    @PutMapping("/{id}")
    public ResponseEntity changeCarSale(@RequestBody CarPostDTO carPost, @PathVariable String id){
        carPostStoreService.changeCarForSale(carPost, id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCarSale(@PathVariable String id){
        carPostStoreService.removeCarForSale(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
