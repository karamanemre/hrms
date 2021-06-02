package kodlamaio.hrms.entities.concretes;

import java.sql.Date;
import java.time.LocalDate;
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
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper=false)
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "languages")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","candidateCv"})
public class Languages {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotBlank(message="Boş Geçilemez")
	@Column(name = "language_name")
	private String languageName;
	
	@NotBlank(message="Boş Geçilemez")
	@Column(name = "language_level")
	private String languageLevel;
	
	@Column(name = "cv_id") //null hatasını etkisiz kılmak için cvid girişi yapılmalı json ignore verilerine dikkat!!
	private int cvId;
	
	@ManyToOne(targetEntity = CandidateCv.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "cv_id",insertable = false, updatable = false)
	@JsonIgnore
    private CandidateCv candidateCv;
}
