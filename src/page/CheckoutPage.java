package page;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import org.json.JSONObject;

public class CheckoutPage extends JFrame{

	private JTextField card = new JTextField(10);
	private JTextField address = new JTextField(10);
	private JButton ok = new JButton("確認");
	
	public CheckoutPage(float price, ProfilePage page) {
		
		//加入元素
		
		//加入ok，actionListener ProfilePage page
		
	}
	
	public JSONObject getData() {
		return null;
	}
	


}
