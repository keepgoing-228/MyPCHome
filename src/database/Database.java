package database;

import org.json.JSONObject;

public class Database {

	public Database(String password) {
		this.connect(password);
	}
	
	public void connect(String password) {}

	/**
	 * 執行一個sql，並回傳結果
	 * @param sql 要執行的指令
	 * @param data 要塞進sql的內容
	 * @return JSON格式的結果，如果查詢結果為空或指令為修改資料則回傳null
	 */
	public JSONObject query(String sql, JSONObject data) {
		
		JSONObject result = null;
		return result;
		
	}
}
