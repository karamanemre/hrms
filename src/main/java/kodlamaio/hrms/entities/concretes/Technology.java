package kodlamaio.hrms.entities.concretes;

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
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@Table(name = "technology")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","candidateCv"})
public class Technology {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	//@NotBlank(message="Boş Geçilemez")
	//@Column(name = "technology")
	//private String technology;
	
	//@NotNull
	@Column(name = "cv_id")
	private int cvId;
	
	@Column(name = "technology_id")
	private int technologyId;
	
	@ManyToOne(targetEntity = CandidateCv.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "cv_id",insertable = false, updatable = false)
	@JsonIgnore
    private CandidateCv candidateCv;
	
	
	@ManyToOne(targetEntity = TechnologyNameList.class, fetch = FetchType.EAGER)
	@JsonIgnore
    @JoinColumn(name = "technology_id",insertable = false, updatable = false)
	private TechnologyNameList technologyNameList;
	
	
	
	
}
