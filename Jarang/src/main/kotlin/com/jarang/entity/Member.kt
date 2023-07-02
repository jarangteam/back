package com.jarang.entity

import jakarta.validation.constraints.NotBlank
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*

@Document(value = "member")
data class Member(
    @Id
    val no: Long? = null,

    @NotBlank
    var name: String,

    @NotBlank
    var email: String,
) {
    companion object {
        fun toDefaultMember(no: Long): Member {
            return Member(no, UUID.randomUUID().toString(), UUID.randomUUID().toString())
        }
    }
}