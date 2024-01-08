package org.example.database.dao;

import org.example.database.Database;
import org.example.model.StudentEntity;

import java.util.List;

public class StudentDao {

    Database database = new Database();

    public StudentEntity getByEmail(String emailParam){
        return database.executeQueryTransaction(entityManager ->
                entityManager.createQuery("SELECT student FROM StudentEntity student WHERE student.email =:email", StudentEntity.class)
                        .setParameter("email", emailParam)
                        .getSingleResult(), StudentEntity.class);
    }

    public List<StudentEntity> getAll() {
        return  database.executeQueryTransaction(entityManager ->
                entityManager.createQuery("SELECT student FROM StudentEntity student", StudentEntity.class)
                        .getResultList(), List.class);
    }
}
