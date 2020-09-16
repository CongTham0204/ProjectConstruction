package culong.com.Construction.serviceImpl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import culong.com.Construction.dto.SupplierDto;
import culong.com.Construction.entity.Supplier;
import culong.com.Construction.repository.SupplierRepository;
import culong.com.Construction.service.SupplierService;

@Service
public class SupplierServiceImpl implements SupplierService {

	@Autowired
	SupplierRepository supplierRepository;

	@Autowired
	ModelMapper modelMapper;

	private SupplierDto convertDto(Supplier supplier) {
		SupplierDto supplierDto = modelMapper.map(supplier, SupplierDto.class);

		return supplierDto;

	}

	private Supplier convertEntity(SupplierDto supplierDto) {
		ModelMapper modelMapper = new ModelMapper();
		Supplier supplier = modelMapper.map(supplierDto, Supplier.class);
		return supplier;
	}

	@Override
	public SupplierDto createSupplier(SupplierDto supplierDto) {
		Supplier supplier = new Supplier();
		supplier = supplierRepository.save(convertEntity(supplierDto));

		return convertDto(supplier);

	}

}
