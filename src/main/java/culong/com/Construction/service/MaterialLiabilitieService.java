package culong.com.Construction.service;

import culong.com.Construction.dto.MaterialLiabilitieDto;

public interface MaterialLiabilitieService {
	MaterialLiabilitieDto createMaterialLiabilitie(MaterialLiabilitieDto materialLiabilitieDto);
	MaterialLiabilitieDto updateMaterialLiabilitieDto(MaterialLiabilitieDto materialLiabilitieDto);
	boolean deleteMaterialLiabilitieDto(long id);
}
