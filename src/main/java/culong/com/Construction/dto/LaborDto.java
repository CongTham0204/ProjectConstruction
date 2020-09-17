package culong.com.Construction.dto;

import java.util.HashSet;
import java.util.Set;

import culong.com.Construction.entity.Construct;

public class LaborDto {
	private long id;
	private String nameLabor;
	private Set<Construct> listConstruct = new HashSet<Construct>();

	public Set<Construct> getListConstruct() {
		return listConstruct;
	}

	public void setListConstruct(Set<Construct> listConstruct) {
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
