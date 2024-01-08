package org.example;


import org.example.database.dao.StudentDao;
import org.example.database.dao.TeacherDao;
import org.example.model.StudentEntity;
import org.example.model.TeacherEntity;

import java.util.List;
import java.util.Scanner;

public class App
{
    public static void main( String[] args )
    {
        /* PreLogin - Are you Student or Teacher */
        System.out.println("""
            Select your role (insert number):
            1. Teacher;
            2. Student;
        """);
        Scanner readRole = new Scanner(System.in);
        Integer role = readRole.nextInt();

        Scanner readEmail = new Scanner(System.in);
        /* Login */
        System.out.println("Insert you email: ");
        String email = readEmail.nextLine();

        if(role.equals(1)) {
            /* Search for this specific teacher */
            TeacherDao teacherDao = new TeacherDao();
            TeacherEntity teacher = teacherDao.getByEmail(email);

            teacherMenu(teacher);
        } else if(role.equals(2)) {
            /* Search for this specific student */
            StudentDao studentDao = new StudentDao();
            StudentEntity student = studentDao.getByEmail(email);

            studentMenu(student);
        }
    }

    private static void teacherMenu(TeacherEntity teacher) {
        String options = """
                Select your option (as number):
                1. Insert a grade;
                2. View all students;
                3. View all subjects;
                4. Mark as final grade;
                5. close;
                """;
        System.out.println(options);
        Integer option = 0;

        while(!option.equals(5)){
            Scanner readOption = new Scanner(System.in);
            option = readOption.nextInt();

            switch (option) {
                case 1 :
                    break;
                case 2:
                    StudentDao studentDao = new StudentDao();
                    List<StudentEntity> students = studentDao.getAll();
                    students.forEach(System.out::println);
                    break;
                case 3:
                    break;
                case 4:
                    break;
                default:
                    break;
            }
        }
    }

    private static void studentMenu(StudentEntity student) {

    }
}
