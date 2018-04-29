package reportService.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import reportService.repository.UserRepository;
import reportService.model.User;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public Optional<User> login(String nickname, String password) {
        Optional<User> optionalUser = userRepository.findByNickname(nickname);

        return optionalUser.filter(user -> user.getPassword().equals(password));
    }
}
