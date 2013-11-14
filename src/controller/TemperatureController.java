package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import model.TemperatureDataModel;
import model.TemperatureDataModelInterface;
import view.CelciusView;
import view.FahrenheitView;
import view.SetTemperatureView;
import view.TemperatureViewInterface;

public class TemperatureController {

	private TemperatureViewInterface celsiusView;
	private TemperatureViewInterface fahrenheitView;
	private SetTemperatureView setTemperatureView;
	private TemperatureDataModelInterface model;
	
	public TemperatureController() {
		
		// Instanzen der Views erzeugen
		celsiusView 		= new CelciusView();
		fahrenheitView		= new FahrenheitView();
		setTemperatureView	= new SetTemperatureView();
		// Instanz des DataModels erzeugen
		model	= new TemperatureDataModel();
		// die View beim Model als Observer registrieren
		model.register(celsiusView);
		model.register(fahrenheitView);
		model.register(setTemperatureView);
		
		// ActionListener auf die SetTemperatureView setzen
		addActionListener();
		// initiales setzen der Temperatur
		model.setCurrentTemperature(20.0);
		model.setCurrentHumidity(49);
		model.setCurrentPressure(1120);
		
	}

	private void addActionListener() {
		
		JButton setTemperatureBtn 		= setTemperatureView.getSetTemperatureBtn();
		final JTextField newTemperature	= setTemperatureView.getSetTemperature();
		final JTextField newHumidity	= setTemperatureView.getSetHumindity();
		final JTextField newPressure	= setTemperatureView.getSetPressure();
		final JSlider slider			= setTemperatureView.getTemperatureSlider();
		setTemperatureBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					double newTemp = Double.parseDouble(newTemperature.getText());
					String humidity = newHumidity.getText();
					double humidityDouble = Double.parseDouble(humidity);
					String pressure = newPressure.getText();
					double pressureDouble = Double.parseDouble(pressure);
					model.setCurrentTemperature(newTemp);
					model.setCurrentHumidity(humidityDouble);
					model.setCurrentPressure(pressureDouble);
				} catch(NumberFormatException ex) {
					setTemperatureView.getSetTemperature().setText("Fehlerhafte Eingabe! Nur Zahlen sind zulässig!");
				}
			}
		});
		
		slider.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				
				int newTemp = slider.getValue();
				model.setCurrentTemperature(newTemp);
			}
		});
	}
}
