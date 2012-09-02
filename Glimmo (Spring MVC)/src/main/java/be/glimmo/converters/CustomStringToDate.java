package be.glimmo.converters;

import org.springframework.binding.convert.converters.StringToDate;

public class CustomStringToDate extends StringToDate{
	
	public CustomStringToDate(){
		super();
		setPattern("dd/MM/yyyy");
	}
}
