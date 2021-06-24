package page;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class ProductDisplayPanel extends JPanel {

	private GridBagConstraints gridBag = new GridBagConstraints();
	
	public ProductDisplayPanel() {
		gridBag.gridx = 0;
		gridBag.gridy = 0;
		gridBag.insets = new Insets(10, 20, 10, 20);
		this.setLayout(new GridBagLayout());
	}
	
	public void addProduct(ProductPanel product) {
				
		this.add(product, gridBag);
		if(gridBag.gridx == 2) {
			gridBag.gridx = 0;
			gridBag.gridy++;
		} else {
			gridBag.gridx++;
		}
	}
	
}
