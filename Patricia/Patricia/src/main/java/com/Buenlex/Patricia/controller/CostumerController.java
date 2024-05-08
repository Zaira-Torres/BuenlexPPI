package com.Buenlex.Patricia.controller;

import com.Buenlex.Patricia.models.CostumerModel;
import com.Buenlex.Patricia.services.CostumerService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/costumer")
public class CostumerController {
    @Autowired
    CostumerService costumerService;

    @PostMapping()
    public CostumerModel saveCostumer(@RequestBody CostumerModel costumer) {
        return costumerService.saveCostumer(costumer);
    }

    @PutMapping()
    public CostumerModel editCostumer(@RequestBody CostumerModel costumer) {
        return costumerService.editCostumer(costumer);
    }

    @GetMapping()
    public ArrayList<CostumerModel> getAllCostumers() {
        return costumerService.getAllCostumers();
    }

    @GetMapping("/findCostumerByFiles/{files}")
    public Optional<ArrayList<CostumerModel>> findCostumerByFiles(@PathVariable String files){
        return costumerService.findCostumerByFiles(files);
    }

    @GetMapping("/findCostumerByName/{name}")
    public Optional<ArrayList<CostumerModel>> findCostumerByName(@PathVariable String name){
        return costumerService.findCostumerByName(name);
    }

    @DeleteMapping("/delete-costumer-by-id")
    public String deleteCostumerById(@RequestParam("id") Long id){
        return costumerService.deleteCostumerById(id);
    }

}