package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

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
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@NotBlank(message = "Açıklama Alanı Boş Bırakılamaz")
	@Column(name = "description")
	private String description;
	
	
	@Column(name = "min_salary")
	private double minSalary;
	
	
	@Column(name = "max_salary")
	private double maxSalary;
	
	@NotBlank(message = "Açık Pozisyon Sayısı Alanı Boş Bırakılamaz")
	@Column(name = "number_of_open_positions")
	private String numberOfOpenPosition;
	
	@NotBlank(message = "Son Başvuru Tarihi Alanı Boş Bırakılamaz")
	@Column(name = "application_deadline")
	private String applicaitonDeadline;
	
	@NotBlank(message = "İlanın (Aktif-Pasif) Olup olmadığını Belirtin Lütfen")
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