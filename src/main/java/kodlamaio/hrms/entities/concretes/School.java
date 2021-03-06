package kodlamaio.hrms.entities.concretes;


import java.sql.Date;

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
@Table(name = "schools")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","candidateId"})
public class School {
	
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotBlank(message="Boş Geçilemez")
	@Column(name = "starting_year")
	private Date startingYear;
	
	@Column(name = "finish_year")
	private String finishYear;
	
	@NotNull
	@Column(name = "candidate_id")
	private int candidateNumber;
	
	@NotNull
	@Column(name = "school_name")
	private int schoolId;
	
	@NotNull
	@Column(name = "section")
	private int schoolSectionId;
	
	
	@ManyToOne(targetEntity = Candidate.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "candidate_id",insertable = false, updatable = false)
    private Candidate candidateId;
	
	@ManyToOne(targetEntity = SchoolNameList.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "school_name",insertable = false, updatable = false)
    private SchoolNameList schoolNameList;
	
	@ManyToOne(targetEntity = SchoolSection.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "section",insertable = false, updatable = false)
    private SchoolSection schoollSection;
	
}
