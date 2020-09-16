package culong.com.Construction.serviceImpl;

import org.hibernate.mapping.Map;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	private ConstrucHistoryDto convertDto(ConstructionHistory constructionHistory) {

		PropertyMap<ConstructionHistory, ConstrucHistoryDto> propertyMap = new PropertyMap<ConstructionHistory, ConstrucHistoryDto>() {
			protected void configure() {

				map().setConstruct(source.getConstruct().getId());
			}
		};

		ModelMapper modelMapper = new ModelMapper();
		modelMapper.addMappings(propertyMap);
		ConstrucHistoryDto constructHistoryDto = modelMapper.map(constructionHistory, ConstrucHistoryDto.class);

		return constructHistoryDto;
	}

	private ConstructionHistory convertEntity(ConstrucHistoryDto construcHistoryDto) {
		ConstructionHistory constructionHistory = modelMapper.map(construcHistoryDto, ConstructionHistory.class);
		Construct construct = constructRepository.findById(construcHistoryDto.getConstruct());

		constructionHistory.setConstruct(construct);
		return constructionHistory;

	}

	@Override
	public ConstrucHistoryDto createConstrucHistory(ConstrucHistoryDto construcHistoryDto) {
		Construct construct = constructRepository.findById(construcHistoryDto.getConstruct());
		if (construct == null) {
			return null;

		}

		ConstructionHistory constructionHistory = construcHistoryRepository.save(convertEntity(construcHistoryDto));

		return convertDto(constructionHistory);
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
			 constructionHistory = construcHistoryRepository.save(convertEntity(construcHistoryDto));
			return convertDto(constructionHistory);
			
		}
		return null;
	}

}
