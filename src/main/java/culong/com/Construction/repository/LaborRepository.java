package culong.com.Construction.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import culong.com.Construction.entity.Labor;

public interface LaborRepository extends JpaRepository<Labor, Long> {
	
	Labor findById(long id);
	

}
