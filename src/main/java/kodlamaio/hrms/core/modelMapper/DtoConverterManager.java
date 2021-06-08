package kodlamaio.hrms.core.modelMapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springfox.documentation.swagger2.mappers.ModelMapper;

@Service
public class DtoConverterManager implements DtoConverterService {
	
	/*private ModelMapper modelMapper;
	
	@Autowired
	public DtoConverterManager(Model modelMapper) {
		super();
		this.modelMapper = modelMapper;
	}

	@Override
	public <S, T> List<T> dtoConverter(List<S> s, Class<T> targetClass){
		return s.stream().map(element -> modelMapper.map(element, targetClass)).collect(Collectors.toList());
		
	}
	
	@Override
	public <T> Object dtoClassConverter(Object source,Class<T> baseClass) {
		return modelMapper.map(source,baseClass);
		
	}*/
}
