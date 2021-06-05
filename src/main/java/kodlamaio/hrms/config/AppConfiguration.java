package kodlamaio.hrms.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ObjectUtils;

import com.cloudinary.*;

import kodlamaio.hrms.core.imageUploaders.CloudinaryService;
import kodlamaio.hrms.core.imageUploaders.ImageService;
import springfox.documentation.swagger2.mappers.ModelMapper;

@Configuration
public class AppConfiguration {
	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper() {
		};
	}
	
	
    public Cloudinary cloudinaryService(){
        return new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "dlluer8c0",
                "api_key", "242342712477941",
                "api_secret", "Nuss-W2OI5t0I111mYZ2sOghANk"));
    }

    @Bean
    public ImageService imageService(){
        return new CloudinaryService();
    }
}
