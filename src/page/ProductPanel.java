package page;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.json.JSONObject;

import app.App;
import myHTTP.Request;
import myHTTP.Response;

public class ProductPanel extends JPanel implements ActionListener{

	/**
	 * 根據data做出一個商品框框，點商品名稱可以進入商品頁面
	 * @param data 商品資訊，包含名稱、價錢、圖片
	 */
	public ProductPanel(JSONObject data) {
		
		this.setLayout(new GridBagLayout());
		GridBagConstraints gridBag = new GridBagConstraints();
		gridBag.gridx = 0;
		gridBag.gridy = 0;
		
		//根據商品顯示熱門、新品標籤或無標籤
		if (true) {
			this.setBorder(BorderFactory.createTitledBorder("熱門"));
		} else if (false) {
			this.setBorder(BorderFactory.createTitledBorder("新品"));
		}
		
		//插入商品圖片
		ImageIcon icon = this.getTransformedIcon("static/" + "12345.jpeg");
		JLabel picture = new JLabel(icon);
		gridBag.insets = new Insets(10, 10, 10, 10);
		gridBag.gridwidth = 2;
		this.add(picture, gridBag);
		
		//插入商品名稱
		JButton productName = new JButton("商品");
		productName.setBorderPainted(false);
		productName.setContentAreaFilled(false);
		productName.addActionListener(this);
		gridBag = new GridBagConstraints();
		gridBag.gridx = 0;
		gridBag.gridy = 1;
		this.add(productName, gridBag);
		
		//插入加入購物車
		JButton addToCart = new JButton("加入購物車");
		addToCart.setBorderPainted(false);
		addToCart.setContentAreaFilled(false);
		addToCart.addActionListener(this);
		gridBag.gridx++;
		this.add(addToCart, gridBag);
		
		//插入商品價格
		JLabel productPrice = new JLabel("$" + "100");
		gridBag.gridx = 0;
		gridBag.gridy++;
		this.add(productPrice, gridBag);
		
	}

	/**
	 * 產生統一大小的圖片
	 * @param path 圖片的位址
	 * @return 統一大小的ImageIcon
	 */
	private ImageIcon getTransformedIcon(String path) {
		ImageIcon icon = new ImageIcon(path);
		Image image = icon.getImage();
		image = image.getScaledInstance(200, 150, Image.SCALE_SMOOTH);
		return new ImageIcon(image);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			System.out.println("打開商品頁面");
//			//建立新的商品頁面
//			Response response = App.route(new Request(App.path.PRODUCT_INFO, Request.Method.GET, App.USER, null));
//			ProductPage page = new ProductPage(response);
//			page.setVisible(true);
		} catch(Exception error) {
			//Do nothing
		}
		
	}
	
}
