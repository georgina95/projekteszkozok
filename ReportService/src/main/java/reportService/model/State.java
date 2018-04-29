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
public class State {

    @Id
	@GeneratedValue
	public int id;

	@JoinColumn
	@ManyToOne(targetEntity = User.class)
    public User triggeredBy;
	
	public String stateDate;
	
	public String comment;
	
	@JoinColumn
	@ManyToOne(targetEntity = User.class)
    public User owner;
	
	@Column
    @Enumerated(EnumType.STRING)
    private Status status;
    
    public enum Status {
        OPEN, IN_PROGRESS, SOLVED, COMPLETED;
	}
	
	//@Id
	@JoinColumn
	@ManyToOne(targetEntity = Report.class)
    public Report report;

}



