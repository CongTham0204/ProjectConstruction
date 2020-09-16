package culong.com.Construction.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import culong.com.Construction.entity.ConstructionHistory;

public interface ConstrucHistoryRepository extends JpaRepository<ConstructionHistory, Long>{

		ConstructionHistory findById(long id);
}
