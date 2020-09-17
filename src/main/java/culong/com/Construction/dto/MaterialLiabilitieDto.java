package culong.com.Construction.dto;

import java.util.HashSet;
import java.util.Set;

import culong.com.Construction.entity.Invoice;
import culong.com.Construction.entity.MaterialLiabilitieHistory;

public class MaterialLiabilitieDto {
	private long id;
	private String name;
	private long supplier;
	private Set<MaterialLiabilitieHistory> listMaterialLiabilitieHistory = new HashSet<MaterialLiabilitieHistory>();
	private Set<Invoice> listInvoices = new HashSet<Invoice>();

	public Set<MaterialLiabilitieHistory> getListMaterialLiabilitieHistory() {
		return listMaterialLiabilitieHistory;
	}

	public void setListMaterialLiabilitieHistory(Set<MaterialLiabilitieHistory> listMaterialLiabilitieHistory) {
		this.listMaterialLiabilitieHistory = listMaterialLiabilitieHistory;
	}

	public Set<Invoice> getListInvoices() {
		return listInvoices;
	}

	public void setListInvoices(Set<Invoice> listInvoices) {
		this.listInvoices = listInvoices;
	}

	public long getSupplier() {
		return supplier;
	}

	public void setSupplier(long supplier) {
		this.supplier = supplier;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private long construct;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getConstruct() {
		return construct;
	}

	public void setConstruct(long construct) {
		this.construct = construct;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public float getPredictedMass() {
		return predictedMass;
	}

	public void setPredictedMass(float predictedMass) {
		this.predictedMass = predictedMass;
	}

	public float getEnteredMass() {
		return enteredMass;
	}

	public void setEnteredMass(float enteredMass) {
		this.enteredMass = enteredMass;
	}

	public float getRestMass() {
		return restMass;
	}

	public void setRestMass(float restMass) {
		this.restMass = restMass;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public float getValueEntered() {
		return valueEntered;
	}

	public void setValueEntered(float valueEntered) {
		this.valueEntered = valueEntered;
	}

	public float getPaid() {
		return paid;
	}

	public void setPaid(float paid) {
		this.paid = paid;
	}

	public float getUnPaid() {
		return unPaid;
	}

	public void setUnPaid(float unPaid) {
		this.unPaid = unPaid;
	}

	public float getNote() {
		return note;
	}

	public void setNote(float note) {
		this.note = note;
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

}
