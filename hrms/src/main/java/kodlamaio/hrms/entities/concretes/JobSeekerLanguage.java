package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="job_seeker_languages")
public class JobSeekerLanguage {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

	@Column(name="job_seeker_id")
	private int jobSeekerId;
	
	@ManyToOne()
	@JoinColumn(name="language_id")
	private Language language;
	
	@Column(name="language_level")
	private int languageLevel;
	
	public JobSeekerLanguage() {}

	public JobSeekerLanguage(int id, int jobSeekerId, Language language, int languageLevel) {
		super();
		this.id = id;
		this.jobSeekerId = jobSeekerId;
		this.language = language;
		this.languageLevel = languageLevel;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getJobSeekerId() {
		return jobSeekerId;
	}

	public void setJobSeekerId(int jobSeekerId) {
		this.jobSeekerId = jobSeekerId;
	}

	public int getLanguageLevel() {
		return languageLevel;
	}

	public void setLanguageLevel(int languageLevel) {
		this.languageLevel = languageLevel;
	}

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}
}
