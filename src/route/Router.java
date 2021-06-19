package route;

import myHTTP.Request;
import myHTTP.Response;

public abstract class Router {

	private Request request;
	
	public Router(Request request) {
		this.setRequest(request);
	}

	public Request getRequest() {
		return new Request(request);
	}

	public void setRequest(Request request) {
		this.request = new Request(request);
	}
	
	
	/**
	 * 對應request中的method執行相對應的功能
	 */
	public abstract Response route() throws RouteException;
	

	
}
