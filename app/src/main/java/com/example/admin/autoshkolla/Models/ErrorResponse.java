package com.example.admin.autoshkolla.Models;

/**
 * Created by herolindsopjani on 12/26/16.
 */

public class ErrorResponse {
    public String message = "";
    Error error;

    public static ErrorResponse create(String message) {
        ErrorResponse e = new ErrorResponse();
        e.message = message;
        return  e;
    }
}
