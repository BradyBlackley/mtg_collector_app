package com.example.mtg.repository.repositoryInterfaces;

import com.example.mtg.model.Type;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface TypeRepository {
    List<Type> findAllTypes();

    Type findTypeByName(String typeName);

    Type add(Type type);

    boolean update(Type type);

    @Transactional
    boolean delete(Type type);
}
