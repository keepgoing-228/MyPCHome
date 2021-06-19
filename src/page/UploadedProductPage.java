package page;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;

import org.json.JSONObject;

import app.App;
import myHTTP.Request;
import myHTTP.Response;

public class UploadedProductPage extends ProfilePage implements ActionListener {

	JButton offShelfButton = new JButton("下架商品");
	ButtonGroup buttonGroup = new ButtonGroup();
	
	public UploadedProductPage(Response response) {
		
		//把已上架商品的productBarPanel塞進productBarDisplayPanel，每個Bar前面要有一個CheckBox
		JPanel productBarDisplayPanel = new JPanel();
		ProductBarPanel product = new ProductBarPanel(null);
		
		//加入offShelfButton，actionListener this
	}
	
	public void actionPerformed(ActionEvent e) {

		try {
			App.route(new Request(App.path.OFF_SHELF, Request.Method.POST, App.USER, this.getData()));
			Response response = App.route(new Request(App.path.UPLOADED_PRODUCT, Request.Method.GET, App.USER, null));
			UploadedProductPage page = new UploadedProductPage(response);
			page.setVisible(true);
			this.setVisible(false);
			this.dispose();
		} catch (Exception error) {
			errorMessage.setText(error.getMessage());
		}
		
	}

	/**
	 * @return 被選擇的商品的資訊
	 */
	private JSONObject getData() {
		return null;
	}
	
}
