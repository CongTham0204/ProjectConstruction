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
