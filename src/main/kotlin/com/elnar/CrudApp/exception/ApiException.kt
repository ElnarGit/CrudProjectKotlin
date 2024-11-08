package com.elnar.CrudApp.exception

open class ApiException(message : String, val errorCode : String) : RuntimeException(message)
