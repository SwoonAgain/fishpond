package fishpond.entity;

public class Command {
	
	private int _id;
	
	private String parameterName;
	
	private String rdSend;
	private int rdSendLength;
	private String rdReceive;
	private int rdReceiveLength;
	
	private String mdfySend;
	private int mdfySendLength;
	private String mdfyReceive;
	private int mdfyReceiveLength;
	
	public int get_id() {
		return _id;
	}
	public void set_id(int _id) {
		this._id = _id;
	}
	public String getParameterName() {
		return parameterName;
	}
	public void setParameterName(String parameterName) {
		this.parameterName = parameterName;
	}
	public String getRdSend() {
		return rdSend;
	}
	public void setRdSend(String rdSend) {
		this.rdSend = rdSend;
	}
	public int getRdSendLength() {
		return rdSendLength;
	}
	public void setRdSendLength(int rdSendLength) {
		this.rdSendLength = rdSendLength;
	}
	public String getRdReceive() {
		return rdReceive;
	}
	public void setRdReceive(String rdReceive) {
		this.rdReceive = rdReceive;
	}
	public int getRdReceiveLength() {
		return rdReceiveLength;
	}
	public void setRdReceiveLength(int rdReceiveLength) {
		this.rdReceiveLength = rdReceiveLength;
	}
	public String getMdfySend() {
		return mdfySend;
	}
	public void setMdfySend(String mdfySend) {
		this.mdfySend = mdfySend;
	}
	public int getMdfySendLength() {
		return mdfySendLength;
	}
	public void setMdfySendLength(int mdfySendLength) {
		this.mdfySendLength = mdfySendLength;
	}
	public String getMdfyReceive() {
		return mdfyReceive;
	}
	public void setMdfyReceive(String mdfyReceive) {
		this.mdfyReceive = mdfyReceive;
	}
	public int getMdfyReceiveLength() {
		return mdfyReceiveLength;
	}
	public void setMdfyReceiveLength(int mdfyReceiveLength) {
		this.mdfyReceiveLength = mdfyReceiveLength;
	}
	@Override
	public String toString() {
		return "Command [_id=" + _id + ", parameterName=" + parameterName
				+ ", rdSend=" + rdSend + ", rdSendLength=" + rdSendLength
				+ ", rdReceive=" + rdReceive + ", rdReceiveLength="
				+ rdReceiveLength + ", mdfySend=" + mdfySend
				+ ", mdfySendLength=" + mdfySendLength + ", mdfyReceive="
				+ mdfyReceive + ", mdfyReceiveLength=" + mdfyReceiveLength
				+ "]";
	}
}
