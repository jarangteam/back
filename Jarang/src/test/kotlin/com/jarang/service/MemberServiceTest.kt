package com.jarang.service

import com.jarang.entity.Member
import com.jarang.repository.MemberRepository
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import io.mockk.coEvery
import io.mockk.junit5.MockKExtension
import io.mockk.mockk
import org.junit.jupiter.api.extension.ExtendWith
import reactor.core.publisher.Mono
import java.util.*

@ExtendWith(MockKExtension::class)
class MemberServiceTest: BehaviorSpec(
    {
        val memberRepository = mockk<MemberRepository>(relaxed = true)
        val memberService = MemberService(memberRepository)

        Given("given") {
            coEvery { memberRepository.findById(1) } returns Mono.just(Member.toDefaultMember(1))

            When("when") {
                val member = memberService.findMember(1)

                Then("then") {
                    member.name.length shouldBe UUID.randomUUID().toString().length
                }
            }
        }
    }
)