import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import app.App;
import myHTTP.Request;
import myHTTP.Response;

public class PersonalInfoPage extends ProfilePage implements ActionListener{

	private JTextField password = new JTextField(20);
	private JTextField email = new JTextField(20);
	private JTextField name = new JTextField(10);
	private JTextField id = new JTextField(20);
	
	PersonalInfoPage(){
		//Panel
		JPanel rightPanel = new JPanel();
		rightPanel.setLayout(new GridBagLayout());
		rightPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		JPanel personalInfoDetailPanel = new JPanel();
		personalInfoDetailPanel.setLayout(new GridBagLayout());
		personalInfoDetailPanel.setBorder(BorderFactory.createEtchedBorder());
		
		
		//label
		JLabel accountLabel = new JLabel("帳號");
		GridBagConstraints gridBag = new GridBagConstraints();
		gridBag.fill = GridBagConstraints.BOTH;
		gridBag.insets = new Insets(60,120,10,10);
		gridBag.gridx = 0;
		gridBag.gridy = 0;
		personalInfoDetailPanel.add(accountLabel, gridBag);
		
		JLabel passwordLabel = new JLabel("密碼");
		gridBag.insets = new Insets(10,120,10,10);
		gridBag.gridy = 1;
		personalInfoDetailPanel.add(passwordLabel, gridBag);
		
		JLabel emailLabel = new JLabel("email");
		gridBag.gridy = 2;
		personalInfoDetailPanel.add(emailLabel, gridBag);
		
		JLabel nameLabel = new JLabel("真實姓名");
		gridBag.gridy = 3;
		personalInfoDetailPanel.add(nameLabel, gridBag);

		JLabel IDLabel = new JLabel("身分證");
		gridBag.gridy = 4;
		personalInfoDetailPanel.add(IDLabel, gridBag);
		
		JLabel account = new JLabel("XXXX");
		gridBag.insets = new Insets(60,10,10,10);
		gridBag.gridx = 1;
		gridBag.gridy = 0;
		personalInfoDetailPanel.add(account, gridBag);
		
		
		//text field
		gridBag.insets = new Insets(10,10,10,10);
		gridBag.gridy = 1;
		personalInfoDetailPanel.add(password, gridBag);
		
		gridBag.gridy = 2;
		personalInfoDetailPanel.add(email, gridBag);
		
		gridBag.gridy = 3;
		personalInfoDetailPanel.add(name, gridBag);
		
		gridBag.gridy = 4;
		personalInfoDetailPanel.add(id, gridBag);
		
		
		//button
		JButton reviseButton = new JButton("修改");
//		reviseButton.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		gridBag.ipadx = 30;
		gridBag.ipady = 20;
		gridBag.gridx = 5;
		gridBag.gridy = 5;
		gridBag.insets = new Insets(15,10,30,60);
		personalInfoDetailPanel.add(reviseButton, gridBag);
		
		
		//package
		GridBagConstraints Grid = new GridBagConstraints();
		Grid.fill = GridBagConstraints.BOTH;
//		Grid.insets = new Insets(0,0,0,0);
		Grid.gridx = 0;
		Grid.gridy = 0;
		rightPanel.add(personalInfoDetailPanel,Grid);
		this.add(rightPanel,BorderLayout.CENTER);
	}
	
	public void actionPerformed(ActionEvent e) {
		try {
			App.route(new Request(App.path.PERSONAL_INFO, Request.Method.POST, App.USER, this.getData()));
			Response response = App.route(new Request(App.path.PERSONAL_INFO, Request.Method.POST, App.USER, null));
			PersonalInfoPage page = new PersonalInfoPage(response);
			page.setVisible(true);
			this.setVisible(false);
			this.dispose();
		} catch (Exception error) {
			errorMessage.setText(error.getMessage());
		}
	}
	
	
	/**
	 * @return 密碼、email、名字、身分證的JSON物件
	 */
	private JSONObject getData() {
		return null;
	}

}
