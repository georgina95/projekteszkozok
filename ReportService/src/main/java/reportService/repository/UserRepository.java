package reportService.repository;

import java.util.Optional;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import reportService.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>{
	Optional<User> findByNickname(String nickname);
    Optional<User> findByName(String name);
    ArrayList<User> findAll();
}