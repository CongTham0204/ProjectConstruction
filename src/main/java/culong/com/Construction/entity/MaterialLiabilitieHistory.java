package culong.com.Construction.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="MaterialLiabilitieHistory")
public class MaterialLiabilitieHistory {
	private long id;
	private MaterialLiabilitie materialLiabilitie;
	private String importSupplies;
	private float mass;
	private String unit;
	private Date dateAndTimeImport;
	private String supplier;
	private String addressConstruct;
	private String confirm;
	private Date timeConfirm;
	private String confirmationPerson;
	private String note;
	
	
	


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) 
	@Column(name = "idMaterialLiabilitieHistory")
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	@ManyToOne
	@JoinColumn(name="idMaterialLiabilitie")
	public MaterialLiabilitie getMaterialLiabilitie() {
		return materialLiabilitie;
	}

	public void setMaterialLiabilitie(MaterialLiabilitie materialLiabilitie) {
		this.materialLiabilitie = materialLiabilitie;
	}
	@Column(name = "importSupplies")
	public String getImportSupplies() {
		return importSupplies;
	}

	public void setImportSupplies(String importSupplies) {
		this.importSupplies = importSupplies;
	}
	@Column(name = "mass")
	public float getMass() {
		return mass;
	}

	public void setMass(float mass) {
		this.mass = mass;
	}
	@Column(name ="unit")
	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}
	
	@Column(name = "dateAndTimeImport")
	public Date getDateAndTimeImport() {
		return dateAndTimeImport;
	}

	public void setDateAndTimeImport(Date dateAndTimeImport) {
		this.dateAndTimeImport = dateAndTimeImport;
	}

	
	@Column(name = "supplier")
	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	@Column(name = "addressConstruct")
	public String getAddressConstruct() {
		return addressConstruct;
	}

	public void setAddressConstruct(String addressConstruct) {
		this.addressConstruct = addressConstruct;
	}

	@Column(name ="confirm")
	public String getConfirm() {
		return confirm;
	}

	public void setConfirm(String confirm) {
		this.confirm = confirm;
	}

	@Column(name ="timeConfirm")
	public Date getTimeConfirm() {
		return timeConfirm;
	}

	public void setTimeConfirm(Date timeConfirm) {
		this.timeConfirm = timeConfirm;
	}


	@Column(name ="confirmationPerson")
	public String getConfirmationPerson() {
		return confirmationPerson;
	}

	public void setConfirmationPerson(String confirmationPerson) {
		this.confirmationPerson = confirmationPerson;
	}

	@Column(name = "note")
	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
	
	

}
