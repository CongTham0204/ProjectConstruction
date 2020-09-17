package culong.com.Construction.serviceImpl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import culong.com.Construction.Mapping.ConstructHistoryMapping;
import culong.com.Construction.dto.ConstrucHistoryDto;
import culong.com.Construction.entity.Construct;
import culong.com.Construction.entity.ConstructionHistory;
import culong.com.Construction.repository.ConstrucHistoryRepository;
import culong.com.Construction.repository.ConstructRepository;
import culong.com.Construction.service.ConstrucHistoryService;

@Service
public class ConstrucHistoryServiceImpl implements ConstrucHistoryService {

	@Autowired
	ModelMapper modelMapper;
	@Autowired
	ConstructRepository constructRepository;

	@Autowired
	ConstrucHistoryRepository construcHistoryRepository;

	
	@Override
	public ConstrucHistoryDto createConstrucHistory(ConstrucHistoryDto construcHistoryDto) {
		Construct construct = constructRepository.findById(construcHistoryDto.getConstruct());
		if (construct == null) {
			return null;

		}

		ConstructionHistory constructionHistory = construcHistoryRepository.save(ConstructHistoryMapping.convertEntity(construcHistoryDto,constructRepository));

		return ConstructHistoryMapping.convertDto(constructionHistory);
	}

	@Override
	public boolean deleteConstrucHistory(long id) {
		
		ConstructionHistory constructionHistory = construcHistoryRepository.findById(id);
		if(constructionHistory != null) {
			construcHistoryRepository.delete(constructionHistory);
			return true;
		}
		return false;
	}

	@Override
	public ConstrucHistoryDto updateConstrucHistory(ConstrucHistoryDto construcHistoryDto) {
		ConstructionHistory constructionHistory = construcHistoryRepository.findById(construcHistoryDto.getId());
		Construct construct = constructRepository.findById(construcHistoryDto.getConstruct());
		
		if(constructionHistory != null && construct != null) {
			 constructionHistory = construcHistoryRepository.save(ConstructHistoryMapping.convertEntity(construcHistoryDto,constructRepository));
			return ConstructHistoryMapping.convertDto(constructionHistory);
			
		}
		return null;
	}

}
