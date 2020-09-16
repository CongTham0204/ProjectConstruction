package culong.com.Construction.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import culong.com.Construction.dto.MaterialLiabilitieHistoryDto;
import culong.com.Construction.entity.MaterialLiabilitieHistory;
import culong.com.Construction.repository.MaterialLiabilitieHistoryRepository;
import culong.com.Construction.service.MaterialLiabilitieHistoryService;

@Service
public class MaterialLiabilitieHistoryServiceImpl implements MaterialLiabilitieHistoryService {
	@Autowired
	MaterialLiabilitieHistoryRepository materialLiabilitieHistoryRepository;

	@Override
	public MaterialLiabilitieHistoryDto createMaterialLiabilitieHistory(
			MaterialLiabilitieHistoryDto materialLiabilitieHistoryDto) {
		MaterialLiabilitieHistory materialLiabilitieHistory = materialLiabilitieHistoryRepository
				.findById(materialLiabilitieHistoryDto.getId());
		if (materialLiabilitieHistory != null) {

			materialLiabilitieHistory.setDateAndTimeImport(materialLiabilitieHistoryDto.getDateAndTimeImport());
			materialLiabilitieHistory.setTimeConfirm(materialLiabilitieHistoryDto.getTimeConfirm());
			materialLiabilitieHistory.setNote(materialLiabilitieHistoryDto.getNote());
			materialLiabilitieHistory.setConfirmationPerson(materialLiabilitieHistoryDto.getConfirmationPerson());
			materialLiabilitieHistory.setMass(materialLiabilitieHistoryDto.getMass());
			materialLiabilitieHistory.setConfirm(materialLiabilitieHistoryDto.getConfirm());
			materialLiabilitieHistory.setTimeConfirm(materialLiabilitieHistoryDto.getTimeConfirm());
			materialLiabilitieHistory.setNote(materialLiabilitieHistoryDto.getNote());
			materialLiabilitieHistoryRepository.save(materialLiabilitieHistory);

			materialLiabilitieHistoryDto = new MaterialLiabilitieHistoryDto();
			materialLiabilitieHistoryDto.setId(materialLiabilitieHistory.getId());
			materialLiabilitieHistoryDto.setDateAndTimeImport(materialLiabilitieHistory.getDateAndTimeImport());
			materialLiabilitieHistoryDto.setTimeConfirm(materialLiabilitieHistory.getTimeConfirm());
			materialLiabilitieHistoryDto.setNote(materialLiabilitieHistory.getNote());
			materialLiabilitieHistoryDto.setConfirmationPerson(materialLiabilitieHistory.getConfirmationPerson());
			materialLiabilitieHistoryDto.setMass(materialLiabilitieHistory.getMass());
			materialLiabilitieHistoryDto.setAddressConstruct(materialLiabilitieHistory.getAddressConstruct());
			materialLiabilitieHistoryDto
					.setMaterialLiabilitie(materialLiabilitieHistory.getMaterialLiabilitie().getId());
			materialLiabilitieHistoryDto.setImportSupplies(materialLiabilitieHistory.getImportSupplies());
			materialLiabilitieHistoryDto.setUnit(materialLiabilitieHistory.getUnit());
			materialLiabilitieHistoryDto.setConfirm(materialLiabilitieHistory.getConfirm());
			materialLiabilitieHistoryDto.setSupplier(String.valueOf(materialLiabilitieHistory.getSupplier()));

			return materialLiabilitieHistoryDto;
		}
		return null;
	}

	@Override
	public MaterialLiabilitieHistoryDto updateMaterialLiabilitieHistory(
			MaterialLiabilitieHistoryDto materialLiabilitieHistoryDto) {
		MaterialLiabilitieHistory materialLiabilitieHistory = materialLiabilitieHistoryRepository
				.findById(materialLiabilitieHistoryDto.getId());
		
		if(materialLiabilitieHistory != null ) {
			
		}
		return null;
	}

	@Override
	public boolean deleteMaterialLiabilitieHistory(long id) {
		// TODO Auto-generated method stub
		return false;
	}

}
