package hello.dao;

import hello.models.User;

import java.sql.SQLException;
import java.util.Collection;

public interface UserDAO {
    public void addUser(User user) throws SQLException;

    public void updateUser(Long id, User user) throws SQLException;

    public Collection getAllUsers() throws SQLException;

    public void deleteUser(User user) throws SQLException;

    public User getUserBuId(Long id, User user) throws SQLException;
}
