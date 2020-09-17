package culong.com.Construction.Mapping;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

import culong.com.Construction.dto.InvoiceDto;
import culong.com.Construction.entity.Invoice;
import culong.com.Construction.entity.MaterialLiabilitie;
import culong.com.Construction.repository.MaterialLiabilitieRepository;

public class InvoiceMapping {
	public static InvoiceDto convertToDto(Invoice invoice) {
		PropertyMap<Invoice, InvoiceDto> propertyMap = new PropertyMap<Invoice, InvoiceDto>() {
			protected void configure() {

				map().setIdMaterialLiabilitie(source.getMaterialLiabilitie().getId());

			}
		};

		ModelMapper modelMapper = new ModelMapper();
		modelMapper.addMappings(propertyMap);
		InvoiceDto invoiceDto = modelMapper.map(invoice, InvoiceDto.class);

		return invoiceDto;

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
