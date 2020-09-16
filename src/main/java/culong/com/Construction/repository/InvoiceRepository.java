package culong.com.Construction.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import culong.com.Construction.entity.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
	Invoice findById(long id);

}
