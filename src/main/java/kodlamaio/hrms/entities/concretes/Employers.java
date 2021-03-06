package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.print.attribute.standard.MediaSize.Other;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.json.JSONObject;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import springfox.documentation.spring.web.json.Json;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;

@PrimaryKeyJoinColumn(name = "user_id")
@Entity
@Table(name = "employers")
@EqualsAndHashCode(callSuper=false)
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobPostings"})
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
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
	
	
	@Type(type = "jsonb")
	@Column(columnDefinition = "jsonb",name = "updated_information")
	private Employers uptade_information;
	
    
	@JsonIgnore
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "employer")
	private List<JobPostings> jobPostings;
	

}
