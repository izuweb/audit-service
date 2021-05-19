package com.envel.audit

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication



@SpringBootApplication
class AuditServiceApplication

fun main(args: Array<String>) {
    runApplication<AuditServiceApplication>(*args)
}
