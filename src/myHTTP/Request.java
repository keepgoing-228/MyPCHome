package myHTTP;

import org.json.JSONObject;

import app.App;

public class Request {

	public static enum Method{GET, POST}
	
	private App.path path;
	private Method method;
	private String user = null;
	private JSONObject data = null;

	public Request() {
		
	}
	
	public Request(App.path path, Method method, String user, JSONObject data) {
		this.setPath(path);
		this.setMethod(method);
		this.setUser(user);
		this.setData(data);
	}
	
	public Request(Request request) {
		this.setPath(request.getPath());
		this.setMethod(request.method);
		this.setUser(request.getUser());
		this.setData(request.getData());
	}
	
	public App.path getPath() {
		return path;
	}
	public void setPath(App.path path) {
		this.path = path;
	}
	public Method getMethod() {
		return method;
	}
	public void setMethod(Method method) {
		this.method = method;
	}
	public JSONObject getData() {
		return new JSONObject(data);
	}
	public void setData(JSONObject data) {
		this.data = new JSONObject(data);
	}
	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}
	
	public boolean isLogIn() {
		if (this.user != null) {
			return true;
		} else {
			return false;
		}
	}
}
