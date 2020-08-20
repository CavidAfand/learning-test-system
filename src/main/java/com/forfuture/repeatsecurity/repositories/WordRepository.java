package com.forfuture.repeatsecurity.repositories;

import com.forfuture.repeatsecurity.entities.Word;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WordRepository extends JpaRepository<Word, String> {

    Word findByDefinition(String definition);

}
