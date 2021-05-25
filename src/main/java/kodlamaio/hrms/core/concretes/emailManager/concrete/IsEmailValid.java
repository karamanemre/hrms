package kodlamaio.hrms.core.concretes.emailManager.concrete;

import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

@Service
public class IsEmailValid {
	public static boolean isEmailValid(String email) {
	    final Pattern EMAIL_REGEX = Pattern.compile("[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", Pattern.CASE_INSENSITIVE);
	    return EMAIL_REGEX.matcher(email).matches();
	}
}
