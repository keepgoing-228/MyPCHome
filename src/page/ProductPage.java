package page;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import org.json.JSONObject;

import app.App;
import myHTTP.Request;
import myHTTP.Response;

public class ProductPage extends BasePage implements ActionListener{

	private JButton addToCart = new JButton("加入購物車");
	
	public ProductPage(Response response) {
		
		//加入圖片
		
		//加入infoPanel，addToCart用actionListener this
		
		//加入discriptionPanel
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		try {
			App.route(new Request(App.path.CART, Request.Method.POST, App.USER, null));  //新增到購物車
			SuccessPage page = new SuccessPage();  //跳出加入成功頁面
			page.setVisible(true);
		} catch(Exception error) {
			this.errorMessage.setText(error.getMessage());
		}
	}

}
