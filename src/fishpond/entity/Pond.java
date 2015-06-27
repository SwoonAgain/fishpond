package fishpond.entity;

public class Pond extends BaseEntity{

	private static final long serialVersionUID = 4023173761491570797L;
	private String pondCode;
	private String pondName;
	
	public Pond() {}
	public Pond(String pondCode, String pondName) {
		this.pondCode = pondCode;
		this.pondName = pondName;
	}
	public String getPondCode() {
		return pondCode;
	}
	public void setPondCode(String pondCode) {
		this.pondCode = pondCode;
	}
	public String getPondName() {
		return pondName;
	}
	public void setPondName(String pondName) {
		this.pondName = pondName;
	}
	
}
