package kodlamaio.hrms.core.adepters.fileHelper;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
@Service
public class CloudinaryManager implements FileService {
	private Cloudinary cloudinary;
	public CloudinaryManager() {
		this.cloudinary=new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "hilalbstn",
                "api_key", "487218377613353",
                "api_secret", "j2l_dc8Om-glhAGxJs7Zr-kBkyU"));}
//https://cloudinary.com/documentation/java_image_and_video_upload
	@Override
	public DataResult<Map> imageUpload(MultipartFile file) {
		try {
		Map<String, String> uploadResult =(Map<String, String>) cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
		return new SuccessDataResult<Map>(uploadResult);
		}
		catch (IOException e) { e.printStackTrace();
		}
        return new ErrorDataResult<Map>();
		}
	}

