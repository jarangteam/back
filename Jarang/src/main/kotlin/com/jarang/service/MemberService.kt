package com.jarang.service

import com.jarang.entity.Member
import com.jarang.repository.MemberRepository
import mu.KotlinLogging
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class MemberService(
    private val memberRepository: MemberRepository
) {
    private val logger = KotlinLogging.logger {}

    suspend fun createMember(no: Long): Mono<Member> {
        val defaultMember = Member.toDefaultMember(no)
        return memberRepository.save(defaultMember)
    }

    suspend fun findMember(no: Long): Member {
        val member = memberRepository.findById(no)
        logger.info { member }
        return Member.toDefaultMember(no)
    }
}