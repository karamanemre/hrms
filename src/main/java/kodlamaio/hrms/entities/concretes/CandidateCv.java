package kodlamaio.hrms.entities.concretes;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import jdk.vm.ci.meta.Local;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper=false)
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "candidate_cv")
public class CandidateCv {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	
	@Column(name = "photo_link")
	private String photoLink;
	
	
	@Column(name = "github_link")
	private String githubLink;
	
	
	@Column(name = "linkedin_link")
	private String linkedinLink;
	
	
	@Column(name = "description")
	private String description;
	
	
	@Column(name = "creadet_date")
	private LocalDate creadetDate=LocalDate.now();
	
	@Column(name = "is_active")
	private boolean isActive;
	
	
	@ManyToOne(targetEntity = Candidate.class)
	@JoinColumn(name = "candidate_id", referencedColumnName =  "user_id" ,nullable = false)
	private Candidate candidateId;
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "candidateCv")
	private List<Languages> languages;
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "candidateCv")
	private List<School> schools;
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "candidateCv")
	private List<Technology> technology;
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "candidateCv")
	private List<JobExperience> jobExperiences;
	
	
	
	
	

	
}
