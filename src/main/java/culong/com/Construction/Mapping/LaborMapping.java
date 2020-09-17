package culong.com.Construction.Mapping;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

import culong.com.Construction.dto.InvoiceDto;
import culong.com.Construction.dto.LaborDto;
import culong.com.Construction.entity.Invoice;
import culong.com.Construction.entity.Labor;
import culong.com.Construction.entity.MaterialLiabilitie;
import culong.com.Construction.repository.MaterialLiabilitieRepository;

public class LaborMapping {
	public static LaborDto convertToDto(Labor labor) {
		PropertyMap<Labor, LaborDto> propertyMap = new PropertyMap<Labor, LaborDto>() {
			protected void configure() {

				map().setListConstruct(source.getListConstruct());

			}
		};

		ModelMapper modelMapper = new ModelMapper();
		modelMapper.addMappings(propertyMap);
		LaborDto laborDto = modelMapper.map(labor, LaborDto.class);

		return laborDto;

	}

	public static Invoice convertToEntity(InvoiceDto invoiceDto,MaterialLiabilitieRepository materialLiabilitieRepository) {
		ModelMapper modelMapper = new ModelMapper();
		Invoice invoice = modelMapper.map(invoiceDto, Invoice.class);

		MaterialLiabilitie materialLiabilitie = materialLiabilitieRepository
				.findById(invoiceDto.getIdMaterialLiabilitie());
		invoice.setMaterialLiabilitie(materialLiabilitie);

		return invoice;

	}
}
