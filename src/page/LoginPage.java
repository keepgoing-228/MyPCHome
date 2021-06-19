package page;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

import org.json.JSONObject;

import app.App;
import myHTTP.Request;
import myHTTP.Response;

public class LoginPage extends BasePage implements ActionListener {

	JTextField account = new JTextField(20);
	JTextField password = new JTextField(20);
	JButton loginButton = new JButton("登入");
	
	public LoginPage() {
		
		//加入元素
		
	}
	
	public void actionPerformed(ActionEvent e) {
		try {
			App.route(new Request(App.path.LOGIN, Request.Method.GET, App.USER, this.getData()));
			Response response = App.route(new Request(App.path.HOME, Request.Method.GET, App.USER, null));
			IndexPage page = new IndexPage(response);
			page.setVisible(true);
			this.setVisible(false);
			this.dispose();
		} catch(Exception error) {
			this.errorMessage.setText(error.getMessage());
		}
	}
	
	/**
	 * @return 使用者輸入的帳號密碼
	 */
	private JSONObject getData() {
		return null;
	}
}
