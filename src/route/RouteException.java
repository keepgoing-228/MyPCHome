package route;

public class RouteException extends Exception {

	public static enum Type {PATH_NOT_FOUND, NOT_LOGIN, UNKOWN_METHOD}
	private Type exceptionType;
	
	public RouteException(Type type) {
		this.exceptionType = type;
	}
	
	public String getMessage() {
		switch (this.exceptionType) {
		case PATH_NOT_FOUND: return "Route Exception: Path Not Found";
		default: return null;
		}
	}
	
}
