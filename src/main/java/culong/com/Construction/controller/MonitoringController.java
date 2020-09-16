package culong.com.Construction.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import culong.com.Construction.dto.MonitoringDto;
import culong.com.Construction.service.MonitoringService;

@RestController
public class MonitoringController {
	@Autowired
	MonitoringService monitoringService;
	
	@RequestMapping(value = "/monitoring", method = RequestMethod.POST)
	@ResponseBody
	public MonitoringDto createMonitoring(@RequestBody MonitoringDto monitoringDto) throws Exception {

		return monitoringService.createMonitoringDto(monitoringDto);

	}

}
