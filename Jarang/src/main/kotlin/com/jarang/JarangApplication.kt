package com.jarang

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

@SpringBootApplication
@ConfigurationPropertiesScan
class JarangApplication

fun main(args: Array<String>) {
    runApplication<JarangApplication>(*args)
}
