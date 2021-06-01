package kodlamaio.hrms.entities.concretes;

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

import com.sun.istack.NotNull;

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
	
	
	
	@NotNull
	@NotBlank(message = "Bu Alan Boş bırakılamaz")
	@Column(name = "is_go_to_school")
	private boolean isGoToSchool;
	
	
	@Column(name = "school_name")
	private String schoolName;
	
	
	@Column(name = "school_section")
	private String schoolSection;
	
	
	@Column(name = "school_admission_date")
	private String schoolAdmissionDate;
	
	
	@Column(name = "school_leaving_date")
	private String schoolLeavingDate;
	
	
	@NotNull
	@NotBlank(message = "Bu Alan Boş bırakılamaz")
	@Column(name = "job_experience")
	private boolean  jobExperience;
	
	
	@Column(name = "job_company_name")
	private String  jobCompanyName;
	
	
	
	@Column(name = "job_position")
	private String jobPosition;
	
	
	
	@Column(name = "job_admission_date")
	private String jobAdmissionDate;
	
	
	
	@Column(name = "job_leaving_date")
	private String jobLeavingDate;
	
	
	@NotNull
	@NotBlank(message = "Bu Alan Boş bırakılamaz")
	@Column(name = "is_languages_knows")
	private boolean isLanguagesKnows;
	
	
	
	@Column(name = "languages_level")
	private int languagesLevel;
	
	
	
	
	
	@NotNull
	@NotBlank(message = "Bu Alan Boş bırakılamaz")
	@Column(name = "github_adress")
	private String githubAdress;
	
	
	@NotNull
	@NotBlank(message = "Bu Alan Boş bırakılamaz")
	@Column(name = "linkedin_adress")
	private String linkedinAdress;
	
	
	
	@NotNull
	@NotBlank(message = "Bu Alan Boş bırakılamaz")
	@Column(name = "is_programming_language_knows")
	private boolean isProgrammingLanguageKnows;
	
	
	@NotNull
	@NotBlank(message = "Bu Alan Boş bırakılamaz")
	@Column(name = "cover_letter")
	private String  coverLetter;
	
	//@Column(name = "candidate_id")
	@JoinColumn(name = "candidate_id")
	@ManyToOne(fetch = FetchType.LAZY)
	private Candidate candidateId;
	
	
	@JoinColumn(name ="languages" )
	@ManyToOne(fetch = FetchType.LAZY)
	private Languages languages;
	
	@JoinColumn(name ="programming_language" )
	@ManyToOne(fetch = FetchType.LAZY)
	private ProgrammingLanguages programmingLanguage;
	
	@JoinColumn(name ="technology" )
	@ManyToOne(fetch = FetchType.LAZY)
	private Technology technology;
	
	
	@NotNull
	@NotBlank(message = "Bu Alan Boş bırakılamaz")
	@Column(name = "candidate_photo")
	private String candidatePhoto;
	
}
