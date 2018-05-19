package reportService.service;

import lombok.Getter;
import reportService.model.User;
import lombok.Data;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

@Data
@Service
@Getter
@SessionScope
public class UserSession {
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}