package miu.edu.cse.customersystem.exception;

import miu.edu.cse.customersystem.model.Customer;

public class CustomerException extends RuntimeException {
    public CustomerException(String message) {
        super(message);
    }
}
