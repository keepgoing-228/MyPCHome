package page;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

import org.json.JSONObject;

import app.App;
import myHTTP.Request;
import myHTTP.Response;

public class PersonalInfoPage extends ProfilePage implements ActionListener {

	private JTextField password = new JTextField(20);
	private JTextField email = new JTextField(20);
	private JTextField name = new JTextField(10);
	private JTextField id = new JTextField(20);
	private JButton changeButton = new JButton("修改");
	
	public PersonalInfoPage(Response response) {
		
		//加入元素，把元素預設值設為response中的值
		
		//加入changeButton
		
	}
	
	public void actionPerformed(ActionEvent e) {
		try {
			App.route(new Request(App.path.PERSONAL_INFO, Request.Method.POST, App.USER, this.getData()));
			Response response = App.route(new Request(App.path.PERSONAL_INFO, Request.Method.POST, App.USER, null));
			PersonalInfoPage page = new PersonalInfoPage(response);
			page.setVisible(true);
			this.setVisible(false);
			this.dispose();
		} catch (Exception error) {
			errorMessage.setText(error.getMessage());
		}
	}
	
	/**
	 * @return 密碼、email、名字、身分證的JSON物件
	 */
	private JSONObject getData() {
		return null;
	}

}
