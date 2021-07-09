package vn.codegym.concern;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Aspect
public class Logger {
    private int numberView=0;

    @Pointcut("within(vn.codegym.controller.BookController)")
    public void allMethodBookController(){}

    @AfterReturning("allMethodBookController()")
    public void afterAllMethod(){
        numberView++;
        System.err.println("Số người thao tác với trang: " + numberView);
    }

    @AfterReturning("execution(* vn.codegym.controller.BookController.rent(..))")
    public void rentBook(){
        System.err.println("Có người thuê sách. Thời gian: " + new Date());
    }

    @AfterReturning("execution(* vn.codegym.controller.BookController.returnBook(..))")
    public void returnBook(){
        System.err.println("Có người trả sách. Thời gian: " + new Date());
    }

    @AfterThrowing("execution(* vn.codegym.controller.BookController.rent(..))")
    public void rentException(){
        System.err.println("Xảy ra lỗi khi thuê sách. Thời gian: " + new Date());
    }

    @AfterThrowing("execution(* vn.codegym.controller.BookController.returnBook(..))")
    public void returnBookException(){
        System.err.println("Xảy ra lỗi khi trả sách. Thời gian: " + new Date());
    }
}
