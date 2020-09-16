package culong.com.Construction.dto;

import java.util.Date;


public class MaterialLiabilitieHistoryDto {
	private long id;
	private long materialLiabilitie;
	private String importSupplies;
	private float mass;
	private String unit;
	private Date dateAndTimeImport;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getMaterialLiabilitie() {
		return materialLiabilitie;
	}
	public void setMaterialLiabilitie(long materialLiabilitie) {
		this.materialLiabilitie = materialLiabilitie;
	}
	public String getImportSupplies() {
		return importSupplies;
	}
	public void setImportSupplies(String importSupplies) {
		this.importSupplies = importSupplies;
	}
	public float getMass() {
		return mass;
	}
	public void setMass(float mass) {
		this.mass = mass;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public Date getDateAndTimeImport() {
		return dateAndTimeImport;
	}
	public void setDateAndTimeImport(Date dateAndTimeImport) {
		this.dateAndTimeImport = dateAndTimeImport;
	}
	public String getSupplier() {
		return supplier;
	}
	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}
	public String getAddressConstruct() {
		return addressConstruct;
	}
	public void setAddressConstruct(String addressConstruct) {
		this.addressConstruct = addressConstruct;
	}
	public String getConfirm() {
		return confirm;
	}
	public void setConfirm(String confirm) {
		this.confirm = confirm;
	}
	public Date getTimeConfirm() {
		return timeConfirm;
	}
	public void setTimeConfirm(Date timeConfirm) {
		this.timeConfirm = timeConfirm;
	}
	public String getConfirmationPerson() {
		return confirmationPerson;
	}
	public void setConfirmationPerson(String confirmationPerson) {
		this.confirmationPerson = confirmationPerson;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	private String supplier;
	private String addressConstruct;
	private String confirm;
	private Date timeConfirm;
	private String confirmationPerson;
	private String note;
}
