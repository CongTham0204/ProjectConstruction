package culong.com.Construction.Mapping;

import java.util.HashSet;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;

import culong.com.Construction.dto.ConstructDto;
import culong.com.Construction.dto.MaterialLiabilitieDto;
import culong.com.Construction.entity.Construct;
import culong.com.Construction.entity.Labor;
import culong.com.Construction.entity.MaterialLiabilitie;
import culong.com.Construction.entity.Monitoring;
import culong.com.Construction.repository.LaborRepository;
import culong.com.Construction.repository.MonitoringRepository;

public class ConstructMapping {

	public static ConstructDto convertToDto(Construct construct) {
		PropertyMap<Construct, ConstructDto> propertyMap = new PropertyMap<Construct, ConstructDto>() {
			protected void configure() {

				map().setMonitoring(source.getMonitoring().getId());
				map().setLabor(source.getLabor().getId());
				Set<MaterialLiabilitie> list = construct.getListMaterialLiabilitie();
				Set<MaterialLiabilitieDto> listMaterialLiabilitie = new HashSet<MaterialLiabilitieDto>();

				for (MaterialLiabilitie materialLiabilitie : list) {
					MaterialLiabilitieDto materialLiabilitieDto = new MaterialLiabilitieDto();
					materialLiabilitieDto.setId(materialLiabilitie.getId());
					listMaterialLiabilitie.add(materialLiabilitieDto);

				}
				map().setListMaterialLiabilitie(listMaterialLiabilitie);
			}
		};

		ModelMapper modelMapper = new ModelMapper();
		modelMapper.addMappings(propertyMap);
		ConstructDto constructDto = modelMapper.map(construct, ConstructDto.class);

		return constructDto;

	}

	public static Construct convertToEntity(ConstructDto constructDto, MonitoringRepository monitoringRepository,
			LaborRepository laborRepository) {
		ModelMapper modelMapper = new ModelMapper();

		Construct construct = modelMapper.map(constructDto, Construct.class);
		Monitoring monitoring = monitoringRepository.findById(constructDto.getMonitoring());

		construct.setMonitoring(monitoring);
		Labor labor = laborRepository.findById(constructDto.getLabor());

		construct.setLabor(labor);

		return construct;

	}

}
