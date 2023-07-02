package com.jarang.controller

import com.jarang.entity.Member
import com.jarang.service.MemberService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RequestMapping("/member")
@RestController
class MemberController(
    private val memberService: MemberService
) {
    @GetMapping("/{no}")
    suspend fun getMember(@PathVariable no: Long): Member {
        return memberService.findMember(no)
    }

    @PostMapping("/{no}")
    suspend fun createMember(@PathVariable no: Long): Mono<Member> {
        return memberService.createMember(no)
    }
}