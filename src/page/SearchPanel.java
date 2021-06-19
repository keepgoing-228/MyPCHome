package page;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import org.json.JSONObject;

public class SearchPanel extends JPanel {

	private JButton search = new JButton("Search");
	private JComboBox<String> brand = new JComboBox<String>();
	private JComboBox<String> category = new JComboBox<String>();
	
	public SearchPanel(BasePage page) {
		
		/*
		 * 加入品牌、類別的選單、品名搜尋欄、搜索按鈕
		 * 搜索按鈕的actionlistener為傳入的BasePage
		 */
		
	}
	
	/**
	 * 得到使用者在search bar輸入的內容。如果三個欄位都沒有內容，會送出InputException
	 * @return 裝著資料的JSONObject（例：{"brand":"Apple", "category":"Phone", "name":null}）
	 */
	public JSONObject getData() {
		return null;
	}

}
