package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "job_postings")

public class JobPostings {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "min_salary")
	private double minSalary;
	
	@Column(name = "max_salary")
	private double maxSalary;
	
	@Column(name = "number_of_open_positions")
	private String numberOfOpenPosition;
	
	@Column(name = "application_deadline")
	private String applicaitonDeadline;
	
	@Column(name = "is_active")
	private boolean isActive;
	
	@ManyToOne()
    @JoinColumn(name = "job_position_id")
    private JobPositions jobPosition;

    @ManyToOne
    @JoinColumn(name = "employer_id")
    private Employers employer;

    @ManyToOne()
    @JoinColumn(name = "city_id")
    private City city;
	
	
	
	
	
	
}
