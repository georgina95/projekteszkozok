package reportService.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {

    @Id
	public String nickname;
	
	public String password;

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
               mappedBy = "reporter")
	public List<Report> reports;
	
	@JsonIgnore
    @OneToMany(targetEntity = Report.class, 
               cascade = CascadeType.ALL, 
               mappedBy = "operator")
	public List<Report> reports2;
	
	@JsonIgnore
    @OneToMany(targetEntity = State.class, 
               cascade = CascadeType.ALL, 
               mappedBy = "triggeredBy")
	public List<State> states;
	
	@JsonIgnore
    @OneToMany(targetEntity = State.class, 
               cascade = CascadeType.ALL, 
               mappedBy = "owner")
	public List<State> states2;

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
}
