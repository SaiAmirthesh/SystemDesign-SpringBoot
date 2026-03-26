package com.SaiAmirthesh.URLShortner.Repository;

import com.SaiAmirthesh.URLShortner.model.UrlMapping;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UrlRepository extends JpaRepository<UrlMapping,String> {
}
