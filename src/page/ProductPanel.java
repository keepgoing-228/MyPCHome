package page;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import org.json.JSONObject;

import app.App;
import myHTTP.Request;
import myHTTP.Response;

public class ProductPanel extends JPanel implements ActionListener{

	/**
	 * 根據data做出一個商品框框，點商品名稱可以進入商品頁面
	 * @param data 商品資訊，包含名稱、價錢、圖片
	 */
	public ProductPanel(JSONObject data) {
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			//建立新的商品頁面
			Response response = App.route(new Request(App.path.PRODUCT_INFO, Request.Method.GET, App.USER, null));
			ProductPage page = new ProductPage(response);
			page.setVisible(true);
		} catch(Exception error) {
			//Do nothing
		}
		
	}
	
}
