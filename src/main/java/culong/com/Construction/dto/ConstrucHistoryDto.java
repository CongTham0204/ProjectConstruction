package culong.com.Construction.dto;

import java.util.Date;

public class ConstrucHistoryDto {
	private long id;
	private long construct;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getDateHistory() {
		return dateHistory;
	}
	public void setDateHistory(Date dateHistory) {
		this.dateHistory = dateHistory;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getCoutLaborVip() {
		return coutLaborVip;
	}
	public void setCoutLaborVip(int coutLaborVip) {
		this.coutLaborVip = coutLaborVip;
	}
	public int getCoutLabor() {
		return coutLabor;
	}
	public void setCoutLabor(int coutLabor) {
		this.coutLabor = coutLabor;
	}
	public String getReport() {
		return report;
	}
	public void setReport(String report) {
		this.report = report;
	}
	public String getProgress() {
		return progress;
	}
	public void setProgress(String progress) {
		this.progress = progress;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
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
	

}
