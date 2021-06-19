package route;

import org.json.JSONObject;

import app.App;
import myHTTP.Request;
import myHTTP.Response;

public class ProductInfo extends Router{

	public ProductInfo(Request request) {
		super(request);
	}
	
	@Override
	public Response route() throws RouteException {
		// TODO Auto-generated method stub
		switch (this.getRequest().getMethod()) {
		case GET:{
			String query = "";
			JSONObject result = App.database.query(query, this.getRequest().getData());
			return new Response(true, result);
		}
		default: throw new RouteException(RouteException.Type.UNKOWN_METHOD);
		}
 	}

}
