package com.movingobject.objects;



public class MovingCube extends MovingObject{
	
	
	public MovingCube(String facedirection, byte xIndex, byte yIndex) {
		super();
		this.facedirection = facedirection;
		this.xIndex = xIndex;
		this.yIndex = yIndex;
	}

	
   public void turnRight() {
				
			if("n".equalsIgnoreCase(this.getFacedirection())) {				
				this.facedirection = "E";
			}else if("e".equalsIgnoreCase(this.getFacedirection())) {				
				this.facedirection = "S";
			}else if("s".equalsIgnoreCase(this.getFacedirection())) {				
				this.facedirection = "W";
			}else {				
				this.facedirection ="N";
			}
		
	}
	
    public void turnLeft() {
			if("n".equalsIgnoreCase(this.getFacedirection())) {				
				this.setFacedirection("W");
			}else if("w".equalsIgnoreCase(this.getFacedirection())) {				
				this.setFacedirection("S");
			}else if("s".equalsIgnoreCase(this.getFacedirection())) {				
				this.setFacedirection("E");
			}else {				
				this.setFacedirection("N");
			}
		
	}
	
	

}
