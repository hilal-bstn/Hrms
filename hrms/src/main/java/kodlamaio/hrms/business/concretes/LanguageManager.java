package kodlamaio.hrms.business.concretes;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.LanguageService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.LanguageDao;
import kodlamaio.hrms.entities.concretes.Language;

@Service
public class LanguageManager implements LanguageService {
	private LanguageDao languageDao;
	@Autowired
	public LanguageManager(LanguageDao languageDao) {
		super();
		this.languageDao = languageDao;
	}
	@Override
	@Transactional
	public DataResult<Language> add(Language language) {
		if(checkLanguageName(language.getName().toLowerCase()).isSuccess())
		{
			language.setName(language.getName().toLowerCase());
			this.languageDao.save(language);
		}
		return new SuccessDataResult<Language>(this.getByName(language.getName().toLowerCase()).getData(),"Kayıt başarılı");//id için
	}
	@Override
	public DataResult<Language> getByName(String name) {
		return new SuccessDataResult<Language>(this.languageDao.getByName(name));
	}
	private Result checkLanguageName(String name)
	{
		Language language=this.getByName(name).getData();
		if(language==null)
		{
			return new SuccessResult();
		}
		return new ErrorResult();
	}
	@Override
	public DataResult<List<Language>> getAll() {
		return new SuccessDataResult<List<Language>>(this.languageDao.findAll());
	}

}
