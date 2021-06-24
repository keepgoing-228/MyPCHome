package page;

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

import org.json.JSONObject;

import listener.SearchPanelListener;

public class SearchPanel extends JPanel implements ActionListener{

	private JTextField searchField = new JTextField(10);
	private JButton search = new JButton("搜尋");
	private JComboBox<String> brand = new JComboBox<String>();
	private JComboBox<String> category = new JComboBox<String>();
	
	public SearchPanel() {
		
		this.setLayout(new GridBagLayout());
		GridBagConstraints gridBag = new GridBagConstraints();
		gridBag.gridx = 0;
		gridBag.gridy = 0;
		gridBag.insets = new Insets(10, 0, 10, 20);
		
		/*
		 * 加入品牌、類別的選單、品名搜尋欄、搜索按鈕
		 */
		this.setBrand();
		this.brand.addActionListener(this);
		this.add(this.brand, gridBag);
		
		gridBag.gridx++;
		this.setCategory();
		this.add(this.category, gridBag);
		
		gridBag.gridx++;
		this.add(this.searchField, gridBag);
		gridBag.gridx++;
		search.addActionListener(new SearchPanelListener());
		this.add(this.search, gridBag);
		
	}
	
	/**
	 * 從資料庫中抓取現有的品牌名稱，並回到“品牌...”
	 */
	private void setBrand() {
		this.brand.addItem("品牌...");
		this.brand.addItem("Apple");
		this.brand.addItem("Acer");
		this.brand.addItem("Asus");
		this.brand.setSelectedItem("品牌...");
	}
	
	/**
	 * 依照選取的品牌加入該品牌有的品項，並回到“類別...”
	 */
	private void setCategory() {
		this.category.removeAllItems();
		this.category.addItem("類別...");
		this.category.addItem("手機");
		this.category.addItem("電腦");
		this.category.setSelectedItem("類別...");
	}
	
	/**
	 * 得到使用者在search bar輸入的內容。如果三個欄位都沒有內容，會送出InputException
	 * @return 裝著資料的JSONObject（例：{"brand":"Apple", "category":"Phone", "name":null}）
	 */
	public JSONObject getData() {
		return null;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		this.setCategory();
		
	}

}
