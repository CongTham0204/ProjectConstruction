package culong.com.Construction.serviceImpl;

import java.util.Set;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import culong.com.Construction.Mapping.MaterialLiabilitieMapping;
import culong.com.Construction.dto.MaterialLiabilitieDto;
import culong.com.Construction.entity.Construct;
import culong.com.Construction.entity.Invoice;
import culong.com.Construction.entity.MaterialLiabilitie;
import culong.com.Construction.entity.MaterialLiabilitieHistory;
import culong.com.Construction.entity.Supplier;
import culong.com.Construction.repository.ConstructRepository;
import culong.com.Construction.repository.InvoiceRepository;
import culong.com.Construction.repository.MaterialLiabilitieHistoryRepository;
import culong.com.Construction.repository.MaterialLiabilitieRepository;
import culong.com.Construction.repository.SupplierRepository;
import culong.com.Construction.service.MaterialLiabilitieService;

@Service
public class MaterialLiabilitieServiceImpl implements MaterialLiabilitieService {

	@Autowired
	ModelMapper modelMapper;

	@Autowired
	InvoiceRepository invoiceRepository;

	@Autowired
	MaterialLiabilitieRepository materialLiabilitieRepository;

	@Autowired
	MaterialLiabilitieHistoryRepository materialLiabilitieHistoryRepository;

	@Autowired
	ConstructRepository constructRepository;

	@Autowired
	SupplierRepository supplierRepository;

	@Override
	public MaterialLiabilitieDto createMaterialLiabilitie(MaterialLiabilitieDto materialLiabilitieDto) {
		Construct construct = constructRepository.findById(materialLiabilitieDto.getConstruct());
		Supplier supplier = supplierRepository.findById(materialLiabilitieDto.getSupplier());
		MaterialLiabilitie materialLiabilitie = new MaterialLiabilitie();
		if (construct == null || supplier == null) {
			return null;
		} else {
			materialLiabilitie = materialLiabilitieRepository.save(MaterialLiabilitieMapping
					.convertEntity(materialLiabilitieDto, constructRepository, supplierRepository));
			

			MaterialLiabilitieHistory materialLiabilitieHistory = new MaterialLiabilitieHistory();
			materialLiabilitieHistory.setMaterialLiabilitie(materialLiabilitie);
			materialLiabilitieHistory.setAddressConstruct(materialLiabilitie.getConstruct().getAddress());
			materialLiabilitieHistory.setSupplier(String.valueOf(materialLiabilitie.getSupplier().getId()));
			materialLiabilitieHistory.setUnit(materialLiabilitie.getUnit());
			materialLiabilitieHistory.setImportSupplies(materialLiabilitie.getName());

			materialLiabilitieHistoryRepository.save(materialLiabilitieHistory);
			return MaterialLiabilitieMapping.convertDto(materialLiabilitie);
		}

		
	}

	@Override
	public MaterialLiabilitieDto updateMaterialLiabilitieDto(MaterialLiabilitieDto materialLiabilitieDto) {
		MaterialLiabilitie materialLiabilitie = materialLiabilitieRepository.findById(materialLiabilitieDto.getId());
		Construct construct = constructRepository.findById(materialLiabilitieDto.getConstruct());
		Supplier supplier = supplierRepository.findById(materialLiabilitieDto.getSupplier());

		if (materialLiabilitie != null && construct != null && supplier != null) {
			materialLiabilitie = materialLiabilitieRepository.save(MaterialLiabilitieMapping
					.convertEntity(materialLiabilitieDto, constructRepository, supplierRepository));
			return MaterialLiabilitieMapping.convertDto(materialLiabilitie);
		}
		return null;
	}

	@Override
	public boolean deleteMaterialLiabilitie(long id) {
		MaterialLiabilitie materialLiabilitie = materialLiabilitieRepository.findById(id);
		if (materialLiabilitie != null) {
			Set<Invoice> listInvoice = materialLiabilitie.getListInvoices();
			for (Invoice invoice : listInvoice) {
				invoiceRepository.delete(invoice);
			}
			Set<MaterialLiabilitieHistory> listmaterialLiabilitieHistory = materialLiabilitie
					.getListMaterialLiabilitieHistory();
			for (MaterialLiabilitieHistory materialLiabilitieHistory : listmaterialLiabilitieHistory) {
				materialLiabilitieHistoryRepository.delete(materialLiabilitieHistory);
			}
			materialLiabilitieRepository.delete(materialLiabilitie);
			return true;
		}
		return false;
	}

}
