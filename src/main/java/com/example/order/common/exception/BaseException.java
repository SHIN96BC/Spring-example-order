package com.example.order.common.exception;

import com.example.order.common.response.ErrorCode;
import lombok.Getter;

/**
 * BaseException 또는 BaseException 을 확장한 Exception 은
 * 서비스 운영에서 예상이 가능한 Exception 을 표현한다.
 *
 * 그렇기 때문에 http status: 200 이면서 result: FAIL 을 표현하고
 * 특정 ErrorCode 만 alert 를 포함한 모니터링 대상으로 한다.
 */
@Getter
public class BaseException extends RuntimeException {

    private ErrorCode errorCode;

    // 생성자 overloading으로 각 상황에 맞게 예외를 생성할 수 있도록 구성
    public BaseException() {
    }

    // 특정 에러 코드를 기준으로 예외를 던짐
    public BaseException(ErrorCode errorCode) {
        super(errorCode.getErrorMessage());
        this.errorCode = errorCode;
    }

    // 특정 에러 코드와 함께 추가적인 메시지를 제공
    public BaseException(String message, ErrorCode errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    // 특정 에러 코드와 함께 추가적인 메시지와 원인이 되는 예외를 제공
    public BaseException(String message, ErrorCode errorCode, Throwable cause) {
        super(message, cause);
        this.errorCode = errorCode;
    }
}
