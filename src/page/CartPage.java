package page;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.json.JSONObject;

import app.App;
import myHTTP.Request;
import myHTTP.Response;

public class CartPage extends ProfilePage implements ActionListener {

	private ButtonGroup buttonGroup = new ButtonGroup();
	private JButton checkout = new JButton("結帳");
	private CheckoutPage page;
	
	public CartPage(Response response) {

		//把購物車中商品的productBarPanel塞進productBarDisplayPanel，每個Bar前面要有一個CheckBox
		JPanel productBarDisplayPanel = new JPanel();
		ProductBarPanel product = new ProductBarPanel(null);
		
		//加入總金額label
		JLabel totalPrice = new JLabel(String.format("$%.2f", this.countTotalPrice()));
		
		//加入結帳，actionListener this		
	}

	/**
	 * 根據check box的選擇計算總金額
	 * @return 總金額
	 */
	private float countTotalPrice() {
		return 100;
	}

	public void actionPerformed(ActionEvent e) {

		switch(e.getActionCommand()) {
		case "結帳":{
			try {
				page = new CheckoutPage(this.countTotalPrice(), this);
			} catch (Exception error) {
				errorMessage.setText(error.getMessage());
			}
			break;
		}
		case "確認":{
			try {
				App.route(new Request(App.path.CHECKOUT, Request.Method.POST, App.USER, this.getData()));
				Response response = App.route(new Request(App.path.CART, Request.Method.POST, App.USER, null));
				CartPage page = new CartPage(response);
				page.setVisible(true);
				this.setVisible(false);
				this.dispose();
			} catch (Exception error) {
				errorMessage.setText(error.getMessage());
			}
			break;
		}
		}
		
	}
	
	private JSONObject getData() {
		this.page.getData();
		return null;
	}
	
}
