package culong.com.Construction.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "MaterialLiabilitie")
public class MaterialLiabilitie {
	private long id;
	private Construct construct;
	private Supplier supplier;
	private Set<MaterialLiabilitieHistory> listMaterialLiabilitieHistory = new HashSet<MaterialLiabilitieHistory>();
	private Set<Invoice> listInvoices = new HashSet<Invoice>();
	
	@OneToMany(mappedBy = "materialLiabilitie")
	public Set<Invoice> getListInvoices() {
		return listInvoices;
	}

	public void setListInvoices(Set<Invoice> listInvoices) {
		this.listInvoices = listInvoices;
	}

	private String name;
	@Column(name = "nameSupplies")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private String unit;
	private float predictedMass;
	private float enteredMass;
	private float restMass;
	private float price;
	private float valueEntered;
	private float paid;
	private float unPaid;
	private float note;

	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idMaterialLiabilitie", length = 30)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@ManyToOne
	@JoinColumn(name = "idSupplier")
	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	@ManyToOne
	@JoinColumn(name = "idConstruct")
	public Construct getConstruct() {
		return construct;
	}

	public void setConstruct(Construct construct) {
		this.construct = construct;
	}

	@OneToMany(mappedBy = "materialLiabilitie")
	public Set<MaterialLiabilitieHistory> getListMaterialLiabilitieHistory() {
		return listMaterialLiabilitieHistory;
	}

	public void setListMaterialLiabilitieHistory(Set<MaterialLiabilitieHistory> listMaterialLiabilitieHistory) {
		this.listMaterialLiabilitieHistory = listMaterialLiabilitieHistory;
	}
	
	@Column(name = "unit")
	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	@Column(name="predictedMass")
	public float getPredictedMass() {
		return predictedMass;
	}

	public void setPredictedMass(float predictedMass) {
		this.predictedMass = predictedMass;
	}
	
	@Column(name="enteredMass")
	public float getEnteredMass() {
		return enteredMass;
	}

	public void setEnteredMass(float enteredMass) {
		this.enteredMass = enteredMass;
	}
	
	@Column(name = "restMass")
	public float getRestMass() {
		return restMass;
	}

	public void setRestMass(float restMass) {
		this.restMass = restMass;
	}

	@Column(name = "price")
	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	
	@Column(name = "valueEntered")
	public float getValueEntered() {
		return valueEntered;
	}

	public void setValueEntered(float valueEntered) {
		this.valueEntered = valueEntered;
	}

	@Column(name = "paid")
	public float getPaid() {
		return paid;
	}

	public void setPaid(float paid) {
		this.paid = paid;
	}
	
	@Column(name = "unPaid")
	public float getUnPaid() {
		return unPaid;
	}

	public void setUnPaid(float unPaid) {
		this.unPaid = unPaid;
	}

	@Column(name = "note")
	public float getNote() {
		return note;
	}

	public void setNote(float note) {
		this.note = note;
	}
}
