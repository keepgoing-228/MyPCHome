package page;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTextField;

import org.json.JSONObject;

import app.App;
import myHTTP.Request;
import myHTTP.Response;

/**
 * @author huangzhangyu
 *上架商品的頁面
 */
public class UploadPage extends BasePage implements ActionListener{

	private JTextField name = new JTextField(10);
	private JComboBox<String> brand = new JComboBox<String>();
	private JComboBox<String> category = new JComboBox<String>();
	private JTextField number = new JTextField(10);
	private JTextField price = new JTextField(10);
	private JTextField discription = new JTextField(10);
	private JFileChooser picture = new JFileChooser();
	
	public UploadPage(Response response) {
			
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		try {
			App.route(new Request(App.path.UPLOAD, Request.Method.POST, App.USER, this.getData()));
			Response response = App.route(new Request(App.path.PRODUCT_INFO, Request.Method.GET, App.USER, this.getData()));
			ProductPage page = new ProductPage(response);
			page.setVisible(true);
			this.setVisible(false);
			this.dispose();
		} catch(Exception e2) {
			this.errorMessage.setText(e2.getMessage());
		}	
	}
	
	private JSONObject getData() {
		return null;
	}
		
}
