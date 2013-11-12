package view;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class SetTemperatureView extends JFrame implements
		TemperatureViewInterface {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3292430212918025034L;

	private JTextField setTemperature;
	private JSlider temperatureSlider;
	private JButton setTemperatureBtn;
	
	public SetTemperatureView() {

		setTemperature 		= new JTextField();
		temperatureSlider	= new JSlider(SwingConstants.HORIZONTAL, -30, 100, 1);
		temperatureSlider.setMajorTickSpacing(10);
		setTemperatureBtn	= new JButton("Änderung speichern");
		
		JPanel panel = new JPanel(new GridLayout(3, 2));
		panel.add(new JLabel("Aktuelle Temperatur ändern: "));
		panel.add(setTemperature);
		
		panel.add(new JLabel("Aktuelle Temperatur per Slider ändern: "));
		panel.add(temperatureSlider);
		
		panel.add(setTemperatureBtn);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().add(panel);
		this.pack();
		this.setVisible(true);
	}
	
	public JTextField getSetTemperature() {
		return setTemperature;
	}

	public JSlider getTemperatureSlider() {
		return temperatureSlider;
	}

	public JButton getSetTemperatureBtn() {
		return setTemperatureBtn;
	}

	@Override
	public void update(double temperature) {
		this.setTemperature.setText(temperature + "°C");
		this.temperatureSlider.setValue((int)temperature);
	}

}
