package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import app.App;

public class BasePageListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {

		switch (e.getActionCommand()) {
		case "首頁": {
			try {
				System.out.println("HOME");
//				//拿到熱門商品資訊，建立首頁
//				Response response = App.route(new Request(App.path.HOME, Request.Method.GET, App.USER, null));
//				IndexPage page = new IndexPage(response);
//				page.setVisible(true);
//				this.setVisible(false);
//				this.dispose();
			} catch(Exception error) {
				App.location.setErrorMessage(error.getMessage());;
			}
			break;
		}
		case "商場":{
			try {
				System.out.println("SHOP");
//				//拿到熱門商品資訊，建立商品陳列頁
//				Response response = App.route(new Request(App.path.Shop, Request.Method.GET, App.USER, null));
//				ShopPage page = new ShopPage(response);
//				page.setVisible(true);
//				this.setVisible(false);
//				this.dispose();
			} catch(Exception error) {
				App.location.setErrorMessage(error.getMessage());;
			}
			break;
		}
		case "會員專區":{
			try {
				System.out.println("PROFILE");
//				Response response = App.route(new Request(App.path.PERSONAL_INFO, Request.Method.GET, App.USER, null));
//				PersonalInfoPage page = new PersonalInfoPage(response);
//				page.setVisible(true);
//				this.setVisible(false);
//				this.dispose();
			} catch(Exception error) {
				App.location.setErrorMessage(error.getMessage());;
			}
			break;
		}
		case "登入":{
			try {
				System.out.println("LOGIN");
//				//建立登入頁面
//				LoginPage page = new LoginPage();
//				page.setVisible(true);
//				this.setVisible(false);
//				this.dispose();
			} catch(Exception error) {
				App.location.setErrorMessage(error.getMessage());;
			}
			break;
		}
		case "登出":{
			try {
				System.out.println("LOGOUT");
//				//登出並回到首頁
//				App.route(new Request(App.path.LOGOUT, Request.Method.POST, App.USER, null));
//				Response response = App.route(new Request(App.path.HOME, Request.Method.GET, App.USER, null));
//				IndexPage page = new IndexPage(response);
//				page.setVisible(true);
//				this.setVisible(false);
//				this.dispose();
			} catch(Exception error) {
				App.location.setErrorMessage(error.getMessage());;
			}
			break;
		}
		case "註冊":{
			try {
				System.out.println("SIGNUP");
//				//建立註冊頁面
//				SignUpPage page = new SignUpPage();
//				page.setVisible(true);
//				this.setVisible(false);
//				this.dispose();
			} catch(Exception error) {
				App.location.setErrorMessage(error.getMessage());;
			}
			break;
		}
		}
	}

}
