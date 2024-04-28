package com.geekster.Backend_Traini8_KevinRoland.controller;

import com.geekster.Backend_Traini8_KevinRoland.model.TrainingCenter;
import com.geekster.Backend_Traini8_KevinRoland.service.Trainingcenterservice;
import io.swagger.v3.core.util.Json;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
@Validated
public class TrainingCenterController {
    @Autowired
    Trainingcenterservice trainingCenter;

    //This api is responsible for posting multiple Trainingcenters as a list
    @PostMapping("addlistoftrainingcenters")
    public ResponseEntity<Object> addListOfTrainingCenter(@Valid @RequestBody List<TrainingCenter> newtrainingcenter) {
        String result = trainingCenter.addTrainingCenter(newtrainingcenter);
        return ResponseEntity.ok(newtrainingcenter.get(newtrainingcenter.size()-1));
    }


    //This api is responsible for posting single training center
    @PostMapping("trainingcenter")
    public ResponseEntity<Object> TrainingCenter(@Valid @RequestBody TrainingCenter newtrainingcenter) {
         trainingCenter.addSingleTrainingCenter(newtrainingcenter);
        return ResponseEntity.ok(newtrainingcenter);
    }



//    This get api is responsible for getting all the saved training centers from the database and returns a list
    @GetMapping("trainingcenter")
    public List<TrainingCenter> getAllTrainingcenter(){
        return trainingCenter.getAllTrainingCenter();
    }




//    below i provided exception handling for validations
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationException(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Map<String, String>> handleConstraintViolationException(ConstraintViolationException ex) {
        Map<String, String> errors = new HashMap<>();
        Set<ConstraintViolation<?>> violations = ex.getConstraintViolations();
        for (ConstraintViolation<?> violation : violations) {
            String propertyPath = violation.getPropertyPath().toString();
            String errorMessage = violation.getMessage();
            errors.put(propertyPath, errorMessage);
        }
        return ResponseEntity.badRequest().body(errors);
    }



}
