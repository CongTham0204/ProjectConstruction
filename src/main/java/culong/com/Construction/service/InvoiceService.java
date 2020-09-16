package culong.com.Construction.service;

import culong.com.Construction.dto.InvoiceDto;

public interface InvoiceService {
	InvoiceDto createInvoice(InvoiceDto invoiceDto);
	InvoiceDto updateInvoice(InvoiceDto invoiceDto);
	boolean deleteInvoice(long id);

}
