package com.example.mtg.repository;

import com.example.mtg.model.Collection;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CollectionRepository {
    List<Collection> findAll();

    Collection findById(int collectionId);

    Collection add(Collection collection);

    boolean update(Collection collection);

    @Transactional
    boolean deleteById(String collectionId);

}
