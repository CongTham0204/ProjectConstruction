package culong.com.Construction.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import culong.com.Construction.entity.Monitoring;

public interface MonitoringRepository extends JpaRepository<Monitoring, Long> {
	
		Monitoring findById(long id);
}
