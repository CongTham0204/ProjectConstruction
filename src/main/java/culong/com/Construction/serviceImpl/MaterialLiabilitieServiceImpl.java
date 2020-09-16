package culong.com.Construction.serviceImpl;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import culong.com.Construction.dto.MaterialLiabilitieDto;
import culong.com.Construction.entity.Construct;
import culong.com.Construction.entity.MaterialLiabilitie;
import culong.com.Construction.entity.MaterialLiabilitieHistory;
import culong.com.Construction.entity.Supplier;
import culong.com.Construction.repository.ConstructRepository;
import culong.com.Construction.repository.MaterialLiabilitieHistoryRepository;
import culong.com.Construction.repository.MaterialLiabilitieRepository;
import culong.com.Construction.repository.SupplierRepository;
import culong.com.Construction.service.MaterialLiabilitieService;

@Service
public class MaterialLiabilitieServiceImpl implements MaterialLiabilitieService {

	@Autowired
	ModelMapper modelMapper;

	@Autowired
	MaterialLiabilitieRepository materialLiabilitieRepository;

	@Autowired
	MaterialLiabilitieHistoryRepository materialLiabilitieHistoryRepository;

	@Autowired
	ConstructRepository constructRepository;

	@Autowired
	SupplierRepository supplierRepository;

	private MaterialLiabilitieDto convertDto(MaterialLiabilitie materialLiabilitie) {
		PropertyMap<MaterialLiabilitie, MaterialLiabilitieDto> propertyMap = new PropertyMap<MaterialLiabilitie, MaterialLiabilitieDto>() {
			protected void configure() {
				map().setConstruct(source.getConstruct().getId());
				map().setSupplier(source.getSupplier().getId());
			}

		};
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.addMappings(propertyMap);
		MaterialLiabilitieDto materialLiabilitieDto = new MaterialLiabilitieDto();
		materialLiabilitieDto = modelMapper.map(materialLiabilitie, MaterialLiabilitieDto.class);
		return materialLiabilitieDto;

	}

	private MaterialLiabilitie convertEntity(MaterialLiabilitieDto materialLiabilitieDto) {
		MaterialLiabilitie materialLiabilitie = modelMapper.map(materialLiabilitieDto, MaterialLiabilitie.class);
		Construct construct = constructRepository.findById(materialLiabilitieDto.getConstruct());
		materialLiabilitie.setConstruct(construct);
		Supplier supplier = supplierRepository.findById(materialLiabilitieDto.getSupplier());
		materialLiabilitie.setSupplier(supplier);

		return materialLiabilitie;

	}

	@Override
	public MaterialLiabilitieDto createMaterialLiabilitie(MaterialLiabilitieDto materialLiabilitieDto) {
		Construct construct = new Construct();
		construct = constructRepository.findById(materialLiabilitieDto.getConstruct());
		Supplier supplier = new Supplier();
		supplier = supplierRepository.findById(materialLiabilitieDto.getSupplier());
		MaterialLiabilitie materialLiabilitie = new MaterialLiabilitie();
		if (construct == null || supplier == null) {
			return null;
		} else {
			materialLiabilitie = materialLiabilitieRepository.save(convertEntity(materialLiabilitieDto));
			MaterialLiabilitieHistory materialLiabilitieHistory = new MaterialLiabilitieHistory();
			materialLiabilitieHistory.setMaterialLiabilitie(materialLiabilitie);
			materialLiabilitieHistory.setAddressConstruct(materialLiabilitie.getConstruct().getAddress());
			materialLiabilitieHistory.setSupplier(String.valueOf(materialLiabilitie.getSupplier().getId()));
			materialLiabilitieHistory.setUnit(materialLiabilitie.getUnit());
			materialLiabilitieHistory.setImportSupplies(materialLiabilitie.getName());

			materialLiabilitieHistoryRepository.save(materialLiabilitieHistory);

		}

		return convertDto(materialLiabilitie);
	}

	@Override
	public MaterialLiabilitieDto updateMaterialLiabilitieDto(MaterialLiabilitieDto materialLiabilitieDto) {
		MaterialLiabilitie materialLiabilitie = materialLiabilitieRepository.findById(materialLiabilitieDto.getId());
		Construct construct = constructRepository.findById(materialLiabilitieDto.getConstruct());
		Supplier supplier = supplierRepository.findById(materialLiabilitieDto.getSupplier());

		if (materialLiabilitie != null && construct != null &&  supplier !=null) {
			materialLiabilitie = materialLiabilitieRepository.save(convertEntity(materialLiabilitieDto));
			return convertDto(materialLiabilitie);
		} 
		return null;
	}
	
	@Override
	public boolean deleteMaterialLiabilitieDto(long id) {
		MaterialLiabilitie materialLiabilitie = materialLiabilitieRepository.findById(id);
		if(materialLiabilitie != null) {
			materialLiabilitieRepository.delete(materialLiabilitie);
			return true;
		}
		return false;
	}

}
