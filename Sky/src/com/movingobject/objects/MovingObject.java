package com.movingobject.objects;

public abstract class MovingObject {

	String facedirection = "N";

	byte xIndex, yIndex;

	public String getFacedirection() {
		return facedirection;
	}

	public void setFacedirection(String facedirection) {
		this.facedirection = facedirection;
	}

	public byte getxIndex() {
		return xIndex;
	}

	public void setxIndex(byte xIndex) {
		this.xIndex = xIndex;
	}

	public byte getyIndex() {
		return yIndex;
	}

	public void setyIndex(byte yIndex) {
		this.yIndex = yIndex;
	}

	
	public void printPosition() {
		System.out.println("[" + xIndex + ", " + yIndex+ "]");
	}

	
	public abstract void turnRight();
	
	public abstract void turnLeft();
}
