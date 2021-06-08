package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@PrimaryKeyJoinColumn(name = "user_id")
@Entity
@Table(name = "employers")
@EqualsAndHashCode(callSuper=false)
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobPostings"})
public class Employers extends Users{
	
	@NotBlank(message = "Şirket İsmi Alanı Boş Olamaz")
	@Column(name = "company_name")
    private String companyName;
	
	@NotBlank(message = "Web Site Alanı Boş Olamaz")
    @Column(name = "website")
    private String webSite;
	
	@NotBlank(message = "Telefon Numarası Alanı Boş Olamaz")
	@Pattern(regexp ="[0-9\\s]{11}",message = "Hatalı Telefon numarası")
    @Column(name = "phone_number")
    private String phoneNumber;
    
	@JsonIgnore
    @OneToMany(mappedBy = "employer")
	private List<JobPostings> jobPostings;
	

}
