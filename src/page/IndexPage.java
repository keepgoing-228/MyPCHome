package page;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;

import app.App;
import myHTTP.Request;
import myHTTP.Response;

/**
 * @author huangzhangyu
 *商場首頁
 */
public class IndexPage extends BasePage implements ActionListener {

	private SearchPanel searchPanel;
	private Font title = new Font("Dialog", Font.BOLD, 20);
	private MatteBorder border = BorderFactory.createMatteBorder(0, 0, 3, 0, Color.black);
	
	public IndexPage(Response response) {
		
		super();
		
		
		//把所有新建的物件都放入這個panel
		JPanel displayPanel = new JPanel();
		displayPanel.setLayout(new GridBagLayout());
		GridBagConstraints gridBag = new GridBagConstraints();
		gridBag.gridx = 0;
		gridBag.gridy = 0;
		gridBag.anchor = GridBagConstraints.WEST;
		gridBag.insets = new Insets(10, 0, 0, 0);
		
		//建立searchPanel放入display
		JPanel searchDisplayPanel = new JPanel();
		searchDisplayPanel.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		c.anchor = GridBagConstraints.WEST;
		c.fill = GridBagConstraints.BOTH;
		JLabel searchLabel = new JLabel("搜尋本站");
		searchLabel.setFont(title);
		searchLabel.setBorder(border);
		searchDisplayPanel.add(searchLabel, c);
		searchPanel = new SearchPanel();
		c.gridy++;
		searchDisplayPanel.add(searchPanel, c);
		displayPanel.add(searchDisplayPanel, gridBag);
		
		//加入popularProductDisplayPanel
		JPanel popularProductDisplayPanel = new JPanel();
		popularProductDisplayPanel.setLayout(new GridBagLayout());
		c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		c.anchor = GridBagConstraints.WEST;
		c.fill = GridBagConstraints.BOTH;
		JLabel hot = new JLabel("熱銷商品");
		hot.setFont(title);
		hot.setBorder(border);
		popularProductDisplayPanel.add(hot, c);
		ProductDisplayPanel productDisplayPanel = new ProductDisplayPanel();
		productDisplayPanel.addProduct(new ProductPanel(null));
		productDisplayPanel.addProduct(new ProductPanel(null));
		productDisplayPanel.addProduct(new ProductPanel(null));
		productDisplayPanel.addProduct(new ProductPanel(null));
		productDisplayPanel.addProduct(new ProductPanel(null));
		c.gridy++;
		popularProductDisplayPanel.add(productDisplayPanel, c);
		gridBag.gridy++;
		gridBag.ipady = 10;
		displayPanel.add(popularProductDisplayPanel, gridBag);
		
		this.add(displayPanel);
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
