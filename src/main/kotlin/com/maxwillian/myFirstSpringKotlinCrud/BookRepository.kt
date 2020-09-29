package com.maxwillian.myFirstSpringKotlinCrud

import org.springframework.data.mongodb.repository.MongoRepository
import java.util.*

interface BookRepository: MongoRepository<Book, String> {

    fun findByCode(code: String): Optional<Book>

}