package com.example.demo.validators;

import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.service.ProductService;
import com.example.demo.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 *
 *
 *
 */

public class InventoryValidator implements ConstraintValidator<ValidInventory, Object> {
    @Autowired
    private ApplicationContext context;
    public static  ApplicationContext myContext;
    @Override
    public void initialize(ValidInventory constraintAnnotation) {
        //ConstraintValidator.super.initialize(constraintAnnotation);
    }



    //Cola's block start
        @Override
        public boolean isValid(Object object, ConstraintValidatorContext context) {
            if (object instanceof Part part) {
                return validateInventory(part.getInv(), part.getMinInv(), part.getMaxInv(), context);
            } else if (object instanceof Product product) {
                return validateInventory(product.getInv(), product.getMinInv(), product.getMaxInv(), context);
            }
            return true; // Default to valid for unsupported types
        }

    private boolean validateInventory(int inv, int minInv, int maxInv, ConstraintValidatorContext context) {
        if (inv > maxInv) {
            context.buildConstraintViolationWithTemplate("Solution: Inventory is greater than max inventory. Please make it lower.")
                    .addConstraintViolation();
            return false;
        } else if (inv < minInv) {
            context.buildConstraintViolationWithTemplate("Solution: Please add value greater than zero.")
                    .addConstraintViolation();
            return false;
        }



        return true;
//Cola's block end
    }
}


