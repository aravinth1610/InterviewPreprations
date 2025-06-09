package com.logics;

import java.util.ArrayList;

public class CustomeArrayList extends ArrayList<Object> {

	@Override
	public boolean add(Object e) {
		//this referes to current instance 
		if (this.contains(e)) {
			return true;
		} else {
			return super.add(e);
		}
	}

	public static void main(String[] args) {
		
		Integer ds;
			
		CustomeArrayList list = new CustomeArrayList();
		list.add(1);
		list.add(1);
		list.add(2);
		
		System.out.println(list);
	}
}
