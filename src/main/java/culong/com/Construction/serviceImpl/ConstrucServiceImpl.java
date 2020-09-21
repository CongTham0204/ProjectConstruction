package culong.com.Construction.serviceImpl;

import java.util.HashSet;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import culong.com.Construction.ServiceException;
import culong.com.Construction.Mapping.ConstructMapping;
import culong.com.Construction.dto.ConstructDto;
import culong.com.Construction.entity.Construct;
import culong.com.Construction.entity.ConstructionHistory;
import culong.com.Construction.entity.Labor;
import culong.com.Construction.entity.MaterialLiabilitie;
import culong.com.Construction.entity.MaterialLiabilitieHistory;
import culong.com.Construction.entity.Monitoring;
import culong.com.Construction.exception.ServiceExceptionMessage;
import culong.com.Construction.repository.ConstrucHistoryRepository;
import culong.com.Construction.repository.ConstructRepository;
import culong.com.Construction.repository.InvoiceRepository;
import culong.com.Construction.repository.LaborRepository;
import culong.com.Construction.repository.MaterialLiabilitieHistoryRepository;
import culong.com.Construction.repository.MaterialLiabilitieRepository;
import culong.com.Construction.repository.MonitoringRepository;
import culong.com.Construction.service.ConstrucService;

@Service
public class ConstrucServiceImpl implements ConstrucService {

	@Autowired
	MonitoringRepository monitoringRepository;
	@Autowired
	LaborRepository laborRepository;
	@Autowired
	ConstructRepository constructRepository;

	@Autowired
	MaterialLiabilitieRepository materialLiabilitieRepository;

	@Autowired
	ConstrucHistoryRepository construcHistoryRepository;

	@Autowired
	MaterialLiabilitieHistoryRepository materialLiabilitieHistoryRepository;

	@Autowired
	InvoiceRepository invoiceRepository;

	@Autowired
	ModelMapper modelMapper;

	@Override
	public ConstructDto createConstruct(ConstructDto constructDto) {
		Monitoring monitoring = monitoringRepository.findById(constructDto.getMonitoring());
		Labor labor = laborRepository.findById(constructDto.getLabor());
		Construct construct = new Construct();
		if (monitoring == null || labor == null) {
			return null;
		} else {
			construct = constructRepository
					.save(ConstructMapping.convertToEntity(constructDto, monitoringRepository, laborRepository));

			return ConstructMapping.convertToDto(construct);
		}

	}

	@Override
	public ConstructDto updateConstruct(ConstructDto constructDto) throws Exception {
		Construct construct = constructRepository.findById(constructDto.getId());
		Labor labor = laborRepository.findById(constructDto.getLabor());
		Monitoring monitoring = monitoringRepository.findById(constructDto.getMonitoring());
		if (construct == null && labor == null && monitoring == null) {
			throw new ServiceException(ServiceExceptionMessage.CONTRUCT_NOT_FOUND_CODE,
					ServiceExceptionMessage.CONTRUCT_LABOR_MONITORING_NOT_FOUND_MESSAGE);
		}
		if(construct == null && labor ==null && monitoring != null) {
			throw new ServiceException(ServiceExceptionMessage.CONTRUCT_NOT_FOUND_CODE, ServiceExceptionMessage.CONTRUCT_LABOR_NOT_FOUND_MESSAGE);
			
		}
		if(construct == null && labor !=null && monitoring == null) {
			throw new ServiceException(ServiceExceptionMessage.CONTRUCT_NOT_FOUND_CODE, ServiceExceptionMessage.CONTRUCT_MONITORING_NOT_FOUND_MESSAGE);
			
		}
		if(construct != null && labor ==null && monitoring == null) {
			throw new ServiceException(ServiceExceptionMessage.CONTRUCT_NOT_FOUND_CODE, ServiceExceptionMessage.MONITORING_LABOR_NOT_FOUND_MESSAGE);
			
		}
		
		

		if (construct == null) {

			throw new ServiceException(ServiceExceptionMessage.CONTRUCT_NOT_FOUND_CODE,
					ServiceExceptionMessage.CONTRUCT_NOT_FOUND_MESSAGE);

		}
		if (labor == null) {
			throw new ServiceException(ServiceExceptionMessage.CONTRUCT_NOT_FOUND_CODE,
					ServiceExceptionMessage.LABOR_NOT_FOUND_MESSAGE);

		}
		if (monitoring == null) {
			throw new ServiceException(ServiceExceptionMessage.CONTRUCT_NOT_FOUND_CODE,
					ServiceExceptionMessage.MONITỎING_NOT_FOUND_MESSAGE);
		}

		construct = constructRepository
				.save(ConstructMapping.convertToEntity(constructDto, monitoringRepository, laborRepository));
		return ConstructMapping.convertToDto(construct);

	}

	@Override
	public boolean deleteConstruct(long id) {
		Construct construct = constructRepository.findById(id);
		if (construct != null) {
			Set<ConstructionHistory> listConstructionHistory = construct.getListConstructionHistory();
			for (ConstructionHistory constructionHistorydelete : listConstructionHistory) {
				construcHistoryRepository.delete(constructionHistorydelete);

			}

			Set<MaterialLiabilitie> listMaterialLiabilitie = construct.getListMaterialLiabilitie();
			for (MaterialLiabilitie materialLiabilitie : listMaterialLiabilitie) {
				Set<MaterialLiabilitieHistory> listMaterialLiabilitieHistory = new HashSet<MaterialLiabilitieHistory>();
				listMaterialLiabilitieHistory = materialLiabilitie.getListMaterialLiabilitieHistory();
				for (MaterialLiabilitieHistory materialLiabilitieHistorydelete : listMaterialLiabilitieHistory) {

					materialLiabilitieHistoryRepository.delete(materialLiabilitieHistorydelete);

				}

				materialLiabilitieRepository.delete(materialLiabilitie);

			}

			constructRepository.delete(construct);
			return true;
		}
		return false;
	}

}
