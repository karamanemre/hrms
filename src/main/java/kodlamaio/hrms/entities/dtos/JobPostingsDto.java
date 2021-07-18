package kodlamaio.hrms.entities.dtos;


import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobPostingsDto {
	
	private int id;
	
	private String companyName;
	private String jobPosition;	
	private String numberOfOpenPosition;
	private String applicaitonDeadline;
	private LocalDate releaseDate;
	private String description;
	private boolean isConfirmation;
	private int workplace;
	private int typeOfWork;
	private String city;
	private double minSalary;
	private double maxSalary;
	private int cityId;
	private int positionId;
	

	
	

}
