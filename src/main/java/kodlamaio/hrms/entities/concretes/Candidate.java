package kodlamaio.hrms.entities.concretes;

import java.util.List;

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
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper=false)
@PrimaryKeyJoinColumn(name = "user_id")
@Entity
@Table(name = "candidates")
@Data
@AllArgsConstructor
@NoArgsConstructor
//@JsonIgnoreProperties({"hibernateLazyInitializer","handler","candidateCv"})
public class Candidate extends Users {
	
	
	
	@NotBlank(message = "İsim Alanı Boş Olamaz")
	@Column(name = "first_name")
	private String firstName;
	
	@NotBlank(message = "Soyisim Alanı Boş Olamaz")
	@Column(name = "last_name")
	private String lastName;
	
	@NotBlank(message = "Tc Kimlik No Alanı Boş Olamaz")
	@Column(name = "national_id")
	@Size(min = 11, max = 11, message = "Tc kimlik numarası 11 haneli olmalıdır")
	@Pattern(regexp = "(^[1-9][0-9]*$)|(^\\d{10}$)", message = "Tc kimlik numarası 0 ile başlayamaz veya metin içeremez.")
	private String nationalId;
	
	@NotBlank(message = "Doğum Yılı Alanı Boş Olamaz")
	@Column(name = "birth_year")
	private String dateOfBirth;
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "candidateId")
	private List<JobExperience> jobExperiences;
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "candidateId")
	private List<Languages> languages;
	

	@OneToMany(fetch = FetchType.LAZY,mappedBy = "candidateId")
	private List<School> schools;
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "candidateId")
	private List<Technology> technology;
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "candidateId")
	private List<ProgrammingLanguage> programmingLanguage;
	
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "candidateId")
	private List<SocialMedia> socialMedia;
	
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "candidateId")
	private List<CoverLetter> coverLetter;	    
	   
	
	
}
