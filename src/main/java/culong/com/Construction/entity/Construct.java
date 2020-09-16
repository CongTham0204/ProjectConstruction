package culong.com.Construction.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "Construct")
public class Construct {

	private long id;
	private Monitoring monitoring;
	private Set<MaterialLiabilitie> listMaterialLiabilitie = new HashSet<MaterialLiabilitie>();
	private Labor labor;
	private java.util.List<Invoice> listInvoices = new ArrayList<Invoice>();
	private Set<ConstructionHistory> listConstructionHistory = new HashSet<ConstructionHistory>();
	

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
	
	
	

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) 
	@Column(name = "idConstruct")
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@ManyToOne
	@JoinColumn(name = "idMonitoring")
	public Monitoring getMonitoring() {
		return monitoring;
	}

	public void setMonitoring(Monitoring monitoring) {
		this.monitoring = monitoring;
	}

	@ManyToOne
	@JoinColumn(name = "idLabor")
	public Labor getLabor() {
		return labor;
	}

	public void setLabor(Labor labor) {
		this.labor = labor;
	}

	@OneToMany(mappedBy = "construct")
	public Set<MaterialLiabilitie> getListMaterialLiabilitie() {
		return listMaterialLiabilitie;
	}

	public void setListMaterialLiabilitie(Set<MaterialLiabilitie> listMaterialLiabilitie) {
		this.listMaterialLiabilitie = listMaterialLiabilitie;
	}
	
	@OneToMany(mappedBy = "construct")
	public java.util.List<Invoice> getListInvoices() {
		return listInvoices;
	}

	public void setListInvoices(java.util.List<Invoice> listInvoices) {
		this.listInvoices = listInvoices;
	}
	
	@OneToMany(mappedBy = "construct")
	public Set<ConstructionHistory> getListConstructionHistory() {
		return listConstructionHistory;
	}

	public void setListConstructionHistory(Set<ConstructionHistory> listConstructionHistory) {
		this.listConstructionHistory = listConstructionHistory;
	}
	
	
	
	@Column(name="Address")
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Column(name="NumberOfFloors")
	public float getNumberOfFloors() {
		return numberOfFloors;
	}
	public void setNumberOfFloors(float numberOfFloors) {
		this.numberOfFloors = numberOfFloors;
	}
	@Column(name="TotalArea")
	public float getTotalArea() {
		return totalArea;
	}

	public void setTotalArea(float string) {
		this.totalArea = string;
	}
	
	
	@Column(name="SignDate")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getSignDay() {
		return signDay;
	}
	public void setSignDay(Date signDay) {
		this.signDay = signDay;
	}
	@Column(name="StartDay")
	public Date getStartDay() {
		return startDay;
	}
	public void setStartDay(Date startDay) {
		this.startDay = startDay;
	}
	@Column(name="AllDateConstruction")
	public int getAllDateConstruction() {
		return allDateConstruction;
	}
	public void setAllDateConstruction(int allDateConstruction) {
		this.allDateConstruction = allDateConstruction;
	}
	
	
	@Column(name="advance")
	public String getAdvance() {
		return advance;
	}
	public void setAdvance(String advance) {
		this.advance = advance;
	}
	
	@Column(name = "progress")
	public String getProgress() {
		return Progress;
	}
	public void setProgress(String progress) {
		this.Progress = progress;
	}
	
	@Column(name = "cost")
	public String getCost() {
		return Cost;
	}
	public void setCost(String cost) {
		this.Cost = cost;
	}
	
	@Column(name = "supplies")
	public String getSupplies() {
		return Supplies;
	}
	public void setSupplies(String supplies) {
		this.Supplies = supplies;
	}
	
	@Column(name = "profits")
	public String getProfits() {
		return Profits;
	}
	public void setProfits(String profits) {
		this.Profits = profits;
	}
	
	@Lob
	@Column(name ="image", columnDefinition = "BLOB")
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}

}
