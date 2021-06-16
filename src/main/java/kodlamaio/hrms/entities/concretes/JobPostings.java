package kodlamaio.hrms.entities.concretes;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

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
	
	
	@NotBlank(message = "Açıklama Alanı Boş Bırakılamaz")
	@Column(name = "description")
	private String description;
	
	
	@Column(name = "min_salary")
	private double minSalary;
	
	
	@Column(name = "max_salary")
	private double maxSalary;
	
	@NotBlank(message = "Açık Pozisyon Sayısı Alanı  Boş Bırakılamaz")
	@Column(name = "number_of_open_positions")
	private String numberOfOpenPosition;
	
	@NotBlank(message = "Son Başvuru Tarihi Alanı Boş Bırakılamaz")
	@Column(name = "application_deadline")
	private String applicaitonDeadline;
	
	@JsonIgnore
	@Column(name = "is_active")
	private boolean isActive=true;
	
	@NotBlank(message = "Çalışma Yeri Alanı Boş Bırakılamaz")
	@Column(name = "workplace")
	private String workplace;
	
	@JsonIgnore
	@Column(name = "is_confirmation")
	private boolean isConfirmation=false;
	
	@Column(name = "type_of_work")
	private String typeOfWork;
	
	@Column(name = "release_date", columnDefinition = "Date default CURRENT_DATE")
	@JsonIgnore
	private LocalDate releaseDate = LocalDate.now();
	
	@Column(name = "city_id")
	private int cityId;
	
	@Column(name = "job_position_id")
	private int jobPositionId;
	
	@Column(name = "employer_id")
	private int employerId;
	
	@ManyToOne(targetEntity = JobPositions.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "job_position_id",insertable = false, updatable = false)
	@JsonIgnore
    private JobPositions jobPosition;
	
	@ManyToOne(targetEntity = Employers.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "employer_id",insertable = false, updatable = false)
	@JsonIgnore
    private Employers employer;
    

    @ManyToOne(targetEntity = City.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "city_id",insertable = false, updatable = false)
    @JsonIgnore
    private City city;
	
	
	
	
	
	
}
