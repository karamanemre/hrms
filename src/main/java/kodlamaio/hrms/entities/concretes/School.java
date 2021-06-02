package kodlamaio.hrms.entities.concretes;

import java.sql.Date;
import java.time.LocalDate;

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
@Table(name = "schools")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","candidateCv"})
public class School {
	
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotBlank(message="Boş Geçilemez")
	@Column(name = "school_name")
	private String schoolName;
	
	@NotBlank(message="Boş Geçilemez")
	@Column(name = "section")
	private String section;
	
	@NotBlank(message="Boş Geçilemez")
	@Column(name = "starting_year")
	private String startingYear;
	
	@Column(name = "finish_year")
	private String finishYear;
	
	
	@Column(name = "cv_id")
	private int cvId;
	
	@ManyToOne(targetEntity = CandidateCv.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "cv_id",insertable = false, updatable = false)
	@JsonIgnore
    private CandidateCv candidateCv;
	
}
