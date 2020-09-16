package culong.com.Construction.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Company")
public class Company {
	
	private long id;
	private String name;
	
	@Id
	@Column(name = "idCompany")
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	@Column(name = "nameCompany")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
