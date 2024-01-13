package ru.edu.gatewayapiservice.request;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import ru.edu.gatewayapiservice.config.FeignConfiguration;

import java.util.List;

@FeignClient(value = "book-service", // name of service
        path = "/api/book",
        configuration = FeignConfiguration.class)
public interface BookServiceRequest {
    @PostMapping//api/book
    Object saveBook(@RequestBody Object requestBody);

    @DeleteMapping("{bookId}") //api/book/{bookId}
    void deleteBook(@PathVariable("bookId") Long bookId);

    @GetMapping//api/book
    List<Object> getAllBooks();
}
