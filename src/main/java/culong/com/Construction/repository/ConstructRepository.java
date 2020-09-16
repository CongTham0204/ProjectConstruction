package culong.com.Construction.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import culong.com.Construction.entity.Construct;

public interface ConstructRepository extends JpaRepository<Construct, Long> {
	Construct findById(long id);

}
