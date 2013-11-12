package view;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.TemperatureController;

public class CelciusView extends JFrame implements TemperatureViewInterface {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9191707336299714213L;
	private JLabel currentTemperature;

	public CelciusView() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		currentTemperature = new JLabel();
		JPanel jPanel = new JPanel(new GridLayout(1, 2));
		jPanel.add(new JLabel("Aktuelle Temperatur:"));
		jPanel.add(currentTemperature);
		
		this.getContentPane().add(jPanel);
		this.pack();
		this.setVisible(true);
		
	}
	
	@Override
	public void update(double temperature) {
		this.currentTemperature.setText(temperature + "°C");
	}

}
