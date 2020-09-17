package culong.com.Construction.Mapping;

import java.util.HashSet;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

import culong.com.Construction.dto.ConstructDto;
import culong.com.Construction.dto.InvoiceDto;
import culong.com.Construction.dto.LaborDto;
import culong.com.Construction.entity.Construct;
import culong.com.Construction.entity.Invoice;
import culong.com.Construction.entity.Labor;
import culong.com.Construction.entity.MaterialLiabilitie;
import culong.com.Construction.repository.MaterialLiabilitieRepository;

public class LaborMapping {
	public static LaborDto convertToDto(Labor labor) {
		PropertyMap<Labor, LaborDto> propertyMap = new PropertyMap<Labor, LaborDto>() {
			protected void configure() {

				Set<Construct> list = labor.getListConstruct();
				Set<ConstructDto> listLabor = new HashSet<ConstructDto>();
				for (Construct construct : list) {
					ConstructDto constructDto =new ConstructDto();
					constructDto.setId(construct.getId());
					listLabor.add(constructDto);
				}
				map().setListConstruct(listLabor);

			}
		};

		ModelMapper modelMapper = new ModelMapper();
		modelMapper.addMappings(propertyMap);
		LaborDto laborDto = modelMapper.map(labor, LaborDto.class);

		return laborDto;

	}

	public static Labor convertToEntity(LaborDto laborDto ) {
		ModelMapper modelMapper = new ModelMapper();
		Labor labor = modelMapper.map(laborDto, Labor.class);


		return labor;

	}
}
