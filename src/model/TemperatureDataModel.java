package model;

import java.util.ArrayList;
import java.util.List;

import view.TemperatureViewInterface;

public class TemperatureDataModel implements TemperatureDataModelInterface {

	private double currentTemperature;
	private double currentPressure;
	private double currentHumidity;
	
	private List<TemperatureViewInterface> observers;
	
	public TemperatureDataModel() {
		
		observers = new ArrayList<TemperatureViewInterface>();
	}

	public double getCurrentTemperature() {
		return currentTemperature;
	}

	public void setCurrentTemperature(double currentTemperature) {
		this.currentTemperature = currentTemperature;
		updateObserver();
	}

	public double getCurrentPressure() {
		return currentPressure;
	}

	public void setCurrentPressure(double currentPressure) {
		this.currentPressure = currentPressure;
		updateObserver();
	}

	public double getCurrentHumidity() {
		return currentHumidity;
	}

	public void setCurrentHumidity(double currentHumidity) {
		this.currentHumidity = currentHumidity;
		updateObserver();
	}

	private void updateObserver() {
		for(TemperatureViewInterface tv : observers) {
			tv.update(currentTemperature, currentPressure, currentHumidity);
		}
	}

	@Override
	public void register(TemperatureViewInterface tv) {
		if(!observers.contains(tv)) {
			observers.add(tv);
		}
	}

	@Override
	public void unregister(TemperatureViewInterface tv) {
		if(observers.contains(tv)) {
			observers.remove(tv);
		}
	}
}
