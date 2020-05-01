package se35.device.service.exceptions

class APIException(val code: APIExceptionCode) : RuntimeException()
