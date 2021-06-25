import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import app.App;
import myHTTP.Response;

public class UploadPage extends ProfilePage implements ActionListener{

	private JTextField name = new JTextField(10);
	private JComboBox<String> brand = new JComboBox<String>();
	private JComboBox<String> category = new JComboBox<String>();
	private JTextField number = new JTextField(10);
	private JTextField price = new JTextField(10);
	private JTextField discription = new JTextField(10);
	private JFileChooser picture = new JFileChooser();
	
	UploadPage() {
		// Panel
		JPanel rightPanel = new JPanel();
		rightPanel.setLayout(new GridBagLayout());
		rightPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		JPanel productPanel = new JPanel();
		productPanel.setLayout(new GridBagLayout());
		productPanel.setBorder(BorderFactory.createEtchedBorder());
		
		//label
		JLabel nameLabel = new JLabel("商品名稱");
		GridBagConstraints gridBag = new GridBagConstraints();
		gridBag.fill = GridBagConstraints.BOTH;
		gridBag.insets = new Insets(5,20,5,10);
		gridBag.gridx = 0;
		gridBag.gridy = 0;
		productPanel.add(nameLabel, gridBag);
				
		JLabel brandLabel = new JLabel("品牌");
		gridBag.gridy = 1;
		productPanel.add(brandLabel, gridBag);
		
		JLabel categoryLabel = new JLabel("類別");
		gridBag.gridy = 2;
		productPanel.add(categoryLabel, gridBag);
		
		JLabel numberLabel = new JLabel("存貨數量");
		gridBag.gridy = 3;
		productPanel.add(numberLabel, gridBag);
		
		JLabel priceLabel = new JLabel("價錢");
		gridBag.gridy = 4;
		productPanel.add(priceLabel, gridBag);
		
		JLabel discriptionLabel = new JLabel("敘述");
		gridBag.gridy = 5;
		productPanel.add(discriptionLabel, gridBag);
		
		JLabel pictureLabel = new JLabel("圖片");
		gridBag.gridy = 6;
		productPanel.add(pictureLabel, gridBag);
		
			
		//text field
		gridBag.insets = new Insets(5,20,5,10);
		gridBag.gridx = 1;
		gridBag.gridy = 0;
		productPanel.add(name, gridBag);
		
		gridBag.gridy = 1;
		productPanel.add(brand, gridBag);
		
		gridBag.gridy = 2;
		productPanel.add(category, gridBag);
		
		gridBag.gridy = 3;
		productPanel.add(number, gridBag);
		
		gridBag.gridy = 4;
		productPanel.add(price, gridBag);
		
		gridBag.gridy = 5;
		productPanel.add(discription, gridBag);
		
		gridBag.gridy = 6;
		productPanel.add(picture, gridBag);
		
		//button
		JButton uploadButton = new JButton("上架");
		uploadButton.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		gridBag.ipadx = 30;
		gridBag.ipady = 20;
		gridBag.gridx = 1;
		gridBag.gridy = 7;
		gridBag.insets = new Insets(15,300,10,300);
		productPanel.add(uploadButton, gridBag);
		
		
		
		
		// package
		GridBagConstraints Grid = new GridBagConstraints();
		Grid.fill = GridBagConstraints.BOTH;
//		Grid.insets = new Insets(0,0,0,0);
		Grid.gridx = 0;
		Grid.gridy = 0;
		rightPanel.add(productPanel, Grid);
		this.add(rightPanel, BorderLayout.CENTER);
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
