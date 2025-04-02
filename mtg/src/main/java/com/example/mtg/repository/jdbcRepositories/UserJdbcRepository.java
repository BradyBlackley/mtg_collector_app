package com.example.mtg.repository.jdbcRepositories;

import com.example.mtg.model.User;
import com.example.mtg.repository.mappers.UserMapper;
import com.example.mtg.repository.repositoryInterfaces.UserRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserJdbcRepository implements UserRepository {

    private final JdbcTemplate jdbcTemplate;

    public UserJdbcRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<User> findAll() {
        final String sql = "select user_id, username, `password`, is_admin from `user`;";
        return jdbcTemplate.query(sql, new UserMapper());
    }

    @Override
    public User findByUsername(String username) {
        final String sql = "select user_id, username, `password`, is_admin from `user`" +
                "where username = ?;";
        return jdbcTemplate.query(sql, new UserMapper(), username).stream().findFirst().orElse(null);
    }

    @Override
    public User findById(String userId) {
        final String sql = "select user_id, username, `password`, is_admin from `user`" +
                "where user_id = ?;";
        return jdbcTemplate.query(sql, new UserMapper(), userId).stream().findFirst().orElse(null);
    }

    @Override
    public User add(User user) {

        user.setUserId(java.util.UUID.randomUUID().toString());
        user.setPassword(String.valueOf(user.getPassword().hashCode()));
        String isAdmin = isAdminToString(user.isAdmin());


        final String sql = "insert into `user` (user_id, username, `password`, is_admin)" +
                " values (?,?,?,?);";

        jdbcTemplate.update(sql, user.getUserId(), user.getUsername(), user.getPassword(), isAdmin);

        return user;
    }

    @Override
    public boolean update(User user) {

        user.setPassword(String.valueOf(user.getPassword().hashCode()));
        String isAdmin = isAdminToString(user.isAdmin());

        final String sql = "update `user` set " +
                "username = ?, " +
                "`password` = ?, " +
                "is_admin = ? " +
                "where user_id = ?;";

        return jdbcTemplate.update(sql,
                user.getUsername(),
                user.getPassword(),
                isAdmin,
                user.getUserId()) > 0;
    }

    @Override
    public boolean deleteById(String userId) {

        final String sql = "delete from `user` where user_id = ?; ";
        return jdbcTemplate.update(sql, userId) > 0;
    }

    private String isAdminToString(Boolean isAdmin) {
        if(isAdmin) {
            return "Y";
        } else {
            return "N";
        }
    }
}
