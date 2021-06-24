package page;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import listener.ShopPageListener;
import myHTTP.Response;

/**
 * @author huangzhangyu
 *商品陳列頁面
 */
public class ShopPage extends BasePage implements ActionListener{

	private JComboBox<String> order = new JComboBox<String>();
	private ProductDisplayPanel productDisplayPanel = new ProductDisplayPanel();
	private JButton up = new JButton("上一頁");
	private JButton down = new JButton("下一頁");
	private Font title = new Font("Dialog", Font.BOLD, 17);
	private JTextField upperRange = new JTextField(6);
	private JTextField lowerRange = new JTextField(6);
	
	public ShopPage(Response response) {
		
		JPanel displayPanel = new JPanel();
		displayPanel.setLayout(new GridBagLayout());
		GridBagConstraints gridBag = new GridBagConstraints();
		gridBag.gridx = 0;
		gridBag.gridy = 0;
		gridBag.anchor = GridBagConstraints.WEST;
		displayPanel.add(new SearchPanel(), gridBag);
		
		//插入商品陳列和翻頁按鈕
		JPanel productChoosePanel = new JPanel();
		productChoosePanel.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		c.insets = new Insets(0, 0, 0, 400);
		c.anchor = GridBagConstraints.WEST;
		JLabel searchString = new JLabel("商品");  //搜索詞條
		searchString.setFont(title);
		productChoosePanel.add(searchString, c);

		c = new GridBagConstraints();
		c.gridx++;
		c.gridx = 1;
		c.gridy = 0;
		c.anchor = GridBagConstraints.WEST;
		productChoosePanel.add(new JLabel("價格範圍"), c);
		c.gridx++;
		productChoosePanel.add(lowerRange, c);
		c.gridx++;
		productChoosePanel.add(new JLabel("~"), c);
		c.gridx++;
		productChoosePanel.add(upperRange, c);
		
		c.gridx++;
		order.addItem("排序方式...");
		order.addItem("最熱門");
		order.addItem("最低到最高價");
		order.addItem("最高到最低價");
		order.addActionListener(this);
		productChoosePanel.add(order, c);

		this.insertProducts(null);
		c.gridx = 0;	
		c.gridy = 1;
		c.gridwidth = 10;
		c.gridheight = 3;
		productChoosePanel.add(productDisplayPanel, c);
		
		c.gridx = 0;
		c.gridy = 4;
		c.gridwidth = 0;
		c.ipady = 0;
		up.addActionListener(this);
		productChoosePanel.add(up, c);
		
		c.gridx = 3;
		down.addActionListener(this);
		productChoosePanel.add(down, c);
		
		gridBag.gridy++;
		displayPanel.add(productChoosePanel, gridBag);
		
		//插入側邊欄
		JPanel sideBar = new JPanel();
		sideBar.setLayout(new GridBagLayout());
		this.setSideBar(sideBar);
		gridBag.gridx = 1;
		gridBag.gridy = 1;
		gridBag.anchor = GridBagConstraints.NORTH;
		displayPanel.add(sideBar, gridBag);
		
		this.add(displayPanel);
		
	}
	
	/**
	 * 根據選擇的排序方法對商品做排序
	 * @param orderMethod: 排序方法
	 */
	private void insertProducts(String orderMethod) {
		productDisplayPanel.addProduct(new ProductPanel(null));
		productDisplayPanel.addProduct(new ProductPanel(null));
		productDisplayPanel.addProduct(new ProductPanel(null));
		productDisplayPanel.addProduct(new ProductPanel(null));
		productDisplayPanel.addProduct(new ProductPanel(null));
		productDisplayPanel.addProduct(new ProductPanel(null));
	}

	/**
	 * 根據response插入有關的品牌以共選擇
	 * @param sideBar: 要放入內容的sideBar
	 */
	private void setSideBar(JPanel sideBar) {
		
		JButton button;
		GridBagConstraints gridBag = new GridBagConstraints();
		gridBag.gridx = 0;
		gridBag.gridy = 0;
		gridBag.insets = new Insets(0, 0, 10, 0);
		for (int i = 0; i < 3; i++) {
			gridBag.gridy = i;
			button = new JButton("品牌");
			button.setFont(new Font("Dialog", Font.ITALIC, 17));
			button.setBorderPainted(false);
			button.setContentAreaFilled(false);
			button.addActionListener(new ShopPageListener());
			sideBar.add(button, gridBag);
		}

	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
