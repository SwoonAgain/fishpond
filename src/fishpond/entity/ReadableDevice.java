package fishpond.entity;

public class ReadableDevice extends BaseEntity{

	private static final long serialVersionUID = 478075141573707898L;
	private int _id;
	private String dtuCode;
	private String companyName;
	private String fishPondName;
	private String fishPondNo;
	private String platformId;
	private boolean onlineStatus;
	
	public ReadableDevice() {}
	
	public ReadableDevice(int _id, String dtuCode, String companyName, String fishPondName,
			String fishPondNo, String platformId, boolean onlineStatus) {
		super();
		this._id = _id;
		this.dtuCode = dtuCode;
		this.companyName = companyName;
		this.fishPondName = fishPondName;
		this.fishPondNo = fishPondNo;
		this.platformId = platformId;
		this.onlineStatus = onlineStatus;
	}

	public int get_id() {
		return _id;
	}

	public void set_id(int _id) {
		this._id = _id;
	}
	
	public String getDtuCode() {
		return dtuCode;
	}

	public void setDtuCode(String dtuCode) {
		this.dtuCode = dtuCode;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getFishPondName() {
		return fishPondName;
	}

	public void setFishPondName(String fishPondName) {
		this.fishPondName = fishPondName;
	}

	public String getFishPondNo() {
		return fishPondNo;
	}

	public void setFishPondNo(String fishPondNo) {
		this.fishPondNo = fishPondNo;
	}

	public String getPlatformId() {
		return platformId;
	}

	public void setPlatformId(String platformId) {
		this.platformId = platformId;
	}

	public boolean getOnlineStatus() {
		return onlineStatus;
	}

	public void setOnlineStatus(boolean onlineStatus) {
		this.onlineStatus = onlineStatus;
	}
}
