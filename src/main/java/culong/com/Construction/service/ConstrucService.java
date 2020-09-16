package culong.com.Construction.service;

import culong.com.Construction.dto.ConstructDto;

public interface ConstrucService {
	ConstructDto createConstruct(ConstructDto constructDto);
	ConstructDto updateConstruct(ConstructDto constructDto);
	boolean deleteConstruct(long id);
	

}
