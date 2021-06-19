package app;
import database.Database;
import myHTTP.Request;
import myHTTP.Response;
import route.ProductInfo;
import route.RouteException;
import route.Router;
import route.Upload;

public class App {

	public static enum path{UPLOAD, PRODUCT_INFO, HOME, Shop, LOGOUT, CART, SHOP, LOGIN, PERSONAL_INFO, UPLOADED_PRODUCT, OFF_SHELF, Upload, CHECKOUT};
	public static Database database;
	public static String USER = null;
	
	public static void main(String[] args) {
		
		database = new Database("Timecompressor1919810");

	}
	
	/**
	 * 判斷要把request交給哪個router處理並執行
	 * @param 從不同頁面接收到的request
	 * @throws RouteException 
	 */
	public static Response route(Request request) throws RouteException {
		
		Router router;
		Response response;
		//判斷path的內容，呼叫對應的router
		switch(request.getPath()) {
		case UPLOAD:{
			router = new Upload(request);
			response = router.route();
			break;
		}
		case PRODUCT_INFO:{
			router = new ProductInfo(request);
			response = router.route();
			break;
		}
		default:{
			throw new RouteException(RouteException.Type.PATH_NOT_FOUND);
		}
		}
		
		return response;
		
	}

}
