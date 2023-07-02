package com.jarang.config

import com.jarang.repository.MemberRepository
import com.mongodb.reactivestreams.client.MongoClient
import com.mongodb.reactivestreams.client.MongoClients
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.ReactiveMongoDatabaseFactory
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration
import org.springframework.data.mongodb.core.ReactiveMongoTemplate
import org.springframework.data.mongodb.core.convert.MappingMongoConverter
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories

@Configuration
@EnableReactiveMongoRepositories(
    basePackageClasses = [MemberRepository::class]
)
class MongoConfiguration: AbstractReactiveMongoConfiguration() {
    override fun getDatabaseName(): String {
        return "jarang"
    }

    override fun reactiveMongoClient(): MongoClient {
        return MongoClients.create("mongodb://ec2-54-180-112-147.ap-northeast-2.compute.amazonaws.com:27017");
    }

    override fun reactiveMongoTemplate(
        databaseFactory: ReactiveMongoDatabaseFactory,
        mongoConverter: MappingMongoConverter
    ): ReactiveMongoTemplate {
        return ReactiveMongoTemplate(reactiveMongoClient(), databaseName)
    }
}