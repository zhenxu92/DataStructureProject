/*
 * BufferedImageStack.java
 * Copyright Jan 11, 2016 by Shen Jiang
 * 
 * This class implement a stack of BufferedImage objects with using ArrayList to 
 * hold the elements of buffered image stack.
 * 
 * */

import java.util.*;
import java.awt.image.BufferedImage;

public class BufferedImageStack {
	List<BufferedImage> imageStack;
	
	public BufferedImageStack() {
		imageStack = new ArrayList<BufferedImage>();
	}
	
	public void push(BufferedImage bi) {
		imageStack.add(bi);
	}
	
	public BufferedImage pop() {
		if (this.isEmpty())
			throw new EmptyStackException();
		int lastIndex = this.getSize() - 1;
	    BufferedImage bi = imageStack.remove(lastIndex);
	    return bi;
	}
	
	public BufferedImage peek() {
		if (this.isEmpty())
			throw new EmptyStackException();
		int lastIndex = this.getSize() - 1;
	    BufferedImage bi = imageStack.get(lastIndex);
	    return bi;
	}
	
	public boolean isEmpty() {
		if (imageStack.isEmpty())
			return true;
		return false;
	}
	
	public void clearAll() {
		while (!this.isEmpty()) {
			this.pop();
		}
	}
	
	public BufferedImage get(int index) {
		int range = this.getSize() - 1;
		if (index < 0 || index > range) {
			throw new IndexOutOfBoundsException();
		}
		
		return imageStack.get(index);
	}
	
	public int getSize() {
		return imageStack.size();
	}
	
}
