package culong.com.Construction.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import culong.com.Construction.entity.MaterialLiabilitie;

public interface MaterialLiabilitieRepository extends JpaRepository<MaterialLiabilitie, Long> {
	MaterialLiabilitie findById(long id);

}
