package kodlamaio.hrms.core.adepters;

public class MernisManagerAdapter implements UserVerificationService {

	@Override
	public boolean identityVerification(String identityNumber, String firstName, String lastName, String yearOfBirth) {
		return true;//sahte doğrulama..
	}
	
}
