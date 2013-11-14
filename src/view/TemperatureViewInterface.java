package view;

public interface TemperatureViewInterface {

	public abstract void update(double temperature);
	public void update(double temperature, double pressure, double humidity);
}
