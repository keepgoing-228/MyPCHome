package route;

import org.json.JSONObject;

import app.App;
import myHTTP.Request;
import myHTTP.Response;

public class Upload extends Router {

	public Upload(Request request) {
		super(request);
	}

	@Override
	public Response route() throws RouteException {
		// TODO Auto-generated method stub
		switch (this.getRequest().getMethod()) {
		case POST:{
			String query = "";
			JSONObject result = App.database.query(query, this.getRequest().getData());
			return new Response(true, result);
		}
		case GET:{
			if (this.getRequest().isLogIn()) {
				return new Response(true);
			} else {
				throw new RouteException(RouteException.Type.NOT_LOGIN);
			}
		}
		default:{
			throw new RouteException(RouteException.Type.UNKOWN_METHOD);
		}
		}
	}
	
}
