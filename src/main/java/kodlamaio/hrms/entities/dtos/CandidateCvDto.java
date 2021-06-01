package kodlamaio.hrms.entities.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CandidateCvDto {
	
	
	private String candidateName;
	private String candidateSurname;
	private String schoolName;
	private String schoolSection;
	private String schoolAdmissionDate;
	private String schoolLeavingDate;
	private String jobCompanyName;
	private String jobPosition;
	private String jobAdmissionDate;
	private String jobLeavingDate;
	private String githubAdress;
	private String linkedinAdress;
	private String  coverLetter;
	
	
	
}
