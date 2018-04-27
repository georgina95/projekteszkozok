package reportService.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {

    @Id
	public String nickname;

	public String name;

	public String email;

	public String phoneNumber;
	
	@Column
    @Enumerated(EnumType.STRING)
    private UserType userType;
    
    public enum UserType {
        USER, OPERATOR, ADMIN;
	}
	
	@JsonIgnore
    @OneToMany(targetEntity = Report.class, 
               cascade = CascadeType.ALL, 
               mappedBy = "user")
	public List<Report> reports;
	
	@JsonIgnore
    @OneToMany(targetEntity = State.class, 
               cascade = CascadeType.ALL, 
               mappedBy = "user")
	public List<State> states;
}
