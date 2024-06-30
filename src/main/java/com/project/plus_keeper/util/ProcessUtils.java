package com.project.plus_keeper.util;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import com.project.plus_keeper.response.CommonResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ProcessUtils {

    public static <T> ResponseEntity<CommonResponse<T>> processOptional(Optional<T> optional, Supplier<RuntimeException> exceptionSupplier) {
        if (optional.isPresent()) {
            CommonResponse<T> response = new CommonResponse<>(HttpStatus.OK.value(), "Success", optional.get());
            return ResponseEntity.ok(response);
        } else {
            throw exceptionSupplier.get();
        }
    }

    public static <T> ResponseEntity<CommonResponse<List<T>>> processList(List<T> list) {
        final String SUCCESS_MESSAGE = "Success";
        final String NO_DATA_MESSAGE = "데이터 조회 결과가 존재하지 않습니다.";

        String message = list.isEmpty() ? NO_DATA_MESSAGE : SUCCESS_MESSAGE;
        CommonResponse<List<T>> response = new CommonResponse<>(HttpStatus.OK.value(), message, list);
        return ResponseEntity.ok(response);
    }


}
