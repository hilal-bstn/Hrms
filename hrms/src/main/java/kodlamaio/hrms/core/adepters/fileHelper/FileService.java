package kodlamaio.hrms.core.adepters.fileHelper;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.core.utilities.results.DataResult;


public interface FileService {
	DataResult<Map> imageUpload(MultipartFile file);
}
