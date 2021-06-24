import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import app.App;
import myHTTP.Request;
import myHTTP.Response;

public class ProfilePage extends BasePage implements ActionListener{
	private final int WIDTH = 1000;
	private final int HEIGHT = 800;
	JLabel personalInfoLabel = new JLabel("基本資訊");
	private JButton personalInfoButton = new JButton("個人資料");
	private JButton launchedProductButton = new JButton("已上架商品");
	private JButton goOnMarketButton = new JButton("商品上架");
	private JButton shoppingCartButton = new JButton("購物車");
	
	
	public ProfilePage() {
		this.setTitle("ProfilePage");
//		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
//		this.setLayout(new BorderLayout());
		
//		//border
//		Border rounded = new LineBorder(Color.black, 1, true);
//		Border empty = new EmptyBorder(300, 3, 0, 0);
//		Border border = new CompoundBorder(rounded, empty);
		
		//panel
		JPanel leftPanel = new JPanel();
		leftPanel.setLayout(new GridBagLayout());
//		leftPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		JPanel ProfilePanel = new JPanel();
		ProfilePanel.setLayout(new GridBagLayout());
		ProfilePanel.setOpaque(true);
		ProfilePanel.setBorder(BorderFactory.createEtchedBorder());
		GridBagConstraints gridBag = new GridBagConstraints();
		gridBag.fill = GridBagConstraints.BOTH;
		gridBag.gridx = 0;
		gridBag.gridy = 0;
		
		
		
		//button
		ProfilePanel.add(personalInfoLabel,gridBag);
		personalInfoButton.addActionListener(this);
		gridBag.gridy = 1;
		ProfilePanel.add(personalInfoButton,gridBag);
		launchedProductButton.addActionListener(this);
		gridBag.gridy = 2;
		ProfilePanel.add(launchedProductButton,gridBag);
		goOnMarketButton.addActionListener(this);
		gridBag.gridy = 3;
		ProfilePanel.add(goOnMarketButton,gridBag);
		shoppingCartButton.addActionListener(this);
		gridBag.gridy = 4;
		ProfilePanel.add(shoppingCartButton,gridBag);
		
		
		gridBag.gridx = 0;
		gridBag.gridy = 0;
		gridBag.fill = GridBagConstraints.BOTH;
		gridBag.insets = new Insets(0,0,300,0);
		gridBag.anchor = GridBagConstraints.NORTH;
		leftPanel.add(ProfilePanel,gridBag);
		this.add(leftPanel,BorderLayout.WEST);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "個人資料": {
			try {
				Response response = App.route(new Request(App.path.PERSONAL_INFO, Request.Method.GET, App.USER, null));
				PersonalInfoPage page = new PersonalInfoPage(response);
				page.setVisible(true);
				this.setVisible(false);
				this.dispose();
			} catch (Exception error) {
				errorMessage.setText(error.getMessage());
			}
			break;
		}
		case "已上架商品": {
			try {
				Response response = App.route(new Request(App.path.UPLOADED_PRODUCT, Request.Method.GET, App.USER, null));
				UploadedProductPage page = new UploadedProductPage(response);
				page.setVisible(true);
				this.setVisible(false);
				this.dispose();
			} catch (Exception error) {
				errorMessage.setText(error.getMessage());
			}
			break;
		}
		case "商品上架": {
			try {
				Response response = App.route(new Request(App.path.Upload, Request.Method.GET, App.USER, null));
				UploadPage page = new UploadPage(response);
				page.setVisible(true);
				this.setVisible(false);
				this.dispose();
			} catch (Exception error) {
				errorMessage.setText(error.getMessage());
			}
			break;
		}
		case "購物車": {
			try {
				Response response = App.route(new Request(App.path.CART, Request.Method.POST, App.USER, null));
				CartPage page = new CartPage(response);
				page.setVisible(true);
				this.setVisible(false);
				this.dispose();
			} catch (Exception error) {
				errorMessage.setText(error.getMessage());
			}
			break;
		}
		}
	}
	
}