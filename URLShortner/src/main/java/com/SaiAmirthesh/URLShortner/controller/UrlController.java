package com.SaiAmirthesh.URLShortner.controller;

import com.SaiAmirthesh.URLShortner.model.UrlMapping;
import com.SaiAmirthesh.URLShortner.service.UrlService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UrlController {

    private final UrlService urlService;

    @PostMapping("/shorten")
    public ResponseEntity<?> createShortUrl(@Valid @RequestBody UrlMapping urlMapping, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            bindingResult.getFieldErrors().forEach(error ->
                    errors.put(error.getField(), error.getDefaultMessage()));
            return ResponseEntity.badRequest().body(errors);
        }

        try {
            UrlMapping savedMapping = urlService.createShortUrl(urlMapping.getUrl());
            Map<String, Object> response = new HashMap<>();
            response.put("id", savedMapping.getId());
            response.put("url", savedMapping.getUrl());
            response.put("shortCode", savedMapping.getShortCode());
            response.put("createdAt", savedMapping.getCreatedAt());
            response.put("updatedAt", savedMapping.getUpdatedAt());
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error creating short URL: " + e.getMessage());
        }
    }

    @GetMapping("/shorten/{shortCode}")
    public ResponseEntity<?> getOriginalUrl(@PathVariable String shortCode) {
        Optional<UrlMapping> urlMapping = urlService.getOriginalUrl(shortCode);
        if (urlMapping.isPresent()) {
            UrlMapping mapping = urlMapping.get();
            Map<String, Object> response = new HashMap<>();
            response.put("id", mapping.getId());
            response.put("url", mapping.getUrl());
            response.put("shortCode", mapping.getShortCode());
            response.put("createdAt", mapping.getCreatedAt());
            response.put("updatedAt", mapping.getUpdatedAt());
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @PutMapping("/shorten/{shortCode}")
    public ResponseEntity<?> updateUrl(@PathVariable String shortCode ,@Valid @RequestBody UrlMapping urlMapping, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            bindingResult.getFieldErrors().forEach(error ->
                    errors.put(error.getField(), error.getDefaultMessage()));
            return ResponseEntity.badRequest().body(errors);
        }

        Optional<UrlMapping> updateMapping = urlService.updateShortUrl(shortCode,urlMapping.getUrl());
        if(updateMapping.isPresent()){
            UrlMapping mapping = updateMapping.get();
            Map<String,Object> response = new HashMap<>();
            response.put("id",mapping.getId());
            response.put("url",mapping.getUrl());
            response.put("shortCode",mapping.getShortCode());
            response.put("createdAt",mapping.getCreatedAt());
            response.put("updatedAt",mapping.getUpdatedAt());
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/shorten/{shortCode}")
    public ResponseEntity<Void> deleteShortUrl(@PathVariable String shortCode){
        boolean detected = urlService.deleteUrl(shortCode);
        if(detected){
            return ResponseEntity.noContent().build();
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }


    @GetMapping("/{shortCode}")
    public ResponseEntity<UrlMapping> redirectUrl(@PathVariable String shortCode){
        Optional<UrlMapping> urlMapping = urlService.getOriginalUrl(shortCode);
        if (urlMapping.isPresent()) {
            UrlMapping mapping = urlMapping.get();
            return ResponseEntity.status(HttpStatus.FOUND)
                    .header("Location", mapping.getUrl())
                    .build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/shorten/{shortCode}/stats")
    public ResponseEntity<?> getUrlStats(@PathVariable String shortCode) {
        Optional<UrlMapping> urlMapping = urlService.getUrlStats(shortCode);
        if (urlMapping.isPresent()) {
            UrlMapping mapping = urlMapping.get();
            Map<String, Object> response = new HashMap<>();
            response.put("id", mapping.getId());
            response.put("url", mapping.getUrl());
            response.put("shortCode", mapping.getShortCode());
            response.put("createdAt", mapping.getCreatedAt());
            response.put("updatedAt", mapping.getUpdatedAt());
            response.put("accessCount", mapping.getAccessCount());
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.notFound().build();
        }
    }






}
