package com.leysoft.project.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.leysoft.project.model.ImagenModel;

@Component("imagenValidator")
public class ImagenValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return ImagenModel.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		ImagenModel imagen = (ImagenModel) obj;
		if(imagen.getFile() != null) {
			if(imagen.getFile().isEmpty()) {
				errors.rejectValue("file", "imagen.file", "No puede estar vacio");
			}
			if(imagen.getFile().getSize() > 1024*1024*10) {
				errors.rejectValue("file", "imagen.file", "No puede superar los 10MB");
			}
			if(!imagen.getFile().getContentType().contains("image")) {
				errors.rejectValue("file", "imagen.file", "Debe ser de tipo image");
			}
		} else {
			errors.rejectValue("file", "imagen.file", "No puede ser null");
		}
	}
}