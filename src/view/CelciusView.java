package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;

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
	private JLabel currentPressure;
	private JLabel currentHumidity;
	private JLabel waringLabel;

	public CelciusView() {
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		JPanel mainPanel 	= new JPanel(new BorderLayout());
		currentTemperature 	= new JLabel();
		currentHumidity		= new JLabel();
		currentPressure		= new JLabel();
		waringLabel			= new JLabel("Warnung");
		waringLabel.setOpaque(true);
		
		JPanel jPanel = new JPanel(new GridLayout(3, 2));
		jPanel.add(new JLabel("Aktuelle Temperatur:"));
		jPanel.add(currentTemperature);
		
		jPanel.add(new JLabel("Aktuelle Luftfeuchtigkeit:"));
		jPanel.add(currentHumidity);
		
		jPanel.add(new JLabel("Aktueller Luftdruck:"));
		jPanel.add(currentPressure);
		
		mainPanel.add(jPanel, BorderLayout.NORTH);
		
		mainPanel.add(waringLabel, BorderLayout.SOUTH);
		
		this.getContentPane().add(mainPanel);
		this.pack();
		this.setVisible(true);
		
	}
	
	@Override
	public void update(double temperature) {
		this.currentTemperature.setText(temperature + "°C");
	}
	
	@Override
	public void update(double temperature, double pressure, double humidity) {
		
		if(temperature <= -20) {
			this.waringLabel.setText("Es ist sau kalt");
			this.waringLabel.setBackground(Color.BLUE);
		} else if (temperature > -20 && temperature < 35) {
			this.waringLabel.setText("Ganz angenehme Temperatur");
			this.waringLabel.setBackground(Color.white);
		} else {
			this.waringLabel.setText("Puhh, ganz schön heiß!");
			this.waringLabel.setBackground(Color.red);
		}
		
		this.currentTemperature.setText(temperature + "°C");
		this.currentHumidity.setText(humidity + "%");
		this.currentPressure.setText("" + pressure);
	}

}
