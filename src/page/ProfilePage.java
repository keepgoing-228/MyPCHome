package page;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import app.App;
import myHTTP.Request;
import myHTTP.Response;

public class ProfilePage extends BasePage implements ActionListener {

	private JButton personalInfoButton = new JButton("個人資料");
	private JButton uploadedProductButton = new JButton("已上架商品");
	private JButton productUploadButton = new JButton("商品上架");
	private JButton cartButton = new JButton("購物車");
	
	public ProfilePage() {
		
		//在側邊加入personalInfo, uploadedProduct, productUpload, cart Button，actionListener this
		
	}
	
	public void actionPerformed(ActionEvent e) {

		switch (e.getActionCommand()) {
		case "個人資料": {
			try {
				Response response = App.route(new Request(App.path.PERSONAL_INFO, Request.Method.GET, App.USER, null));
				PersonalInfoPage page = new PersonalInfoPage(response);
				page.setVisible(true);
				this.setVisible(false);
				this.dispose();
			} catch (Exception error) {
				errorMessage.setText(error.getMessage());
			}
			break;
		}
		case "已上架商品": {
			try {
				Response response = App.route(new Request(App.path.UPLOADED_PRODUCT, Request.Method.GET, App.USER, null));
				UploadedProductPage page = new UploadedProductPage(response);
				page.setVisible(true);
				this.setVisible(false);
				this.dispose();
			} catch (Exception error) {
				errorMessage.setText(error.getMessage());
			}
			break;
		}
		case "商品上架": {
			try {
				Response response = App.route(new Request(App.path.Upload, Request.Method.GET, App.USER, null));
				UploadPage page = new UploadPage(response);
				page.setVisible(true);
				this.setVisible(false);
				this.dispose();
			} catch (Exception error) {
				errorMessage.setText(error.getMessage());
			}
			break;
		}
		case "購物車": {
			try {
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

}
