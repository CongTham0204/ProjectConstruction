package culong.com.Construction.dto;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;



public class ConstructDto {
	private long id;
	private long monitoring;
	private Set<MaterialLiabilitieDto> listMaterialLiabilitie = new HashSet<MaterialLiabilitieDto>();
	private long labor;
	private String nameConstruct;
	
	public String getNameConstruct() {
		return nameConstruct;
	}
	public void setNameConstruct(String nameConstruct) {
		this.nameConstruct = nameConstruct;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getMonitoring() {
		return monitoring;
	}
	public void setMonitoring(long monitoring) {
		this.monitoring = monitoring;
	}
	
	public Set<MaterialLiabilitieDto> getListMaterialLiabilitie() {
		return listMaterialLiabilitie;
	}
	public void setListMaterialLiabilitie(Set<MaterialLiabilitieDto> listMaterialLiabilitie) {
		this.listMaterialLiabilitie = listMaterialLiabilitie;
	}
	public long getLabor() {
		return labor;
	}
	public void setLabor(long labor) {
		this.labor = labor;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public float getNumberOfFloors() {
		return numberOfFloors;
	}
	public void setNumberOfFloors(float numberOfFloors) {
		this.numberOfFloors = numberOfFloors;
	}
	public float getTotalArea() {
		return totalArea;
	}
	public void setTotalArea(float totalArea) {
		this.totalArea = totalArea;
	}
	public Date getSignDay() {
		return signDay;
	}
	public void setSignDay(Date signDay) {
		this.signDay = signDay;
	}
	
	public Date getStartDay() {
		return startDay;
	}
	public void setStartDay(Date startDay) {
		this.startDay = startDay;
	}
	public int getAllDateConstruction() {
		return allDateConstruction;
	}
	public void setAllDateConstruction(int allDateConstruction) {
		this.allDateConstruction = allDateConstruction;
	}
	public String getAdvance() {
		return advance;
	}
	public void setAdvance(String advance) {
		this.advance = advance;
	}
	public String getProgress() {
		return Progress;
	}
	public void setProgress(String progress) {
		Progress = progress;
	}
	public String getCost() {
		return Cost;
	}
	public void setCost(String cost) {
		Cost = cost;
	}
	public String getSupplies() {
		return Supplies;
	}
	public void setSupplies(String supplies) {
		Supplies = supplies;
	}
	public String getProfits() {
		return Profits;
	}
	public void setProfits(String profits) {
		Profits = profits;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}

	
	
	private String address;
	private float numberOfFloors;
	private float totalArea;
	private Date signDay;
	private Date startDay;
	private int allDateConstruction;
	
	private String advance;
	private String Progress;
	private String Cost;
	private String Supplies;
	private String Profits;
	private byte[] image;

}
