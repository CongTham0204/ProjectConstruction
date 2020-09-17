package culong.com.Construction.dto;

import java.util.HashSet;
import java.util.Set;


public class LaborDto {
	private long id;
	private String nameLabor;
	private Set<ConstructDto> listConstruct = new HashSet<ConstructDto>();

	

	public Set<ConstructDto> getListConstruct() {
		return listConstruct;
	}

	public void setListConstruct(Set<ConstructDto> listConstruct) {
		this.listConstruct = listConstruct;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNameLabor() {
		return nameLabor;
	}

	public void setNameLabor(String nameLabor) {
		this.nameLabor = nameLabor;
	}

}
