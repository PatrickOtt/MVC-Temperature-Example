package model;

import view.TemperatureViewInterface;

public interface TemperatureDataModelInterface {

	public abstract void setCurrentTemperature(double temperature);
	public abstract void setCurrentPressure(double currentPressure);
	public abstract void setCurrentHumidity(double currentHumidity);
	public abstract void register(TemperatureViewInterface tv);
	public abstract void unregister(TemperatureViewInterface tv);
}
