package kodlamaio.hrms.entities.dtos;


import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobPostingsDto {
	
	private String companyName;
	
	private String numberOfOpenPosition;
	
	private String applicaitonDeadline;
	
	private LocalDate releaseDate;
	
	

}