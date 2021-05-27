package kodlamaio.hrms.core.adapters;

import java.rmi.RemoteException;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.entities.concretes.Candidate;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

@Service
public class MernisServiceAdapter implements CustomerCheckService<Candidate>{

	@Override
	public boolean mernisControl(Candidate candidate) {
		KPSPublicSoapProxy kpsPublic = new KPSPublicSoapProxy();
		try {
			boolean result = kpsPublic.TCKimlikNoDogrula(Long.parseLong(candidate.getNationalId()), candidate.getFirstName().toUpperCase(), candidate.getLastName().toUpperCase(), Integer.parseInt(candidate.getDateOfBirth()));
			return result;
		} catch (RemoteException | NumberFormatException e) {
			e.printStackTrace();
		}
			return false;
	}

}
