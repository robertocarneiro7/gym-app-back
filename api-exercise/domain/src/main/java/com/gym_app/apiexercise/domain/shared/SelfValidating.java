package com.gym_app.apiexercise.domain.shared;

import com.gym_app.apiexercise.domain.shared.exception.BusinessException;
import jakarta.validation.*;

import java.util.Set;

public class SelfValidating<T> {

    private Validator validator;

    protected SelfValidating() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    /**
     * Evaluates all Bean Validations on the attributes of this
     * instance.
     */
    public void validateSelf() {
        Set<ConstraintViolation<T>> violations = validator.validate((T) this);
        if (!violations.isEmpty()) {
            ConstraintViolationException exception = new ConstraintViolationException(violations);
            throw new BusinessException(exception.getMessage());
        }
    }
}
