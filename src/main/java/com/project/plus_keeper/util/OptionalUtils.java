package com.project.plus_keeper.util;

import java.util.Optional;
import java.util.function.Supplier;
import org.springframework.http.ResponseEntity;

public class OptionalUtils {

    public static <T> ResponseEntity<T> processOptional(Optional<T> optional, Supplier<RuntimeException> exceptionSupplier) {
        if (optional.isPresent()) {
            return ResponseEntity.ok(optional.get());
        } else {
            throw exceptionSupplier.get();
        }
    }
}
