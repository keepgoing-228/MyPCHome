import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.*;
import javax.swing.filechooser.FileFilter;

import app.App;
import myHTTP.Response;

public class UploadPage extends ProfilePage implements ActionListener {

	private JTextField name = new JTextField(10);
	private JComboBox<String> brand = new JComboBox<String>();
	private JComboBox<String> category = new JComboBox<String>();
	private JTextField number = new JTextField(10);
	private JTextField price = new JTextField(10);
	private JTextField discription = new JTextField(10);
	private JFileChooser picture = new JFileChooser();
	private JButton pictureButton, uploadButton;
	// �]�w�w���j�p
	final int PREVIEW_SIZE = 100;
	// �b��e���|�U�إ��ɮ׿�ܾ�
	private JFileChooser chooser = new JFileChooser(".");
	// ��Label�Ω���ܹw��
	private JLabel accessory = new JLabel();
	// �w�q�ɮ׹L�o��
	ExtensionFileFilter filter = new ExtensionFileFilter();
	FileInputStream fileInput;
	FileOutputStream fileOutput;

	public void pictureInit() {
		// ------------�U����l��JFileChooser�������ݩ�--------------------
		filter.addExtension("jpg");
		filter.addExtension("jpeg");
		filter.addExtension("gif");
		filter.addExtension("png");
		filter.setDescription("�ɮ׹Ϥ�(*.jpg, *.jpeg, *.gif, *png)");
		chooser.addChoosableFileFilter(filter);
		// ���äU�ԦC�������Ҧ��ɮס��ﶵ
		chooser.setAcceptAllFileFilterUsed(false);
		// ���ɮ׿�ܾ����w�@�ӹw���Ϥ�������
		chooser.setAccessory(accessory);
		// �]�w�w�����󪺤j�p�M���
		accessory.setPreferredSize(new Dimension(PREVIEW_SIZE, PREVIEW_SIZE));
		accessory.setBorder(BorderFactory.createEtchedBorder());
		// �Ω��˴��Q���ɮק��ܪ��ƥ�
		chooser.addPropertyChangeListener(event -> {
			if (event.getPropertyName() == JFileChooser.SELECTED_FILE_CHANGED_PROPERTY) {
				// ����ϥΪ̷s��ܪ��ɮ�
				File f = (File) event.getNewValue();
				if (f == null) {
					accessory.setIcon(null);
					return;
				}
				// �N�Q���ɮ�Ū�JImageIcon����
				ImageIcon icon = new ImageIcon(f.getPath());
				// �p�G�ɮפӤj�A�h�Y�p��
				if (icon.getIconWidth() > PREVIEW_SIZE) {
					icon = new ImageIcon(icon.getImage().getScaledInstance(PREVIEW_SIZE, -1, Image.SCALE_DEFAULT));
				}
				// ����accessory���ϥ�
				accessory.setIcon(icon);
			}
		});

		// �������}�ҡ��u�X�ɮ׿�ܵ���
		pictureButton.addActionListener(event -> {
			// ����ɮ׹�ܤ��
			int result = chooser.showOpenDialog(this);
			if (result == JFileChooser.APPROVE_OPTION) {
				String namePath = chooser.getSelectedFile().getPath();
				try {
					fileInput = new FileInputStream(namePath);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
			}
		});


	}

	public void pictureOutput() {
		// ��{�Ϥ����ƻs�x�s
		uploadButton.addActionListener(event -> {
			String name = chooser.getSelectedFile().getName();
//			System.out.println(name);
			//��J�n���w�������m
			File f = new File("D:\\NTU\\�j�|�U\\����ɦV�{���]�p\\java project\\MyPCHome\\pic",name);
			try {
				fileOutput = new FileOutputStream(f);
				byte[] bytes = new byte[1024];
				int hasRead;
				while ((hasRead = fileInput.read(bytes, 0, 1024)) != -1) {
					fileOutput.write(bytes, 0, hasRead);
				}
				fileOutput.close();
				fileInput.close();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		});
	}

	UploadPage() {
		// Panel
		JPanel rightPanel = new JPanel();
		rightPanel.setLayout(new GridBagLayout());
		rightPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		JPanel productPanel = new JPanel();
		productPanel.setLayout(new GridBagLayout());
		productPanel.setBorder(BorderFactory.createEtchedBorder());

		// label
		JLabel nameLabel = new JLabel("�ӫ~�W��");
		GridBagConstraints gridBag = new GridBagConstraints();
		gridBag.fill = GridBagConstraints.BOTH;
		gridBag.insets = new Insets(5, 20, 5, 10);
		gridBag.gridx = 0;
		gridBag.gridy = 0;
		productPanel.add(nameLabel, gridBag);

		JLabel brandLabel = new JLabel("�~�P");
		gridBag.gridy = 1;
		productPanel.add(brandLabel, gridBag);

		JLabel categoryLabel = new JLabel("���O");
		gridBag.gridy = 2;
		productPanel.add(categoryLabel, gridBag);

		JLabel numberLabel = new JLabel("�s�f�ƶq");
		gridBag.gridy = 3;
		productPanel.add(numberLabel, gridBag);

		JLabel priceLabel = new JLabel("����");
		gridBag.gridy = 4;
		productPanel.add(priceLabel, gridBag);

		JLabel discriptionLabel = new JLabel("�ԭz");
		gridBag.gridy = 5;
		productPanel.add(discriptionLabel, gridBag);

		JLabel pictureLabel = new JLabel("�Ϥ�");
		gridBag.gridy = 6;
		productPanel.add(pictureLabel, gridBag);

		// text field
		gridBag.insets = new Insets(5, 20, 5, 10);
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

		// button
		pictureButton = new JButton("�п�Ӥ�");
		this.pictureInit();
		gridBag.gridy = 6;
		gridBag.insets = new Insets(5, 300, 5, 300);
		productPanel.add(pictureButton, gridBag);

		uploadButton = new JButton("�W�[");
		uploadButton.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		this.pictureOutput();
		gridBag.ipadx = 30;
		gridBag.ipady = 20;
		gridBag.gridy = 7;
		gridBag.insets = new Insets(30, 600, 10, 30);
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

	// �إ�FileFilter���l���A�Ω��{�ɮ׹L�o�\��
	class ExtensionFileFilter extends FileFilter {
		private String description;
		private ArrayList<String> extensions = new ArrayList<>();

		// �۩w�q��k�A�Ω�s�W�ɮצr���W
		public void addExtension(String extension) {
			if (!extension.startsWith("."))
				extension = "." + extension;
			extensions.add(extension.toLowerCase());
		}

		// �Ω�]�w���ɮ׹L�o�����y�z��r
		public void setDescription(String description) {
			this.description = description;
		}

		public String getDescription() {
			return description;
		}

		public boolean accept(File file) {
			if (file.isDirectory())
				return true;
			String name = file.getName().toLowerCase();
			for (String extension : extensions) {
				if (name.endsWith(extension))
					return true;
			}
			return false;
		}
	}

//	@Override
//	public void actionPerformed(ActionEvent e) {
//		
//		try {
//			App.route(new Request(App.path.UPLOAD, Request.Method.POST, App.USER, this.getData()));
//			Response response = App.route(new Request(App.path.PRODUCT_INFO, Request.Method.GET, App.USER, this.getData()));
//			ProductPage page = new ProductPage(response);
//			page.setVisible(true);
//			this.setVisible(false);
//			this.dispose();
//		} catch(Exception e2) {
//			this.errorMessage.setText(e2.getMessage());
//		}	
//	}
//	
//	private JSONObject getData() {
//		return null;
//	}

}
