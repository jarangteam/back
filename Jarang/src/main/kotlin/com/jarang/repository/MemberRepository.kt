package com.jarang.repository

import com.jarang.entity.Member
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository

@Repository
interface MemberRepository: ReactiveMongoRepository<Member, Long> {
}