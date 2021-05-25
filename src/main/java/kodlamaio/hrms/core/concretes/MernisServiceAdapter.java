package kodlamaio.hrms.core.concretes;

import java.rmi.RemoteException;

import org.springframework.stereotype.Service;
import kodlamaio.hrms.core.abstracts.CustomerCheckService;
import kodlamaio.hrms.entities.concretes.Candidate;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;
import java.time.format.DateTimeFormatter;

@Service
public class MernisServiceAdapter implements CustomerCheckService{

	@Override
	public boolean checkIfRealPerson(Candidate candidate) {
		
		KPSPublicSoapProxy client = new KPSPublicSoapProxy();
		
		
		
		boolean result=true;
		try {
			result = client.TCKimlikNoDogrula(Long.parseLong(candidate.getNationalId()), candidate.getFirstName().toUpperCase(), candidate.getLastName().toUpperCase(),2001);
			if (result==true) {
				return result;
			}
		} 
		catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return false;
		
		/*boolean result = true;
		
		try {
			
			result = client.TCKimlikNoDogrula(Long.parseLong(jobSeekers.getIdentity_number()),jobSeekers.getFirstName().toUpperCase()
					,jobSeekers.getLastName().toUpperCase(), jobSeekers.getDateOfBirth());
			
		}
		catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return result;*/
	}

}
