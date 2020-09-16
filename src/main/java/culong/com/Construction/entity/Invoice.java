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
@Table(name="Invoice")
public class Invoice {
	private long id;
	private String link;
	private Construct construct;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) 
	@Column(name = "id")
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	@ManyToOne
	@JoinColumn(name = "idConstruct")
	public Construct getConstruct() {
		return construct;
	}
	
	public void setConstruct(Construct construct) {
		this.construct = construct;
	}
	
	@Column(name = "link")
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}

}
