package com.Buenlex.Patricia.repositories;

import com.Buenlex.Patricia.models.CostumerModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.Optional;

@Repository
public interface CostumerRepository extends org.springframework.data.repository.CrudRepository<com.Buenlex.Patricia.models.CostumerModel, java.lang.Long> {

    java.util.Optional<java.util.ArrayList<com.Buenlex.Patricia.models.CostumerModel>> findCostumerModelByFiles(java.lang.String files);

    java.util.Optional<java.util.ArrayList<com.Buenlex.Patricia.models.CostumerModel>> findCostumerModelByName(java.lang.String name);

    boolean existsByFiles(String files);

    boolean existsByCellphone(String cellphone);

}
