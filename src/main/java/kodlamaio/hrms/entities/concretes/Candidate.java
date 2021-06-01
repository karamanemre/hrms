package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;

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
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","candidateCv"})
public class Candidate extends Users {
		
	@NotBlank(message = "İsim Alanı Boş Olamaz")
	@NotNull
	@Column(name = "first_name")
	private String firstName;
	
	@NotBlank(message = "Soyisim Alanı Boş Olamaz")
	@NotNull
	@Column(name = "last_name")
	private String lastName;
	
	@NotBlank(message = "Tc Kimlik No Alanı Boş Olamaz")
	@NotNull
	@Column(name = "national_id")
	private String nationalId;
	
	@NotBlank(message = "Doğum Yılı Alanı Boş Olamaz")
	@NotNull
	@Column(name = "birth_year")
	private String dateOfBirth;
	
	@Transient
	private String firstNameAndLastName=firstName+lastName;
	
	
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "candidateId")
	private List<CandidateCv> candidateCv;
	
	    
	   
	
	
}
