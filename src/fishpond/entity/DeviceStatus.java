package fishpond.entity;

public class DeviceStatus extends BaseEntity {

	private static final long serialVersionUID = -8541227944299250080L;
	
	private int deviceId;
	
	private boolean fan_A;
	private boolean fan_B;
	private boolean shock_A;
	private boolean shock_B;
	private boolean manual_stop;
	private boolean lack_materail;
	private boolean lack_phase;
	private boolean shock_drug_A;
	
	private boolean shock_drug_B;
	private boolean stir;
	private boolean pump_drug;
	private boolean load_materail_auger;
	private boolean valve_auger;
	private boolean discharge;
	private boolean air_compressor;
	
	public int getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(int deviceId) {
		this.deviceId = deviceId;
	}
	public boolean isFan_A() {
		return fan_A;
	}
	public void setFan_A(boolean fan_A) {
		this.fan_A = fan_A;
	}
	public boolean isFan_B() {
		return fan_B;
	}
	public void setFan_B(boolean fan_B) {
		this.fan_B = fan_B;
	}
	public boolean isShock_A() {
		return shock_A;
	}
	public void setShock_A(boolean shock_A) {
		this.shock_A = shock_A;
	}
	public boolean isShock_B() {
		return shock_B;
	}
	public void setShock_B(boolean shock_B) {
		this.shock_B = shock_B;
	}
	public boolean isManual_stop() {
		return manual_stop;
	}
	public void setManual_stop(boolean manual_stop) {
		this.manual_stop = manual_stop;
	}
	public boolean isLack_materail() {
		return lack_materail;
	}
	public void setLack_materail(boolean lack_materail) {
		this.lack_materail = lack_materail;
	}
	public boolean isLack_phase() {
		return lack_phase;
	}
	public void setLack_phase(boolean lack_phase) {
		this.lack_phase = lack_phase;
	}
	public boolean isShock_drug_A() {
		return shock_drug_A;
	}
	public void setShock_drug_A(boolean shock_drug_A) {
		this.shock_drug_A = shock_drug_A;
	}
	public boolean isShock_drug_B() {
		return shock_drug_B;
	}
	public void setShock_drug_B(boolean shock_drug_B) {
		this.shock_drug_B = shock_drug_B;
	}
	public boolean isStir() {
		return stir;
	}
	public void setStir(boolean stir) {
		this.stir = stir;
	}
	public boolean isPump_drug() {
		return pump_drug;
	}
	public void setPump_drug(boolean pump_drug) {
		this.pump_drug = pump_drug;
	}
	public boolean isLoad_materail_auger() {
		return load_materail_auger;
	}
	public void setLoad_materail_auger(boolean load_materail_auger) {
		this.load_materail_auger = load_materail_auger;
	}
	public boolean isValve_auger() {
		return valve_auger;
	}
	public void setValve_auger(boolean valve_auger) {
		this.valve_auger = valve_auger;
	}
	public boolean isDischarge() {
		return discharge;
	}
	public void setDischarge(boolean discharge) {
		this.discharge = discharge;
	}
	public boolean isAir_compressor() {
		return air_compressor;
	}
	public void setAir_compressor(boolean air_compressor) {
		this.air_compressor = air_compressor;
	}
}
