package culong.com.Construction.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Labor")
public class Labor {
	private long id;
	private Set<Construct> listConstruct = new HashSet<Construct>();
	private String nameLabor;
	private String nameConstruct;
	private int totalArea;
	private Double moneyM2;
	private Double coutMoney;
	private Double advanceMoney;
	private Double moneyLeftOver;
	private String note;
	
	@Column(name = "note")
	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Column(name = "nameConstruct")
	public String getNameConstruct() {
		return nameConstruct;
	}

	public void setNameConstruct(String nameConstruct) {
		this.nameConstruct = nameConstruct;
	}

	@Column(name ="totalArea")
	public int getTotalArea() {
		return totalArea;
	}

	public void setTotalArea(int totalArea) {
		this.totalArea = totalArea;
	}

	@Column(name = "moneyM2")
	public Double getMoneyM2() {
		return moneyM2;
	}

	public void setMoneyM2(Double moneyM2) {
		this.moneyM2 = moneyM2;
	}

	@Column(name = "coutMoney")
	public Double getCoutMoney() {
		return coutMoney;
	}

	public void setCoutMoney(Double coutMoney) {
		this.coutMoney = coutMoney;
	}

	@Column(name = "advanceMoney")
	public Double getAdvanceMoney() {
		return advanceMoney;
	}

	public void setAdvanceMoney(Double advanceMoney) {
		this.advanceMoney = advanceMoney;
	}
	
	@Column(name ="moneyLeftOver")
	public Double getMoneyLeftOver() {
		return moneyLeftOver;
	}

	public void setMoneyLeftOver(Double moneyLeftOver) {
		this.moneyLeftOver = moneyLeftOver;
	}

	
	
	
	@Column(name = "nameLabor")
	public String getNameLabor() {
		return nameLabor;
	}

	public void setNameLabor(String nameLabor) {
		this.nameLabor = nameLabor;
	}



	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) 
	@Column(name="idLabor")
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	
	
	@OneToMany(mappedBy = "labor")
	public Set<Construct> getListConstruct() {
		return listConstruct;
	}

	public void setListConstruct(Set<Construct> listConstruct) {
		this.listConstruct = listConstruct;
	}

	
	

}
