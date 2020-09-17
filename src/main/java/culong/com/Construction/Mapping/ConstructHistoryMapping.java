package culong.com.Construction.Mapping;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

import culong.com.Construction.dto.ConstrucHistoryDto;
import culong.com.Construction.entity.Construct;
import culong.com.Construction.entity.ConstructionHistory;
import culong.com.Construction.repository.ConstructRepository;

public class ConstructHistoryMapping {
	public static ConstrucHistoryDto convertDto(ConstructionHistory constructionHistory) {

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

	public static ConstructionHistory convertEntity(ConstrucHistoryDto construcHistoryDto , ConstructRepository constructRepository) {
		ModelMapper modelMapper = new ModelMapper();
		ConstructionHistory constructionHistory = modelMapper.map(construcHistoryDto, ConstructionHistory.class);
		Construct construct = constructRepository.findById(construcHistoryDto.getConstruct());

		constructionHistory.setConstruct(construct);
		return constructionHistory;

	}

}
