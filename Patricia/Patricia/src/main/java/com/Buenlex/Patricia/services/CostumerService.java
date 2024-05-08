package com.Buenlex.Patricia.services;

import com.Buenlex.Patricia.models.CostumerModel;
import com.Buenlex.Patricia.repositories.CostumerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class CostumerService {

    @Autowired
    CostumerRepository repository;


    public CostumerModel saveCostumer(CostumerModel costumer){
        if(!costumer.getName().matches("[a-zA-Z ]+")){ //validacion nombre
            throw new IllegalArgumentException("El nombre solo debe contener letras y espacios");
        }

        //validacion compañia
        if (!costumer.getCompany().matches("[a-zA-Z ]+")){
            throw new IllegalArgumentException("El nombre de la compañia solo debe contener letras");
        }

        if(repository.existsByFiles(costumer.getFiles())){ //validacion de si existe el expediente
            throw new IllegalArgumentException("Error. El expediente ya existe");
        }

        if(repository.existsByCellphone(costumer.getCellphone())){ //validacion de si existe el no. telefono
            throw new IllegalArgumentException("Error. El número de teléfono ya existe");
        }

        //validar fecha de activacion
        try{
            LocalDate date = costumer.getDateActivate();
            if (date == null){
                throw new IllegalArgumentException("Debe ingresar la fecha de activacion");
            }
        }catch (DateTimeParseException e) {
            throw new IllegalArgumentException("La fecha no es valida");
        }

        //validar audiencia
        if (costumer.getAudiences() == null || costumer.getAudiences().isEmpty()) {
            throw new IllegalArgumentException("Debe ingresar la audiencia");
        }

        //validar numero de telefono
        if (!costumer.getCellphone().matches("[0-9]+")){
            throw new IllegalArgumentException("Error. Ingrese solo numeros enteros");
        }

        return repository.save(costumer);
    }

    public ArrayList<CostumerModel> getAllCostumers(){
        return (ArrayList<CostumerModel>) repository.findAll();
    }

    public Optional<ArrayList<CostumerModel>> findCostumerByName(String name){
        return repository.findCostumerModelByName(name);
    }

    public Optional<ArrayList<CostumerModel>> findCostumerByFiles(String files){
        return repository.findCostumerModelByFiles(files);
    }

    public CostumerModel editCostumer(CostumerModel costumer){
        return repository.save(costumer);
    }

    public String deleteCostumerById(Long id){
        Optional<CostumerModel> costumerModelOptional = repository.findById(id);
        if(costumerModelOptional.isPresent()){
            repository.deleteById(id);
            return "Cliente con Id="+ id + " eliminado exitosamente";
        }else {
            return "Cliente con Id="+ id+ " no encontrado";
        }
    }
}

