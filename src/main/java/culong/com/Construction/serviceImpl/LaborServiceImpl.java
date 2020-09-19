package culong.com.Construction.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import culong.com.Construction.Mapping.LaborMapping;
import culong.com.Construction.dto.LaborDto;
import culong.com.Construction.entity.Labor;
import culong.com.Construction.repository.LaborRepository;
import culong.com.Construction.service.LaborService;

@Service
@ControllerAdvice
public class LaborServiceImpl extends ResponseEntityExceptionHandler implements LaborService {

	@Autowired
	LaborRepository laborRepository;

	@Override
	
	public LaborDto createLabor(LaborDto laborDto ) {
		Labor labor = laborRepository.save(LaborMapping.convertToEntity(laborDto));
		return LaborMapping.convertToDto(labor);
		
	}
	
	public LaborDto updateLabor(LaborDto laborDto) {
		
		Labor labor = laborRepository.findById(laborDto.getId());
		if(labor == null) {
			return null;
			
		}
		else {
			
			labor = laborRepository.save(LaborMapping.convertToEntity(laborDto));
		}
		return LaborMapping.convertToDto(labor);
		
	}

}
