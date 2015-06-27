package fishpond.entity;

public class DeviceEditParameter extends BaseEntity{

	private static final long serialVersionUID = -2554427724523452760L;

	private int deviceId;
	
	private String throwingTime;
	private String intervalTime;
	private String manualFeedWeight;
	
	private String firstMealQuantity;
	private String firstMealOpenTime;
	private String firstMealCloseTime;
	
	private String secondMealQuantity;
	private String secondMealOpenTime;
	private String secondMealCloseTime;
	
	private String thirdMealQuantity;
	private String thirdMealOpenTime;
	private String thirdMealCloseTime;
	
	private String fourthMealQuantity;
	private String fourthMealOpenTime;
	private String fourthMealCloseTime;
	
	/**
	 * @return 设备id
	 */
	public int getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(int deviceId) {
		this.deviceId = deviceId;
	}
	/**
	 * @return 抛料时间
	 */
	public String getThrowingTime() {
		return throwingTime;
	}
	public void setThrowingTime(String throwingTime) {
		this.throwingTime = throwingTime;
	}
	/**
	 * @return 间隔时间
	 */
	public String getIntervalTime() {
		return intervalTime;
	}
	public void setIntervalTime(String intervalTime) {
		this.intervalTime = intervalTime;
	}
	/**
	 * @return 手动唯料重量
	 */
	public String getManualFeedWeight() {
		return manualFeedWeight;
	}
	public void setManualFeedWeight(String manualFeedWeight) {
		this.manualFeedWeight = manualFeedWeight;
	}
	/**
	 * @return 第一餐目标量
	 */
	public String getFirstMealQuantity() {
		return firstMealQuantity;
	}
	public void setFirstMealQuantity(String firstMealQuantity) {
		this.firstMealQuantity = firstMealQuantity;
	}
	/**
	 * @return 第一餐开时间
	 */
	public String getFirstMealOpenTime() {
		return firstMealOpenTime;
	}
	public void setFirstMealOpenTime(String firstMealOpenTime) {
		this.firstMealOpenTime = firstMealOpenTime;
	}
	/**
	 * @return 第一餐关时间
	 */
	public String getFirstMealCloseTime() {
		return firstMealCloseTime;
	}
	public void setFirstMealCloseTime(String firstMealCloseTime) {
		this.firstMealCloseTime = firstMealCloseTime;
	}
	/**
	 * @return 第二餐目标量
	 */
	public String getSecondMealQuantity() {
		return secondMealQuantity;
	}
	public void setSecondMealQuantity(String secondMealQuantity) {
		this.secondMealQuantity = secondMealQuantity;
	}
	/**
	 * @return 第二餐开时间
	 */
	public String getSecondMealOpenTime() {
		return secondMealOpenTime;
	}
	public void setSecondMealOpenTime(String secondMealOpenTime) {
		this.secondMealOpenTime = secondMealOpenTime;
	}
	/**
	 * @return 第二餐关时间
	 */
	public String getSecondMealCloseTime() {
		return secondMealCloseTime;
	}
	public void setSecondMealCloseTime(String secondMealCloseTime) {
		this.secondMealCloseTime = secondMealCloseTime;
	}
	/**
	 * @return 第三餐目标量
	 */
	public String getThirdMealQuantity() {
		return thirdMealQuantity;
	}
	public void setThirdMealQuantity(String thirdMealQuantity) {
		this.thirdMealQuantity = thirdMealQuantity;
	}
	/**
	 * @return 第三餐开时间
	 */
	public String getThirdMealOpenTime() {
		return thirdMealOpenTime;
	}
	public void setThirdMealOpenTime(String thirdMealOpenTime) {
		this.thirdMealOpenTime = thirdMealOpenTime;
	}
	/**
	 * @return 第三餐关时间
	 */
	public String getThirdMealCloseTime() {
		return thirdMealCloseTime;
	}
	public void setThirdMealCloseTime(String thirdMealCloseTime) {
		this.thirdMealCloseTime = thirdMealCloseTime;
	}
	/**
	 * @return 第四餐目标量
	 */
	public String getFourthMealQuantity() {
		return fourthMealQuantity;
	}
	public void setFourthMealQuantity(String fourthMealQuantity) {
		this.fourthMealQuantity = fourthMealQuantity;
	}
	/**
	 * @return 第四餐开时间
	 */
	public String getFourthMealOpenTime() {
		return fourthMealOpenTime;
	}
	public void setFourthMealOpenTime(String fourthMealOpenTime) {
		this.fourthMealOpenTime = fourthMealOpenTime;
	}
	/**
	 * @return 第四餐关时间
	 */
	public String getFourthMealCloseTime() {
		return fourthMealCloseTime;
	}
	public void setFourthMealCloseTime(String fourthMealCloseTime) {
		this.fourthMealCloseTime = fourthMealCloseTime;
	}
	@Override
	public String toString() {
		return "DeviceEditParameter [deviceId=" + deviceId + ", throwingTime="
				+ throwingTime + ", intervalTime=" + intervalTime
				+ ", manualFeedWeight=" + manualFeedWeight
				+ ", firstMealQuantity=" + firstMealQuantity
				+ ", firstMealOpenTime=" + firstMealOpenTime
				+ ", firstMealCloseTime=" + firstMealCloseTime
				+ ", secondMealQuantity=" + secondMealQuantity
				+ ", secondMealOpenTime=" + secondMealOpenTime
				+ ", secondMealCloseTime=" + secondMealCloseTime
				+ ", thirdMealQuantity=" + thirdMealQuantity
				+ ", thirdMealOpenTime=" + thirdMealOpenTime
				+ ", thirdMealCloseTime=" + thirdMealCloseTime
				+ ", fourthMealQuantity=" + fourthMealQuantity
				+ ", fourthMealOpenTime=" + fourthMealOpenTime
				+ ", fourthMealCloseTime=" + fourthMealCloseTime + "]";
	}
}
