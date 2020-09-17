package culong.com.Construction.Mapping;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

import culong.com.Construction.dto.MaterialLiabilitieDto;
import culong.com.Construction.entity.Construct;
import culong.com.Construction.entity.MaterialLiabilitie;
import culong.com.Construction.entity.Supplier;
import culong.com.Construction.repository.ConstructRepository;
import culong.com.Construction.repository.SupplierRepository;

public class MaterialLiabilitieMapping {
	public static MaterialLiabilitieDto convertDto(MaterialLiabilitie materialLiabilitie) {
		PropertyMap<MaterialLiabilitie, MaterialLiabilitieDto> propertyMap = new PropertyMap<MaterialLiabilitie, MaterialLiabilitieDto>() {
			protected void configure() {
				map().setConstruct(source.getConstruct().getId());
				map().setSupplier(source.getSupplier().getId());
			}

		};
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.addMappings(propertyMap);
		MaterialLiabilitieDto materialLiabilitieDto = new MaterialLiabilitieDto();
		materialLiabilitieDto = modelMapper.map(materialLiabilitie, MaterialLiabilitieDto.class);
		return materialLiabilitieDto;

	}

	public static MaterialLiabilitie convertEntity(MaterialLiabilitieDto materialLiabilitieDto,
			ConstructRepository constructRepository, SupplierRepository supplierRepository) {
		ModelMapper modelMapper = new ModelMapper();
		MaterialLiabilitie materialLiabilitie = modelMapper.map(materialLiabilitieDto, MaterialLiabilitie.class);
		Construct construct = constructRepository.findById(materialLiabilitieDto.getConstruct());
		materialLiabilitie.setConstruct(construct);
		Supplier supplier = supplierRepository.findById(materialLiabilitieDto.getSupplier());
		materialLiabilitie.setSupplier(supplier);

		return materialLiabilitie;

	}

}
