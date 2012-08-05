package be.glimmo.service.conversion;

import org.springframework.binding.convert.service.DefaultConversionService;
import org.springframework.stereotype.Service;

import be.glimmo.converters.CustomStringToDate;

@Service("customConversionService")
public class CustomConversionService extends DefaultConversionService{
	
	@Override
	protected void addDefaultConverters() {
		super.addDefaultConverters();
		
		addConverter(new CustomStringToDate());
	}
}
