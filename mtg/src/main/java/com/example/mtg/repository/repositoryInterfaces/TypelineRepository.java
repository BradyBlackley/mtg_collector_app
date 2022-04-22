package com.example.mtg.repository.repositoryInterfaces;

import com.example.mtg.model.Typeline;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface TypelineRepository {
    List<Typeline> findAll();

    Typeline findByTypelineId(int typelineId);

    Typeline add(Typeline typeline);

    boolean update(Typeline typeline);

    @Transactional
    boolean delete(int typelineId);
}
