package reportService.repository;

import java.util.Optional;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import reportService.model.User;

@Repository
public interface ReportRepository extends CrudRepository<User, Integer>{
    Optional<User> findById(int id);
    Optional<User> findByName(String name);
    ArrayList<User> findAll();
}