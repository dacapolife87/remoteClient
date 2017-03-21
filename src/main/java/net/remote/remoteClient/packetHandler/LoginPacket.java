package net.remote.remoteClient.packetHandler;

public class LoginPacket {
	String api;
	String userId;
	String userPw;
	
	public LoginPacket(String api, String userId, String userPw){
		this.api = api;
		this.userId = userId;
		this.userPw = userPw;
	}
	public String getApi() {
		return api;
	}
	public void setApi(String api) {
		this.api = api;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPw() {
		return userPw;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	public String toString(){
		return "[api="+api+",userId="+userId+",userPw="+userPw+"]";
	}
}
