package kodlamaio.hrms.entities.concretes;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Pattern.Flag;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor 
@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
public class Users {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int userId;
	
	
	@NotBlank(message="Mail Alanı Boş olamaz")
	@Column(name = "email")
	@Email
    private String email;
    
	
	@Pattern(regexp = "^(?=.*\\d).{4,8}$", flags = Flag.UNICODE_CASE,message = "Şifreniz küçük harf,büyük harf,sembol ve rakam içermelidir")
	@NotBlank(message="Password Alanı Boş olamaz")
    @Column(name = "password")
    private String password;
    
	@NotBlank(message="Password Alanı Boş olamaz")
    @Transient
    private String password_repeat;
    

	@JsonIgnore
	@Column(name="verify")
	private boolean verify = false;
    
	
	
	
	

}

