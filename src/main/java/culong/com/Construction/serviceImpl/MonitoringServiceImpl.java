package culong.com.Construction.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import culong.com.Construction.dto.MonitoringDto;
import culong.com.Construction.entity.Monitoring;
import culong.com.Construction.repository.MonitoringRepository;
import culong.com.Construction.service.MonitoringService;

@Service
public class MonitoringServiceImpl implements MonitoringService {
	
	@Autowired
	MonitoringRepository monitoringRepository;
	

	@Override
	public MonitoringDto createMonitoringDto(MonitoringDto monitoringDto) {
		Monitoring monitoring = new Monitoring();
		monitoring.setId(monitoringDto.getId());
		monitoring.setNameMonitoring(monitoringDto.getNameMonitoring());
		
		monitoringRepository.save(monitoring);
		
		MonitoringDto monitoringDto2 = new MonitoringDto();
		
		monitoringDto2.setId(monitoring.getId());
		monitoringDto2.setNameMonitoring(monitoring.getNameMonitoring());
		
		
		
		return monitoringDto2;
	}
	

}
