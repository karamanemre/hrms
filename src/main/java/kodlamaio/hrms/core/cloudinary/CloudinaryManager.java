package kodlamaio.hrms.core.cloudinary;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.core.utilities.DataResult;

@Service
public class CloudinaryManager implements CloudinaryService {
	
	/*private Cloudinary cloudinary;
	
	@Autowired
	public CloudinaryManager(Cloudinary cloudinary) {
		this.cloudinary = cloudinary;
	}


	@Override
	public DataResult<?> save(MultipartFile file) {
		 try{
	            Map cloudinaryUploader = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
	            return new SuccessDataResult<Map>(cloudinaryUploader);
	        } catch (IOException e){
	           
	        }
	        return new ErrorDataResult<Map>();
	}
	*/
}
