package kodlamaio.hrms.core.adepters.userVerification;

public interface UserVerificationService {
	boolean identityVerification(String identityNumber, String firstName, String lastName,String yearOfBirth);
}
