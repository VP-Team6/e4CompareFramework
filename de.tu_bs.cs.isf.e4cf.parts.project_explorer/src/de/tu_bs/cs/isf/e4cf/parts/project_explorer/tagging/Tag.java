package de.tu_bs.cs.isf.e4cf.parts.project_explorer.tagging;

import java.io.Serializable;

import javafx.scene.paint.Color;

public class Tag implements Serializable {

	private static final long serialVersionUID = 1L;
	private String name;
	private String colorString;

	public Tag(String name, String colorString) {
		setName(name);
		setColorString(colorString);
	}

	public Tag(String name, Color color) {
		setName(name);
		setColor(color);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Color getColor() {
		return Color.web(colorString);
	}

	public void setColor(Color color) {
		this.colorString = toHexString(color);
	}

	public String getColorString() {
		return colorString;
	}

	public void setColorString(String colorString) {
		this.colorString = colorString;
	}

	/**
	 * Format a value as a hex string
	 * 
	 * @param value double
	 * @return hex string
	 */
	private String format(double value) {
		String in = Integer.toHexString((int) Math.round(value * 255));
		return in.length() == 1 ? "0" + in : in;
	}

	/**
	 * Build hex string representing a color
	 * 
	 * @param color to represent
	 * @return hex string for color
	 */
	private String toHexString(Color color) {
		return "#" + (format(color.getRed()) + format(color.getGreen()) + format(color.getBlue())
				+ format(color.getOpacity())).toUpperCase();
	}

	@Override
	public boolean equals(Object obj) {
		if (super.equals(obj)) {
			return true;
		}

		if (!(obj instanceof Tag)) {
			return false;
		}

		Tag tag = (Tag) obj;

		return (tag.name == this.name && tag.colorString == this.colorString);
	}
}
