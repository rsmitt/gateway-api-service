package ru.edu.gatewayapiservice.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.edu.gatewayapiservice.request.BookServiceRequest;

@RestController
@RequestMapping("/gateway/book")
@AllArgsConstructor
public class BookController {

    private final BookServiceRequest bookServiceRequest;

    @PostMapping
    public ResponseEntity<?> saveBook(@RequestBody Object book) {
        return new ResponseEntity<>(bookServiceRequest.saveBook(book), HttpStatus.CREATED);
    }

    @DeleteMapping("/{bookId}")//gateway/book/{bookId}
    public ResponseEntity<?> deleteBook(@PathVariable Long bookId) {
        bookServiceRequest.deleteBook(bookId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getAllBooks() {
        return ResponseEntity.ok(bookServiceRequest.getAllBooks());
    }
}
