package kodlamaio.hrms.business.abstracts;


import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.Language;


public interface LanguageService {
	
	DataResult<Language> add(Language language);
	
	DataResult<Language> getByName(String name);
	
	DataResult<List<Language>> getAll();
}
