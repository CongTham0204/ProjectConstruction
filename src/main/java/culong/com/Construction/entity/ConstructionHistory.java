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
@Table(name = "ConstructionHistory")
public class ConstructionHistory {
	private long id;
	private Construct construct;
	private String name;
	private Date startDate;
	private Date endDate;
	private String address;
	private Date dateHistory;
	private String content;
	private int coutLaborVip;
	private int coutLabor;
	private String report;
	private String progress;
	private String note;
	private byte[] image;
	
	
     
	@Column(name = "name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name = "startDate")
	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	@Column(name = "endDate")
	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	@Column(name = "address")
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	@Column(name ="dateHistory")
	public Date getDateHistory() {
		return dateHistory;
	}

	public void setDateHistory(Date dateHistory) {
		this.dateHistory = dateHistory;
	}
	@Column(name = "content")
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	@Column(name = "coutLaborVip")
	public int getCoutLaborVip() {
		return coutLaborVip;
	}

	public void setCoutLaborVip(int coutLaborVip) {
		this.coutLaborVip = coutLaborVip;
	}

	@Column(name="coutLabor")
	public int getCoutLabor() {
		return coutLabor;
	}

	public void setCoutLabor(int coutLabor) {
		this.coutLabor = coutLabor;
	}

	@Column(name = "getReport")
	public String getReport() {
		return report;
	}

	public void setReport(String report) {
		this.report = report;
	}

	@Column(name = "progress")
	public String getProgress() {
		return progress;
	}

	public void setProgress(String progress) {
		this.progress = progress;
	}
	
	@Column(name = "note")
	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Column(name = "image")
	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

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
