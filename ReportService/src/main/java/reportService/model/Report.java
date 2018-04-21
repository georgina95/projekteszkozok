package reportService.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.GeneratedValue;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Report {

    @Id
	@GeneratedValue
	public int id;
	
	public Date reportDate;
	
	@JoinColumn
	@ManyToOne(targetEntity = User.class)
    public User reporter;
	
	@JoinColumn
	@ManyToOne(targetEntity = User.class)
    public User operator;
	
	@Column
    @Enumerated(EnumType.STRING)
    private Status status;
    
    public enum Status {
        OPEN, IN_PROGRESS, SOLVED, COMPLETED;
	}
	
	@JsonIgnore
    @OneToMany(targetEntity = State.class, 
               cascade = CascadeType.ALL, 
               mappedBy = "report")
	public List<State> states;
}
