package com.example.mtg.repository;

import com.example.mtg.model.Color;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ColorRepository {
    List<Color> findAllColors();

    Color findColorById(int colorId);

    Color findColorByName(String colorName);

    Color add(Color color);

    boolean update(Color color);

    @Transactional
    boolean deleteByName(String colorName);
}
