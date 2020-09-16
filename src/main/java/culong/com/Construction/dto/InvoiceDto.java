package culong.com.Construction.dto;

public class InvoiceDto {
	private long id;
	private String link;
	private long idConstruct;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public long getIdConstruct() {
		return idConstruct;
	}
	public void setIdConstruct(long idConstruct) {
		this.idConstruct = idConstruct;
	}

}
