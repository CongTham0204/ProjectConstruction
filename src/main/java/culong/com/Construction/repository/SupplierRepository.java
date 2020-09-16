package culong.com.Construction.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import culong.com.Construction.entity.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier,Long> {
	Supplier findById(long id);

}
