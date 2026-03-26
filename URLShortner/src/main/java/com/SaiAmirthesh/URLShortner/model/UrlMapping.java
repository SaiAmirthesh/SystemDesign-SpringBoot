package com.SaiAmirthesh.URLShortner.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class UrlMapping {
    @Id
    @Column(name="short_code")
    private String short_code;

    @NotBlank(message = "URL is Required")
    @Pattern(regexp = "^(https?://)?([\\da-z.-]+)\\.([a-z.]{2,6})[/\\w .-]*/?$", message = "Invalid URL format")
    @Column(name="original_url",nullable = false)
    private String url;

    @Column(name="created_at",nullable = false)
    private LocalDateTime created_at;

    @Column(name="updated_at",nullable = false)
    private LocalDateTime updated_at;

    @Column(name="access_count")
    private Long access_count;

    public UrlMapping(){
        this.created_at = LocalDateTime.now();
        this.updated_at = LocalDateTime.now();
    }
}
