package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="city")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobPostings"})
public class City {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
	
	@NotBlank(message = "Şehir İsmi Alanı Boş Olamaz")
	@NotNull
	@Column(name = "city_name")
	private String city;
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "city")
	private List<JobPostings> jobPostings;
}
