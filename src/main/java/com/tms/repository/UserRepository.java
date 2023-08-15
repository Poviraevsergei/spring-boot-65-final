package com.tms.repository;

import com.tms.domain.UserInfo;
import jakarta.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {

    public final SessionFactory sessionFactory;

    public UserRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    //Read
    public UserInfo findById(int id) {
        UserInfo userInfo = null;
        Session session = sessionFactory.openSession();
        Query<UserInfo> query = session.createQuery("FROM user_info u WHERE u.id =: userId", UserInfo.class);
        query.setParameter("userId", id);
        List<UserInfo> resultList = query.getResultList();
        session.close();

        if (resultList != null && !resultList.isEmpty()) {
            userInfo = resultList.get(0);
        }
        return userInfo;
    }

    //Read HQL
    public List<UserInfo> findAll() {
        Session session = sessionFactory.openSession();
        Query<UserInfo> query = session.createQuery("FROM user_info", UserInfo.class);
        List<UserInfo> resultList = query.getResultList();
        session.close();
        return resultList;
    }

    //Create
    public void save(UserInfo userInfo) {
        //не можем использовать Query для сохранения, только если перенести из другой таблицы
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(userInfo);
        session.getTransaction().commit();
        session.close();
    }

    //Update
    public void updateUser(UserInfo userInfo) {
        Session session = sessionFactory.openSession();
        Query<UserInfo> query = session.createQuery("UPDATE user_info SET firstName=:firstName, " +
                "lastName=:lastName, updatedAt=:updatedAt, role=:role WHERE id=:id");
        query.setParameter("id", userInfo.getId());
        query.setParameter("firstName", userInfo.getFirstName());
        query.setParameter("lastName", userInfo.getLastName());
        query.setParameter("updatedAt", userInfo.getUpdatedAt());
        query.setParameter("role", userInfo.getRole());

        session.beginTransaction();
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
    }

    //Delete
    public void delete(UserInfo userInfo) {
        Session session = sessionFactory.openSession();
        Query<UserInfo> query = session.createQuery("DELETE user_info WHERE id=:id");
        query.setParameter("id", userInfo.getId());

        session.beginTransaction();
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
    }
}