package kodlamaio.hrms.entities.dtos;

import java.util.List;

import kodlamaio.hrms.entities.concretes.JobExperience;
import kodlamaio.hrms.entities.concretes.Languages;
import kodlamaio.hrms.entities.concretes.School;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CandidateCvDto {
	
	
	//private String firstName;
	//private String lastName;
	private String schoolName;
	private String language;
	private String languageLevel;
	private String companyName;
	private String startingYear;
	private String finishYear;
	private String githubAdress;
	private String linkedinAdress;
	private String coverLetter;
	
	
	
}
