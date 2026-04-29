package com.georgistankov.gairways.ErrorHandling;

import java.time.Instant;

public record ApiError(
        String title,
        int status,
        String detail,
        String path,
        Instant timestamp
) {}