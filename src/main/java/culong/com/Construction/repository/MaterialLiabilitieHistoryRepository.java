package culong.com.Construction.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import culong.com.Construction.entity.MaterialLiabilitieHistory;

public interface MaterialLiabilitieHistoryRepository extends JpaRepository<MaterialLiabilitieHistory, Long> {
	MaterialLiabilitieHistory findById(long id);
}
