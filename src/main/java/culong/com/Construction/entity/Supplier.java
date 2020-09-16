package culong.com.Construction.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Supplier")
public class Supplier {
	private long id;
	private List<MaterialLiabilitie> listMaterialLiabilitie = new ArrayList<MaterialLiabilitie>();
	private int phoneNumber;
	

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) 
	@Column(name = "idSupplier")
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	@OneToMany(mappedBy = "supplier")
	public List<MaterialLiabilitie> getListMaterialLiabilitie() {
		return listMaterialLiabilitie;
	}

	public void setListMaterialLiabilitie(List<MaterialLiabilitie> listMaterialLiabilitie) {
		this.listMaterialLiabilitie = listMaterialLiabilitie;
	}
	
	@Column(name = "phoneNumber")
	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	


	

}
