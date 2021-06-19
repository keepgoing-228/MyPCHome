package page;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import app.App;
import middlewares.Middlewares;
import myHTTP.Request;
import myHTTP.Response;

/**
 * @author huangzhangyu
 *各個頁面的基底
 */
public class BasePage extends JFrame implements ActionListener {

	JLabel errorMessage = new JLabel();
	private JButton homeButton = new JButton("首頁");
	private JButton shopButton = new JButton("商場");
	private JButton profileButton = new JButton("會員專區");
	private JButton loginButton = new JButton("登入");
	private JButton logoutButton = new JButton("登出");
	private JButton signUpButton = new JButton("註冊");
	
	public BasePage() {
		
		//設定長寬
		
		/*
		 * 製作headerPanel，裡面有：
		 * Home, Shop, Profile, Login/Logout, SignUp Button。如果已經登入就顯示logoutButton，還沒登入就顯示loginButton和signUpButton。Listener this
		 * PXHome, Account Label依照登入狀況顯示
		 * 設置成藍色
		 */
		
		//加入errorMessage
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {

		switch (e.getActionCommand()) {
		case "首頁": {
			try {
				//拿到熱門商品資訊，建立首頁
				Response response = App.route(new Request(App.path.HOME, Request.Method.GET, App.USER, null));
				IndexPage page = new IndexPage(response);
				page.setVisible(true);
				this.setVisible(false);
				this.dispose();
			} catch(Exception error) {
				errorMessage.setText(error.getMessage());
			}
			break;
		}
		case "商場":{
			try {
				//拿到熱門商品資訊，建立商品陳列頁
				Response response = App.route(new Request(App.path.Shop, Request.Method.GET, App.USER, null));
				ShopPage page = new ShopPage(response);
				page.setVisible(true);
				this.setVisible(false);
				this.dispose();
			} catch(Exception error) {
				errorMessage.setText(error.getMessage());
			}
			break;
		}
		case "會員專區":{
			try {
				Response response = App.route(new Request(App.path.PERSONAL_INFO, Request.Method.GET, App.USER, null));
				PersonalInfoPage page = new PersonalInfoPage(response);
				page.setVisible(true);
				this.setVisible(false);
				this.dispose();
			} catch(Exception error) {
				errorMessage.setText(error.getMessage());
			}
			break;
		}
		case "登入":{
			try {
				//建立登入頁面
				LoginPage page = new LoginPage();
				page.setVisible(true);
				this.setVisible(false);
				this.dispose();
			} catch(Exception error) {
				errorMessage.setText(error.getMessage());
			}
			break;
		}
		case "登出":{
			try {
				//登出並回到首頁
				App.route(new Request(App.path.LOGOUT, Request.Method.POST, App.USER, null));
				Response response = App.route(new Request(App.path.HOME, Request.Method.GET, App.USER, null));
				IndexPage page = new IndexPage(response);
				page.setVisible(true);
				this.setVisible(false);
				this.dispose();
			} catch(Exception error) {
				errorMessage.setText(error.getMessage());
			}
			break;
		}
		case "註冊":{
			try {
				//建立註冊頁面
				SignUpPage page = new SignUpPage();
				page.setVisible(true);
				this.setVisible(false);
				this.dispose();
			} catch(Exception error) {
				errorMessage.setText(error.getMessage());
			}
			break;
		}
		}
	}

}
