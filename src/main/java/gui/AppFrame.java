/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gui;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author Cuong
 */
public class AppFrame {
	private JFrame appFrame = null;
	private Container container = null;
	
	private int width = 800; // default width
	private int height = 600; // default height
	
	private JTextField sensorUri = null;
	private JPanel sensorPanel = null;
	
	public AppFrame(String title) {
		appFrame = new JFrame(title);
		appFrame.setMinimumSize(new Dimension(width, height));
		appFrame.setSize(width, height);
		appFrame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent windowEvent){
				 System.exit(0);
			}        
    });
		
		// Layout and components
		container = appFrame.getContentPane();
		container.setLayout(new MigLayout(
			"",
			"[grow] []",
			"[] []"
		));
		
		JButton newSensorButton = new JButton("Add Sensor");
		newSensorButton.setPreferredSize(null);
		newSensorButton.addActionListener(new ActionListener() {
     	@Override	public void actionPerformed(ActionEvent e) { newSensorAction(e);	}
    });
		
		sensorUri = new JTextField("Enter new sensor URI here to inspect...");
		sensorUri.setBackground(java.awt.Color.WHITE);
		
		container.add(sensorUri, "grow");
		container.add(newSensorButton, "wrap");
	}
	
	public void newSensorAction(ActionEvent e) {
		container.add(new SensorView(this.getWidth(), 200), "grow, span 2, wrap");
		container.revalidate();
	}
	
	public void showFrame() {
		appFrame.setVisible(true);
	}
	
	public void setWidth(int width) { this.width = width; }
	public int getWidth() { return width; }
	
	public void setHeight(int height) { this.height = height; }
	public int getHeight() { return height; }
}
