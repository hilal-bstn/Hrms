package kodlamaio.hrms.business.abstracts;


import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Language;


public interface LanguageService {
	
	Result add(Language language);
	
	DataResult<Language> getByName(String name);
}
