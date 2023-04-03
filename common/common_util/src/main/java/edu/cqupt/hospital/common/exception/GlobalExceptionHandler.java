package edu.cqupt.hospital.common.exception;

import edu.cqupt.hospital.common.result.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author LWenH
 * @create 2023/4/3 - 16:42
 *
 * 全局异常处理器
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public Result error(Exception e) {
        e.printStackTrace();
        return Result.fail();
    }

    @ExceptionHandler(CustomException.class)
    public Result error(CustomException e) {
        e.printStackTrace();
        return Result.fail();
    }
}
