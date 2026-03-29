package com.SaiAmirthesh.URLShortner.Repository;

import com.SaiAmirthesh.URLShortner.model.UrlMapping;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UrlRepository extends JpaRepository<UrlMapping,Long> {
    Optional<UrlMapping> findByshortCode(String shortCode);

    boolean existsByshortCode(String shortCode);

    void deleteByshortCode(String shortCode);
}
