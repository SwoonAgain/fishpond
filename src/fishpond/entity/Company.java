package fishpond.entity;

public class Company extends BaseEntity{

	private static final long serialVersionUID = -7174770566164134484L;
	
	private String companyCode;
	private String companyName;
	
	public Company() {}
	public Company(String companyCode, String companyName) {
		this.companyCode = companyCode;
		this.companyName = companyName;
	}
	public String getCompanyCode() {
		return companyCode;
	}
	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	@Override
	public String toString() {
		return "Company [companyCode=" + companyCode
				+ ", companyName=" + companyName + "]";
	}
}
