package poi;

public class Vo {
	private String callId;
	private String bindId;
	public Vo(String callId, String bindId, String callNo, String peerNo, String telX, String callTime,
			String startTime, String finishTime, String callDuration, String finishType, String finishState) {
		super();
		this.callId = callId;
		this.bindId = bindId;
		this.callNo = callNo;
		this.peerNo = peerNo;
		this.telX = telX;
		this.callTime = callTime;
		this.startTime = startTime;
		this.finishTime = finishTime;
		this.callDuration = callDuration;
		this.finishType = finishType;
		this.finishState = finishState;
	}
	private String callNo;
	public String getCallId() {
		return callId;
	}
	public void setCallId(String callId) {
		this.callId = callId;
	}
	public String getBindId() {
		return bindId;
	}
	public void setBindId(String bindId) {
		this.bindId = bindId;
	}
	public String getCallNo() {
		return callNo;
	}
	public void setCallNo(String callNo) {
		this.callNo = callNo;
	}
	public String getPeerNo() {
		return peerNo;
	}
	public void setPeerNo(String peerNo) {
		this.peerNo = peerNo;
	}
	public String getTelX() {
		return telX;
	}
	public void setTelX(String telX) {
		this.telX = telX;
	}
	public String getCallTime() {
		return callTime;
	}
	public void setCallTime(String callTime) {
		this.callTime = callTime;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getFinishTime() {
		return finishTime;
	}
	public void setFinishTime(String finishTime) {
		this.finishTime = finishTime;
	}
	public String getCallDuration() {
		return callDuration;
	}
	public void setCallDuration(String callDuration) {
		this.callDuration = callDuration;
	}
	public String getFinishType() {
		return finishType;
	}
	public void setFinishType(String finishType) {
		this.finishType = finishType;
	}
	public String getFinishState() {
		return finishState;
	}
	public void setFinishState(String finishState) {
		this.finishState = finishState;
	}
	private String peerNo;
	private String telX;
	private String callTime;
	private String startTime;
	private String finishTime;
	private String callDuration;
	private String finishType;
	private String finishState;
}
