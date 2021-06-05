package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "image")
public class CandidatePhoto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int imageId;
	
	@Column(name = "url")
	private String url;
	
	@ManyToOne()
	@JoinColumn(name = "candidate_id")
	@JsonIgnore()
	private Candidate candidate;
	
	/*@Column(name = "candidate_id")
	private int candidateNumber;
	
	@JsonIgnore
	@OneToOne(targetEntity = Candidate.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "candidate_id",insertable = false, updatable = false)
	private Candidate candidate;*/
	
	/*@ManyToOne(targetEntity = Candidate.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "candidate_id",insertable = false, updatable = false)
	@JsonIgnore
    private Candidate candidateId;*/
	
}
