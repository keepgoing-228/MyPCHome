package page;

import java.awt.GridBagConstraints;

import javax.swing.JPanel;

public class ProductDisplayPanel extends JPanel {

	private GridBagConstraints gridBag = new GridBagConstraints();
	
	public ProductDisplayPanel() {
		gridBag.gridx = 0;
		gridBag.gridy = 0;
	}
	
	public void addProduct(ProductPanel product) {
		
		if(gridBag.gridx == 3) {
			gridBag.gridx = 0;
			gridBag.gridy++;
		} else {
			gridBag.gridx++;
		}
		this.add(product, gridBag);
	}
	
}
