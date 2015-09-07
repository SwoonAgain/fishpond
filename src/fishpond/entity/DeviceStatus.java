package fishpond.entity;

import java.util.Date;

public class DeviceStatus extends BaseEntity {

	private static final long serialVersionUID = -8541227944299250080L;
	
	private int deviceId;
	
	private int currentWeight;
	private int dissolvedOxygen;
	private int waterTemperature;
	private Date updateTime;
	private boolean fanA;
	private boolean fanB;
	private boolean shockA;
	private boolean shockB;
	private boolean manualStop;
	private boolean lackMaterail;
	private boolean lackPhase;
	private boolean shockDrugA;
	private boolean shockDrugB;
	private boolean stir;
	private boolean pumpDrug;
	private boolean loadMaterailAuger;
	private boolean valveAuger;
	private boolean discharge;
	private boolean airCompressor;
	public int getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(int deviceId) {
		this.deviceId = deviceId;
	}
	/**
	 * 当前重量
	 */
	public int getCurrentWeight() {
		return currentWeight;
	}
	public void setCurrentWeight(int currentWeight) {
		this.currentWeight = currentWeight;
	}
	/**
	 * 溶氧量
	 */
	public int getDissolvedOxygen() {
		return dissolvedOxygen;
	}
	public void setDissolvedOxygen(int dissolvedOxygen) {
		this.dissolvedOxygen = dissolvedOxygen;
	}
	/**
	 * 水温
	 */
	public int getWaterTemperature() {
		return waterTemperature;
	}
	public void setWaterTemperature(int waterTemperature) {
		this.waterTemperature = waterTemperature;
	}
	/**
	 * 更新时间
	 */
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	/**
	 * A风机
	 */
	public boolean isFanA() {
		return fanA;
	}
	public void setFanA(boolean fanA) {
		this.fanA = fanA;
	}
	/**
	 * B风机
	 */
	public boolean isFanB() {
		return fanB;
	}
	public void setFanB(boolean fanB) {
		this.fanB = fanB;
	}
	/**
	 * A振动
	 */
	public boolean isShockA() {
		return shockA;
	}
	public void setShockA(boolean shockA) {
		this.shockA = shockA;
	}
	/**
	 * B振动
	 */
	public boolean isShockB() {
		return shockB;
	}
	public void setShockB(boolean shockB) {
		this.shockB = shockB;
	}
	/**
	 * 手动停止
	 */
	public boolean isManualStop() {
		return manualStop;
	}
	public void setManualStop(boolean manualStop) {
		this.manualStop = manualStop;
	}
	/**
	 * 缺料
	 */
	public boolean isLackMaterail() {
		return lackMaterail;
	}
	public void setLackMaterail(boolean lackMaterail) {
		this.lackMaterail = lackMaterail;
	}
	/**
	 *缺相
	 */
	public boolean isLackPhase() {
		return lackPhase;
	}
	public void setLackPhase(boolean lackPhase) {
		this.lackPhase = lackPhase;
	}
	/**
	 * A药振
	 */
	public boolean isShockDrugA() {
		return shockDrugA;
	}
	public void setShockDrugA(boolean shockDrugA) {
		this.shockDrugA = shockDrugA;
	}
	/**
	 *B药振
	 */
	public boolean isShockDrugB() {
		return shockDrugB;
	}
	public void setShockDrugB(boolean shockDrugB) {
		this.shockDrugB = shockDrugB;
	}
	/**
	 * 搅拌
	 */
	public boolean isStir() {
		return stir;
	}
	public void setStir(boolean stir) {
		this.stir = stir;
	}
	/**
	 * 药泵
	 */
	public boolean isPumpDrug() {
		return pumpDrug;
	}
	public void setPumpDrug(boolean pumpDrug) {
		this.pumpDrug = pumpDrug;
	}
	/**
	 * 上料绞龙
	 */
	public boolean isLoadMaterailAuger() {
		return loadMaterailAuger;
	}
	public void setLoadMaterailAuger(boolean loadMaterailAuger) {
		this.loadMaterailAuger = loadMaterailAuger;
	}
	/**
	 * 绞阀
	 */
	public boolean isValveAuger() {
		return valveAuger;
	}
	public void setValveAuger(boolean valveAuger) {
		this.valveAuger = valveAuger;
	}
	/**
	 * 排料
	 */
	public boolean isDischarge() {
		return discharge;
	}
	public void setDischarge(boolean discharge) {
		this.discharge = discharge;
	}
	/**
	 *空压机
	 */
	public boolean isAirCompressor() {
		return airCompressor;
	}
	public void setAirCompressor(boolean airCompressor) {
		this.airCompressor = airCompressor;
	}
	
	
}
