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
@Table(name = "Monitoring")
public class Monitoring {
	private long id;
	private Set<Construct> listConstruct = new HashSet<Construct>();
	private String nameMonitoring;
	
	

	@OneToMany(mappedBy = "monitoring")
	public Set<Construct> getListConstruct() {
		return listConstruct;
	}

	public void setListConstruct(Set<Construct> listConstruct) {
		this.listConstruct = listConstruct;
	}
	
	@Column(name = "nameMonitoring")
	public String getNameMonitoring() {
		return nameMonitoring;
	}

	public void setNameMonitoring(String nameMonitoring) {
		this.nameMonitoring = nameMonitoring;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) 
	@Column(name="idMonitoring")
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	

}
