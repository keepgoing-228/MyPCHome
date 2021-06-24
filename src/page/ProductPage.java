package page;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import org.json.JSONObject;

import app.App;
import myHTTP.Request;
import myHTTP.Response;

public class ProductPage extends BasePage implements ActionListener{

	private JButton addToCart = new JButton("加入購物車");
	private JComboBox <Integer> count = new JComboBox<Integer>();
	
	public ProductPage(Response response) {
		
		JPanel displayPanel = new JPanel();
		displayPanel.setLayout(new GridBagLayout());
		GridBagConstraints gridBag = new GridBagConstraints();
		gridBag.gridx = 0;
		gridBag.gridy = 0;
		gridBag.insets = new Insets(0, 0, 30, 30);
		gridBag.anchor = GridBagConstraints.WEST;
		
		//加入圖片
		JLabel picture = new JLabel(this.getTransformedIcon("static/" + "12345.jpeg"));
		picture.setBorder(BorderFactory.createLineBorder(Color.black));
		displayPanel.add(picture, gridBag);
		
		//加入infoPanel，addToCart用actionListener this
		JPanel infoPanel = new JPanel();
		infoPanel.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(0, 0, 10, 10);
		c.anchor = GridBagConstraints.SOUTH;
		c.fill = GridBagConstraints.BOTH;
		
		c.gridx = 0;
		c.gridy = 0;
		JLabel name = new JLabel("腳踏車");
		name.setFont(new Font("Dialog", Font.BOLD, 20));
		infoPanel.add(name, c);
		
		c.gridy = 1;
		JLabel price = new JLabel("$" + "3000");
		price.setFont(new Font("Dialog", Font.BOLD, 17));
		price.setForeground(new Color(247, 162, 67));
		infoPanel.add(price, c);
		
		c.gridy = 2;
		infoPanel.add(new JLabel("存貨"), c);
		
		c.gridx = 1;
		infoPanel.add(new JLabel("#"), c);
		
		c.gridx = 3;
		c.gridy = 1;
		this.setCount();
		infoPanel.add(count, c);
		
		c.gridy = 2;
		infoPanel.add(addToCart, c);
		
		gridBag.gridx = 1;
		displayPanel.add(infoPanel, gridBag);
		
		//加入discriptionArea
		JTextArea discriptionArea = new JTextArea();
		discriptionArea.setText("這是一台腳踏車\n不過是假的，而且很臭");
		discriptionArea.setEditable(false);
		discriptionArea.setBackground(new Color(238, 238, 238));
		discriptionArea.setOpaque(true);
		discriptionArea.setFont(new Font("Dialog", Font.ITALIC, 17));
		gridBag.gridx = 0;
		gridBag.gridy = 1;
		gridBag.gridwidth = 2;
		displayPanel.add(discriptionArea, gridBag);
		
		this.add(displayPanel);
	}

	private ImageIcon getTransformedIcon(String path) {
		ImageIcon icon = new ImageIcon(path);
		Image image = icon.getImage();
		image = image.getScaledInstance(360, 270, Image.SCALE_SMOOTH);
		return new ImageIcon(image);
	}
	
	/**
	 * 依照資料庫資料設定可以買多少個
	 */
	private void setCount() {
		for (int i = 1; i < 11; i++) {
			count.addItem(i);
		}
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
