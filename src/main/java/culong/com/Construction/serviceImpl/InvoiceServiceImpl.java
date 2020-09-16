package culong.com.Construction.serviceImpl;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import culong.com.Construction.dto.ConstructDto;
import culong.com.Construction.dto.InvoiceDto;
import culong.com.Construction.entity.Construct;
import culong.com.Construction.entity.Invoice;
import culong.com.Construction.entity.Labor;
import culong.com.Construction.entity.MaterialLiabilitie;
import culong.com.Construction.entity.Monitoring;
import culong.com.Construction.repository.InvoiceRepository;
import culong.com.Construction.repository.MaterialLiabilitieRepository;
import culong.com.Construction.service.InvoiceService;

@Service
public class InvoiceServiceImpl implements InvoiceService {
	
	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	InvoiceRepository invoiceRepository;
	
	@Autowired
	MaterialLiabilitieRepository materialLiabilitieRepository;
	private InvoiceDto convertToDto(Invoice invoice) {
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

	private Invoice convertToEntity(InvoiceDto invoiceDto) {
		Invoice invoice = modelMapper.map(invoiceDto, Invoice.class);

		MaterialLiabilitie materialLiabilitie = materialLiabilitieRepository.findById(invoiceDto.getIdMaterialLiabilitie());
		invoice.setMaterialLiabilitie(materialLiabilitie);

		return invoice;

	}

	
	
	
	
	
	@Override
	public InvoiceDto createInvoice(InvoiceDto invoiceDto) {
		 MaterialLiabilitie materialLiabilitie = materialLiabilitieRepository.findById(invoiceDto.getIdMaterialLiabilitie());
		if(materialLiabilitie != null) {
			Invoice invoice = invoiceRepository.save(convertToEntity(invoiceDto));
			return convertToDto(invoice);
			
		}
		 return null;
	}

	@Override
	public InvoiceDto updateInvoice(InvoiceDto invoiceDto) {
		 MaterialLiabilitie materialLiabilitie = materialLiabilitieRepository.findById(invoiceDto.getIdMaterialLiabilitie());
		 Invoice invoice = invoiceRepository.findById(invoiceDto.getId());
		 if(materialLiabilitie != null && invoice !=null) {
			 		Invoice invoiceUpdate = invoiceRepository.save(invoice);
			 		return convertToDto(invoiceUpdate);
		}
		 return null;
	}

	@Override
	public boolean deleteInvoice(long id) {
		Invoice invoice = invoiceRepository.findById(id);
		if(invoice != null) {
			invoiceRepository.delete(invoice);
			return true;
		}
		
		return false;
	}

}
