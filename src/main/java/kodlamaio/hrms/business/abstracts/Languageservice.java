package kodlamaio.hrms.business.abstracts;

import java.util.List;

import org.apache.axis.types.Language;

import kodlamaio.hrms.core.utilities.DataResult;
import kodlamaio.hrms.core.utilities.Result;
import kodlamaio.hrms.entities.concretes.Languages;

public interface Languageservice {
	
	Result add(Languages languages);
	DataResult<List<Languages>> getAll();
}
