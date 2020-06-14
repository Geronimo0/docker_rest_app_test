package hello.dao;


import hello.utils.HibernateSessionFactoryUtil;
import hello.models.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.util.List;

public class UserDAOImpl implements UserDAO {
    @Override
    public void addUser(User user) throws SQLException {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(user);
        tx1.commit();
        session.close();
    }

    @Override
    public void updateUser(Long id, User user) throws SQLException {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(user);
        tx1.commit();
        session.close();
    }

    @Override
    public List<User> getAllUsers() throws SQLException {
        String hql = "FROM User";
        List<User> users = (List<User>)  HibernateSessionFactoryUtil
                .getSessionFactory()
                .openSession()
                .createQuery(hql)
                .list()
                ;
        return users;
    }

    @Override
    public void deleteUser(User user) throws SQLException {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(user);
        tx1.commit();
        session.close();
    }

    @Override
    public User getUserBuId(Long id, User user) throws SQLException {
        return null;
    }

    public void script(){
        String hql = "CREATE TABLE users\n" +
                "  (\n" +
                "      Id SERIAL PRIMARY KEY,\n" +
                "      Name CHARACTER VARYING(30),\n" +
                "      Age INTEGER\n" +
                "  )";

        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();

        session.createNativeQuery(hql).executeUpdate();

        tx1.commit();
        session.close();
    }
}
