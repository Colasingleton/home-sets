package com.example.demo.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 *
 *
 *
 *
 */
@Constraint(validatedBy = {InventoryValidator.class})
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)

public @interface ValidInventory {
    String message() default "Inventory Error!";
    Class<?> [] groups() default {};
    Class<? extends Payload> [] payload() default {};

}
