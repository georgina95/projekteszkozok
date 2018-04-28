package reportService.repository;

import java.util.Optional;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import reportService.model.State;


@Repository
public interface StateRepository extends CrudRepository<State, Integer>{
    Optional<State> findById(int id);
    Optional<State> findByTriggeredBy(String name);
}