package reportService.repository;

import java.util.Optional;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import reportService.model.Report;
import reportService.model.User;

@Repository
public interface ReportRepository extends CrudRepository<Report, Integer>{
    Optional<Report> findById(int id);
    ArrayList<Report> findAll();
    //Optional<Report> findByDateAndUser(String reportDate, User user); // kiakad a date-re
}