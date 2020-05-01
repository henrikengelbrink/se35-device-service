package se35.device.service.exceptions

import io.micronaut.http.HttpStatus

enum class APIExceptionCode(val httpCode: HttpStatus) {
    CREATE_DEVICE_INVALID_TYPE(HttpStatus.BAD_REQUEST),
    DEVICE_NOT_FOUND(HttpStatus.NOT_FOUND),
}