package model;

import java.util.ArrayList;
import java.util.List;

import view.TemperatureViewInterface;

public class TemperatureDataModel implements TemperatureDataModelInterface {

	private double currentTemperature;
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

	private void updateObserver() {
		for(TemperatureViewInterface tv : observers) {
			tv.update(currentTemperature);
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
