package com.movingobject.controller;


import java.util.Scanner;

import com.movingobject.objects.MovingCube;
import com.movingobject.objects.MovingObject;



public class ObjectController {

	final private static String OBJECT_FALL_DOWN_MSG ="[-1, -1]";
	
	private MovingObject movingObj = null;
	private MovingObject [][] grid = null;
	
	ObjectController mainCls = null;
	byte commands[] = null;
	
	public static void main(String[] args) {
		
		System.out.println("Pls input 4 comma seperated numbers. Eg ( 3,3,2,2)");
		
        ObjectController oc = new ObjectController();
        oc.inputReader(); 
     
   	}
	
	private void inputReader() {
		
		Scanner dis=new Scanner(System.in);
	       
        String line;
        String[] lineVector;
        
		 while (true) { // to get the inputs to initialize the table and the object
	        	
	        	line = dis.nextLine(); //read 1,2,3
	        	lineVector = line.split(",");
	        	if(lineVector.length==4) {
	            	try {
	            		byte i = Byte.parseByte(lineVector[0]);
	            		byte j = Byte.parseByte(lineVector[1]);
	            		byte k = Byte.parseByte(lineVector[2]);
	            		byte l = Byte.parseByte(lineVector[3]);
	            
	            		if(i==4 && j==4 && k<4 && l<4) {
	            			
	        				grid = new MovingObject[i][j]; // create the 4*4 table 
	        				movingObj = new MovingCube("N", Byte.parseByte(lineVector[2]),Byte.parseByte(lineVector[3]));
	        				grid[k][l] = movingObj; // assign the Moving object's location into the grid
	        				break;
	        				
	            		}else {
	            			System.out.println("input values are larger than expected");
	            		}   		
	    			} catch (NumberFormatException e) {
	    				System.out.println("Pls input only numbers");
	    			}
	            	
	            }else {
	            	System.out.println("Ivalid number of arguments. please enter 4 integer values");
	            }
	        	
	        }
	       
		 while(true) {
	        	// get the second input
	        	System.out.println("pls input the commands to move..");
	        
	        	line = dis.nextLine(); //read the moving commands.
	        	lineVector = line.split(",");
	        	commands = toByte (lineVector); // convert moving instructions to an array
	            
	            controlObject(commands, movingObj);
	           
	        }
		
	}
	
	private static byte[] toByte(final String[] strs) {
        byte[] bytes=new byte[strs.length];
        for (int i=0; i<strs.length; i++) {
            bytes[i]=Byte.parseByte(strs[i]);
        }
        return bytes;
    }
	
	/**
	 * This method interprets the commands given as input.
	 * 0 = quit simulation and print results to stdout 
	 * 1 = move forward one step 
	 * 2 = move backwards one step 
	 * 3 = rotate clockwise 90 degrees (eg north to east) 
	 * 4 = rotate counterclockwise 90 degrees (eg west to south
	 */	
	private void controlObject(byte[] path, MovingObject mObj) {
		
		for (byte i = 0; i < path.length; i++) {
			if(path[i]==0) {
				mObj.printPosition();				
			} else if(path[i]==1){
				moveForward(mObj);
			}else if (path[i]==2) {
				moveBackward(mObj);
			}else if (path[i] == 3) {
				mObj.turnRight();
			}else if (path[i] == 4) {
				mObj.turnLeft();
			}else {
				System.out.println("No command found for given value. Please enter value between 0-4");
			}
		}
		//44printMap();	
		
	}
	
	private void moveForward(MovingObject obj) {
		
		String direction = obj.getFacedirection();
		byte currentY = obj.getyIndex();
		byte currentX = obj.getxIndex();

		
		if(direction.equalsIgnoreCase("n")) {
			
			if(obj.getxIndex() == 0) {
				System.out.println(ObjectController.OBJECT_FALL_DOWN_MSG);
			}else if(obj.getxIndex() > 0){
				grid[currentX][currentY] = null;
				obj.setxIndex((byte) (currentX-1));
				grid[currentX - 1][currentY] = obj;
				//obj.printPosition();
			}
		}else if(direction.equalsIgnoreCase("s")) {
			
			if(obj.getxIndex() == grid.length-1) {
				System.out.println(ObjectController.OBJECT_FALL_DOWN_MSG);
			
			}else if(obj.getxIndex() < grid.length){
				
				grid[currentX][currentY] = null;
				obj.setxIndex((byte) (currentX + 1));
				grid[currentX + 1][currentY] = obj;
				
				//obj.printPosition();
			}
		}else if(direction.equalsIgnoreCase("e")) {
			
			if(obj.getyIndex() == grid[0].length-1) {
				System.out.println(ObjectController.OBJECT_FALL_DOWN_MSG);
			
			}else if(obj.getyIndex() < grid[0].length){
			
				grid[currentX][currentY] = null;
				obj.setyIndex((byte) (currentY + 1));
				grid[currentX][currentY+1] = obj;
				
				//obj.printPosition();
			}
		}else if(direction.equalsIgnoreCase("w")) {
			
			if(obj.getyIndex() == 0) {
				System.out.println(ObjectController.OBJECT_FALL_DOWN_MSG);
				
			}else if(obj.getyIndex() < grid[0].length){
			
				grid[currentX][currentY] = null;
				obj.setyIndex((byte) (currentY -1));
				grid[currentX][currentY-1] = obj;
				
				//obj.printPosition();
			}
		}
	}
	
	private void moveBackward(MovingObject obj) {
		
		String direction = obj.getFacedirection();
		byte currentY = obj.getyIndex();
		byte currentX = obj.getxIndex();
		

		if(direction.equalsIgnoreCase("n")) {
			
			if(obj.getxIndex() == grid.length-1) {
				System.out.println(ObjectController.OBJECT_FALL_DOWN_MSG);
			}else if(obj.getxIndex() < grid.length){

				grid[currentX][currentY] = null;
				obj.setxIndex((byte) (currentX+1));
				grid[currentX + 1][currentY] = obj;
				
				//obj.printPosition();
			}
		}else if(direction.equalsIgnoreCase("s")) {
			
			if(obj.getxIndex() == 0) {
				System.out.println(ObjectController.OBJECT_FALL_DOWN_MSG);
				
			}else if(obj.getxIndex() < grid.length){
				
				grid[currentX][currentY] = null;
				obj.setxIndex((byte) (currentX - 1));
				grid[currentX - 1][currentY] = obj;
				
				//obj.printPosition();
			}
		}else if(direction.equalsIgnoreCase("e")) {
			
			if(obj.getyIndex() == 0) {
				System.out.println(ObjectController.OBJECT_FALL_DOWN_MSG);
			}else if(obj.getyIndex() < grid[0].length){
				
				grid[currentX][currentY] = null;
				obj.setyIndex((byte) (currentY - 1));
				grid[currentX][currentY - 1] = obj;
				
				//obj.printPosition();
			}
		}else if(direction.equalsIgnoreCase("w")) {
			
			if(obj.getyIndex() == grid[0].length-1) {
				System.out.println(ObjectController.OBJECT_FALL_DOWN_MSG);
				
			}else if(obj.getyIndex() < grid[0].length){
				
				grid[currentX][currentY] = null;
				obj.setyIndex((byte) (currentY + 1));
				grid[currentX][currentY + 1] = obj;
			
				//obj.printPosition();
			}
		}
	
	}
	
	
	/**
	 * for testing to print the object location on the map
	 * */
	private void printMap() {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				System.out.println(i + " " + j);
				System.out.println(grid[i][j]);
				
			}
			
		}
		
	}

}
