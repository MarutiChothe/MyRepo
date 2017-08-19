package com.sreenutech.demo;
 
 
public interface CardDAO {
 
    @SuppressWarnings("rawtypes")
	public boolean validateCard(long cardno); 
}