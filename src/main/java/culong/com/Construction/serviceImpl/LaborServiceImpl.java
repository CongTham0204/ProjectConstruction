package culong.com.Construction.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import culong.com.Construction.dto.LaborDto;
import culong.com.Construction.repository.LaborRepository;
import culong.com.Construction.service.LaborService;
@Service
public class LaborServiceImpl implements LaborService {

	@Autowired
	LaborRepository laborRepository;
	
	@Override
	public LaborDto createLabor(LaborDto laborDto) {
		
		
		return null;
	}
	

}
