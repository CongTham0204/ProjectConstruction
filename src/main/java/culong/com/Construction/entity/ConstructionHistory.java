package culong.com.Construction.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ConstructionHistory")
public class ConstructionHistory {
	private long id;
	private Construct construct;
     
	
	@ManyToOne
	@JoinColumn(name = "idContruct")
	public Construct getConstruct() {
		return construct;
	}

	public void setConstruct(Construct construct) {
		this.construct = construct;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) 
	@Column(name="idConstructionHistory")
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	

}
