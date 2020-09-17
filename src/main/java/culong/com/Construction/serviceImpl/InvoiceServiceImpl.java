package culong.com.Construction.serviceImpl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import culong.com.Construction.Mapping.InvoiceMapping;
import culong.com.Construction.dto.InvoiceDto;
import culong.com.Construction.entity.Invoice;
import culong.com.Construction.entity.MaterialLiabilitie;
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

	

	@Override
	public InvoiceDto createInvoice(InvoiceDto invoiceDto) {
		MaterialLiabilitie materialLiabilitie = materialLiabilitieRepository
				.findById(invoiceDto.getIdMaterialLiabilitie());
		if (materialLiabilitie != null) {
			Invoice invoice = invoiceRepository.save(InvoiceMapping.convertToEntity(invoiceDto,materialLiabilitieRepository));
			return InvoiceMapping.convertToDto(invoice);

		}
		return null;
	}

	@Override
	public InvoiceDto updateInvoice(InvoiceDto invoiceDto) {
		MaterialLiabilitie materialLiabilitie = materialLiabilitieRepository
				.findById(invoiceDto.getIdMaterialLiabilitie());
		Invoice invoice = invoiceRepository.findById(invoiceDto.getId());
		if (materialLiabilitie != null && invoice != null) {
			Invoice invoiceUpdate = invoiceRepository.save(invoice);
			return InvoiceMapping.convertToDto(invoiceUpdate);
		}
		return null;
	}

	@Override
	public boolean deleteInvoice(long id) {
		Invoice invoice = invoiceRepository.findById(id);
		if (invoice != null) {
			invoiceRepository.delete(invoice);
			return true;
		}

		return false;
	}

}
