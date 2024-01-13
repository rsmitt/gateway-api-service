package ru.edu.gatewayapiservice.request;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import ru.edu.gatewayapiservice.config.FeignConfiguration;

import java.util.List;

@FeignClient(value = "purchase-service", // name of service
        path = "/api/purchase",
        configuration = FeignConfiguration.class)
public interface PurchaseServiceRequest {
    @PostMapping//api/purchase
    Object savePurchase(@RequestBody Object requestBody);

    @GetMapping("{userId}")//api/purchase/{$userId}
    List<Object> getAllPurchaseOfUser(@PathVariable("userId") Long userId);
}
