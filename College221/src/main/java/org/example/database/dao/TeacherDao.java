package org.example.database.dao;

import org.example.database.Database;
import org.example.model.StudentEntity;
import org.example.model.TeacherEntity;

public class TeacherDao {

    Database database = new Database();

    public TeacherEntity getByEmail(String emailParam) {
        return database.executeQueryTransaction(entityManager ->
                entityManager.createQuery("SELECT tch FROM TeacherEntity tch WHERE tch.email =:email", TeacherEntity.class)
                        .setParameter("email", emailParam)
                        .getSingleResult(), TeacherEntity.class);
    }
}
