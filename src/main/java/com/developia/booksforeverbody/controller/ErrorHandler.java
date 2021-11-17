package com.developia.booksforeverbody.controller;

import com.developia.booksforeverbody.exception.NotFoundException;
import com.developia.booksforeverbody.exception.UsernameOrPasswordIncorrectException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ModelAndView handler(HttpServletRequest request,NotFoundException ex){
        ModelAndView mv=new ModelAndView();

        mv.setViewName("error-page");
        mv.addObject("details",ex.getMessage());
        mv.addObject("path",request.getRequestURL());

        return mv;
    }

    @ExceptionHandler(UsernameOrPasswordIncorrectException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ModelAndView handler(HttpServletRequest request,UsernameOrPasswordIncorrectException ex){
        ModelAndView mv=new ModelAndView();

        mv.setViewName("error-page");
        mv.addObject("details",ex.getMessage());

        return mv;
    }
}
