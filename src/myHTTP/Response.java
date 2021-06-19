package myHTTP;

import org.json.JSONObject;

public class Response {

	private boolean state;
	private JSONObject data = null;
	
	public Response(boolean state) {
		this.setState(state);
	}
	
	public Response(boolean state, JSONObject data) {
		this.setState(state);
		this.setData(data);
	}
	
	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	public JSONObject getData() {
		return new JSONObject(data);
	}

	public void setData(JSONObject data) {
		this.data = new JSONObject(data);
	}


	
}
