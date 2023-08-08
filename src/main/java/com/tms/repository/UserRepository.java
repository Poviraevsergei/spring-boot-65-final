package com.tms.repository;

import com.tms.domain.UserInfo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class UserRepository {
    public final EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
    public final EntityManager entityManager = emf.createEntityManager();

    //CRUD

    //CREATE
    public void save(UserInfo userInfo) {
        entityManager.getTransaction().begin();
        entityManager.persist(userInfo);
        entityManager.getTransaction().commit();
    }

    //DELETE
    public void delete(int id) {
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.find(UserInfo.class, id));
        entityManager.getTransaction().commit();
    }

    //Read
    public UserInfo findById(int id) {
        return entityManager.find(UserInfo.class, id);
    }

    //READ JPQL!
    public List<UserInfo> findAll() {
        return new ArrayList<>();
    }

    //UPDATE
    public void updateUser(UserInfo userInfo) {
        entityManager.getTransaction().begin();
        entityManager.merge(userInfo);
        entityManager.getTransaction().commit();
    }
}
