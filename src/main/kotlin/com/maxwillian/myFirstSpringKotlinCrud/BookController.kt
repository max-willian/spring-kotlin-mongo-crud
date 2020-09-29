package com.maxwillian.myFirstSpringKotlinCrud

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.lang.RuntimeException

@RestController

@RequestMapping("books")
class BookController(val repository: BookRepository) {

    @PostMapping
    fun create(@RequestBody book: Book) = ResponseEntity.ok(repository.save(book))

    @GetMapping
    fun read() = ResponseEntity.ok(repository.findAll())

    @PutMapping("{code}")
    fun update(@PathVariable code: String, @RequestBody book: Book): ResponseEntity<Book> {
        val toSave = repository.findByCode(code)
                .orElseThrow { RuntimeException("Book $code not found!") }
                .copy(name = book.name, author = book.author, code = book.code, price = book.price)

        return ResponseEntity.ok(repository.save(toSave))
    }

    @DeleteMapping("{code}")
    fun delete(@PathVariable code: String) = repository
            .findByCode(code)
            .ifPresent{ repository.delete(it) }
}