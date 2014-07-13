/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.JPanel;

/**
 *
 * @author deeo
 */
public class SensorView extends JPanel {
	
	private Color backgroundColor = Color.YELLOW;
	private Color rulerColor = Color.BLUE;
	private Rectangle drawCanvas = new Rectangle();
	
	public SensorView(int width, int height) {
		Dimension minSize = new Dimension();
		minSize.height = height;
		this.setMinimumSize(minSize);
		this.setSize(width, height);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		drawCanvas.setSize(this.getWidth()-1, this.getHeight()-1);
		
		g.setColor(backgroundColor);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		g.setColor(rulerColor);
		//g.drawRect(0, 0, this.getWidth()-1, this.getHeight()-1);
		g.drawRect(0, 0, drawCanvas.width, drawCanvas.height);
	}
	
	public void setBackgroundColor(Color color) {	this.backgroundColor= color; }
	
	public void setRulerColor(Color color) {	this.rulerColor= color; }
	
	public void refresh() { 
		repaint(); 
	}
	
}
