package culong.com.Construction.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import culong.com.Construction.dto.LaborDto;
import culong.com.Construction.entity.Labor;
import culong.com.Construction.repository.LaborRepository;
import culong.com.Construction.service.LaborService;
@Service
public class LaborServiceImpl implements LaborService {

	@Autowired
	LaborRepository laborRepository;
	
	public LaborDto createLabor(LaborDto laborDto) {
		Labor labor = new Labor();
		labor.setId(laborDto.getId());
		labor.setNameLabor(laborDto.getNameLabor());
		laborRepository.save(labor);
		
		
		
		LaborDto laborDto2 = new LaborDto();
		laborDto2.setId(labor.getId());
		laborDto2.setNameLabor(labor.getNameLabor());
		
		
		return laborDto2;
	}
	

}
