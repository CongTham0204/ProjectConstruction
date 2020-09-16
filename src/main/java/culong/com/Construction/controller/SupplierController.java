package culong.com.Construction.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import culong.com.Construction.dto.SupplierDto;
import culong.com.Construction.service.SupplierService;

@RestController
public class SupplierController {
	
	@Autowired
	SupplierService supplierService;
	
	@RequestMapping(value = "/suppliers", method = RequestMethod.POST)
	@ResponseBody
	public SupplierDto createSupplier(@RequestBody SupplierDto supplierDto) {

		return supplierService.createSupplier(supplierDto);

	}

}
