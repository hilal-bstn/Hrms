package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name="languages")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobSeekerLanguages"})
public class Language {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="language_id")
	private int id;

	@Column(name="name")
	private String name;
	
	@OneToMany(mappedBy="language")
	private List<JobSeekerLanguage> JobSeekerLanguages;
	
	public Language() {}

	public Language(int id, String name, List<JobSeekerLanguage> jobSeekerLanguages) {
		super();
		this.id = id;
		this.name = name;
		JobSeekerLanguages = jobSeekerLanguages;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<JobSeekerLanguage> getJobSeekerLanguages() {
		return JobSeekerLanguages;
	}

	public void setJobSeekerLanguages(List<JobSeekerLanguage> jobSeekerLanguages) {
		JobSeekerLanguages = jobSeekerLanguages;
	}

	
}
