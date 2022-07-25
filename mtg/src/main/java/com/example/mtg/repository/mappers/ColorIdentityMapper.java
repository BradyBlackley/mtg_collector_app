package com.example.mtg.repository.mappers;

import com.example.mtg.model.Card;
import com.example.mtg.model.Color;
import com.example.mtg.model.ColorIdentity;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ColorIdentityMapper implements ResultSetExtractor<ColorIdentity> {
    @Override
    public ColorIdentity extractData(ResultSet rs) throws SQLException, DataAccessException {
        if(!rs.next()){
            return null;
        }
        ColorIdentity colorIdentity = new ColorIdentity();
        List<Color> colors = new ArrayList<>();
        Card card = new Card();
        do{
            Color color = new Color();
            color.setColorId(rs.getInt("color_id"));
            color.setColorName(rs.getString("color_name"));
            colors.add(color);
            card.setCardId(rs.getString("card_id"));
        }while(rs.next());
        colorIdentity.setColors(colors);
        colorIdentity.setCard(card);
        return colorIdentity;
    }
}
