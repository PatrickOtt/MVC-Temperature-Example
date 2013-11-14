package view;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.TemperatureController;

public class FahrenheitView extends JFrame implements TemperatureViewInterface {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel currentFahrenheit;
	
	public FahrenheitView() {
		
		currentFahrenheit = new JLabel();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(0, 0);
		JPanel panel = new JPanel(new GridLayout(1, 2));
		panel.add(new JLabel("Aktuelle Temperatur in Fahrenheit:"));
		panel.add(currentFahrenheit);
		
		this.getContentPane().add(panel);
		this.pack();
		this.setVisible(true);
	}
	
	@Override
	public void update(double temperature) {
	}

	@Override
	public void update(double temperature, double pressure, double humidity) {
		this.currentFahrenheit.setText((temperature*1.8+32) + "F");
	}

}
