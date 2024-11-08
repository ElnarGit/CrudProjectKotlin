package com.elnar.CrudApp.exception

class NotFoundException(message: String, errorCode : String) :
    ApiException(message, errorCode)