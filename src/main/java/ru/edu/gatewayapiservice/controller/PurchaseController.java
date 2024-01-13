package ru.edu.gatewayapiservice.controller;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import ru.edu.gatewayapiservice.request.PurchaseServiceRequest;
import ru.edu.gatewayapiservice.security.CustomUserPrincipal;

@RestController
@RequestMapping("/gateway/purchase")
@AllArgsConstructor
@Log
public class PurchaseController {

    private final PurchaseServiceRequest purchaseServiceRequest;

    @PostMapping
    public ResponseEntity<?> savePurchase(@RequestBody Object purchase) {
        return new ResponseEntity<>(purchaseServiceRequest.savePurchase(purchase), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> getAllPurchaseOfAuthorizedUser(@AuthenticationPrincipal CustomUserPrincipal customUserPrincipal) {
        return ResponseEntity.ok(purchaseServiceRequest.getAllPurchaseOfUser(customUserPrincipal.getId()));
    }
}
