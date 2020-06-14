package hello.services;

import hello.dao.UserDAOImpl;
import hello.models.User;

import java.sql.SQLException;
import java.util.List;

public class UserService {
    private UserDAOImpl userDAO = new UserDAOImpl();

    public UserService() {
    }

    public User getUserBuId(Long id) throws SQLException {
        return userDAO.getUserBuId(id);
    }

    public void addUser(User user) throws SQLException {
        userDAO.addUser(user);
    }

    public void deleteUser(User user) throws SQLException {
        userDAO.deleteUser(user);
    }

    public void updateUser(Long id, User user) throws SQLException {
        userDAO.updateUser(id, user);
    }

    public List<User> getAllUsers() throws SQLException {
        return userDAO.getAllUsers();
    }

    public void script(){
        userDAO.script();
    }

}
