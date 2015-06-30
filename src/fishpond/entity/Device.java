package fishpond.entity;

public class Device extends BaseEntity{

	private static final long serialVersionUID = -383966021574954491L;
	private int _id;
	private String dtuCode;
	private String companyCode;
	private String fishPondCode;
	private String fishPondNo;
	private String platformId;
	private boolean onlineStatus;
	
	public Device() {}

	public Device(String dtuCode, String companyCode, String fishPondCode, String fishPondNo,
			String platformId) {
		super();
		this.dtuCode = dtuCode;
		this.companyCode = companyCode;
		this.fishPondCode = fishPondCode;
		this.fishPondNo = fishPondNo;
		this.platformId = platformId;
	}
	
	@Override
	public String toString() {
		return "Device [_id=" + _id + ", dtuCode=" + dtuCode + ", companyCode="
				+ companyCode + ", fishPondCode=" + fishPondCode
				+ ", fishPondNo=" + fishPondNo + ", platformId=" + platformId
				+ "]";
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

	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyName) {
		this.companyCode = companyName;
	}

	public String getFishPondCode() {
		return fishPondCode;
	}

	public void setFishPondCode(String fishPondName) {
		this.fishPondCode = fishPondName;
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

	public boolean isOnlineStatus() {
		return onlineStatus;
	}

	public void setOnlineStatus(boolean onlineStatus) {
		this.onlineStatus = onlineStatus;
	}

	/**
	 * 重写过的hashcode,
	 * <br/>onlineStatus不在equals条件里面.
	 * @see #equals(Object)
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + _id;
		result = prime * result
				+ ((dtuCode == null) ? 0 : dtuCode.hashCode());
		result = prime * result
				+ ((companyCode == null) ? 0 : companyCode.hashCode());
		result = prime * result + ((dtuCode == null) ? 0 : dtuCode.hashCode());
		result = prime * result
				+ ((fishPondCode == null) ? 0 : fishPondCode.hashCode());
		result = prime * result
				+ ((fishPondNo == null) ? 0 : fishPondNo.hashCode());
		result = prime * result
				+ ((platformId == null) ? 0 : platformId.hashCode());
		return result;
	}

	/**
	 * onlineStatus不在equals条件里面
	 * @see #hashCode()
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Device other = (Device) obj;
		if (dtuCode == null) {
			if (other.dtuCode != null)
				return false;
		} else if (!dtuCode.equals(other.dtuCode))
			return false;
		if (companyCode == null) {
			if (other.companyCode != null)
				return false;
		} else if (!companyCode.equals(other.companyCode))
			return false;
		if (fishPondCode == null) {
			if (other.fishPondCode != null)
				return false;
		} else if (!fishPondCode.equals(other.fishPondCode))
			return false;
		if (fishPondNo == null) {
			if (other.fishPondNo != null)
				return false;
		} else if (!fishPondNo.equals(other.fishPondNo))
			return false;
		if (platformId == null) {
			if (other.platformId != null)
				return false;
		} else if (!platformId.equals(other.platformId))
			return false;
		return true;
	}

}
