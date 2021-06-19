package page;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import app.App;
import myHTTP.Request;
import myHTTP.Response;

public class IndexPage extends BasePage implements ActionListener {

	private SearchPanel searchPanel;
	
	public IndexPage(Response response) {
		
		//把所有新建的物件都放入這個panel
		JPanel displayPanel = new JPanel();
		
		//建立searchPanel放入display
		searchPanel = new SearchPanel(this);
		
		//加入popularProductDisplayPanel
		JPanel popularProductDisplayPanel = new JPanel();
		ProductDisplayPanel productDisplayPanel = new ProductDisplayPanel();
	}
	
	public void actionPerformed(ActionEvent e) {
		
		try {
			Response response = App.route(new Request(App.path.SHOP, Request.Method.GET, App.USER, searchPanel.getData()));
			ShopPage page = new ShopPage(response);
			page.setVisible(true);
			this.setVisible(false);
			this.dispose();
		} catch(Exception error) {
			this.errorMessage.setText(error.getMessage());
		}
		
	}

}
