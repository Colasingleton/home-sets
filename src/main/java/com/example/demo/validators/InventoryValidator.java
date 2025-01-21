package com.example.demo.validators;

import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.service.ProductService;
import com.example.demo.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 *
 *
 *
 */
public class InventoryValidator implements ConstraintValidator<ValidInventory, Part> {
    @Autowired
    private ApplicationContext context;
    public static  ApplicationContext myContext;
    @Override
    public void initialize(ValidInventory constraintAnnotation) {
        //ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Part part, ConstraintValidatorContext constraintValidatorContext) {
        //Cola's code block start

        if (part.getInv() > part.getMaxInv()) {
            constraintValidatorContext.buildConstraintViolationWithTemplate("Solution: Inventory is greater than max inventory. Please make it lower.").addConstraintViolation();
            return false;
        } else if (part.getInv() < part.getMinInv()) {
            constraintValidatorContext.buildConstraintViolationWithTemplate("Solution: Please add value greater than zero.").addConstraintViolation();
            return false;

        }

        //Cola's block end
        return true;

    }
}


