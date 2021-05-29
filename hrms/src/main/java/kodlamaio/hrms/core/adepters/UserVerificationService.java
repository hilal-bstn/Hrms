package kodlamaio.hrms.core.adepters;

public interface UserVerificationService {
	boolean identityVerification(String identityNumber, String firstName, String lastName,String yearOfBirth);
}
