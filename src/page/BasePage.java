package page;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import app.App;
import listener.BasePageListener;
import middlewares.Middlewares;
import myHTTP.Request;
import myHTTP.Response;

/**
 * @author huangzhangyu
 *各個頁面的基底
 */
public class BasePage extends JFrame{

	private final int WIDTH = 1000;
	private final int HEIGHT = 800;
	JLabel errorMessage = new JLabel();
	private JButton homeButton = new JButton("首頁");
	private JButton shopButton = new JButton("商場");
	private JButton profileButton = new JButton("會員專區");
	private JButton loginButton = new JButton("登入");
	private JButton logoutButton = new JButton("登出");
	private JButton signUpButton = new JButton("註冊");
	
	public BasePage() {
		
		//設定長寬
		this.setSize(WIDTH, HEIGHT);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLayout(new BorderLayout());;
		
		/*
		 * 製作headerPanel，裡面有：
		 * Home, Shop, Profile, Login/Logout, SignUp Button。如果已經登入就顯示logoutButton，還沒登入就顯示loginButton和signUpButton。Listener this
		 * PXHome, Account Label依照登入狀況顯示
		 * 設置成藍色
		 */
		JPanel headerPanel = new JPanel();
		headerPanel.setLayout(new GridBagLayout());
		headerPanel.setOpaque(true);
		headerPanel.setBackground(new Color(117, 196, 213));
		GridBagConstraints gridBag = new GridBagConstraints();
		gridBag.gridx = 0;
		gridBag.gridy = 0;
		gridBag.insets = new Insets(25, 0, 30, 50);
		JLabel title = new JLabel("PXHome");
		Font headerFormat = new Font("Dialog", Font.BOLD, 20);
		title.setFont(new Font("Dialog", Font.BOLD, 35));
		title.setForeground(Color.white);
		headerPanel.add(title, gridBag);
		
		this.setFormat(homeButton, headerFormat);
		gridBag.insets = new Insets(25, 0, 25, 50);
		gridBag.gridx++;
		headerPanel.add(homeButton, gridBag);
		
		this.setFormat(shopButton, headerFormat);
		gridBag.gridx++;
		headerPanel.add(shopButton, gridBag);
		
		this.setFormat(profileButton, headerFormat);
		gridBag.gridx++;
		headerPanel.add(profileButton, gridBag);

		if (App.USER != null) {
			this.setFormat(logoutButton, headerFormat);
			gridBag.gridx++;
			headerPanel.add(logoutButton, gridBag);
		} else {
			this.setFormat(loginButton, headerFormat);
			gridBag.gridx++;
			headerPanel.add(loginButton, gridBag);
			
			this.setFormat(signUpButton, headerFormat);
			gridBag.gridx++;
			headerPanel.add(signUpButton, gridBag);
		}
		
		
		this.add(headerPanel, BorderLayout.NORTH);
		
		//加入errorMessage
	}
	
	private void setFormat(JButton button, Font format) {
		button.setFont(format);
		button.setForeground(Color.white);
		button.setBorderPainted(false);
		button.setContentAreaFilled(false);
		button.addActionListener(new BasePageListener());
	}
	
	public void setErrorMessage(String errorMessage) {
		this.errorMessage.setText(errorMessage);
	}

}
