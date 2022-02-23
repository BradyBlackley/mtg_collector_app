package com.example.mtg.repository;

import com.example.mtg.model.Collection;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CollectionRepository {

    Collection findByCollectionId(int collectionId);

    Collection findByUserId(String userId);

    Collection add(Collection collection);

    boolean update(Collection collection);

    @Transactional
    boolean deleteById(String collectionId);

}
