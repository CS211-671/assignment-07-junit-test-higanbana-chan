package ku.cs.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentListTest {
    StudentList studentList;
//    Student s1;
//    Student s2;

    @BeforeEach
    void init() {
        studentList = new StudentList();
//        s1 = new Student("6100000", "a");
//        s2 = new Student("6100001", "b", 60);
    }

    @Test
    void testAddNewStudent() {
        assertNull(studentList.findStudentById("6100000"));
        studentList.addNewStudent("6100000", "a");
        assertNotNull(studentList.findStudentById("6100000"));
        studentList.addNewStudent("6100001", "b", 60);
        assertNotNull(studentList.findStudentById("6100001"));
        studentList.addNewStudent("6100000", "a");
    }

    @Test
    void testFindStudentById() {
        assertNull(studentList.findStudentById("6100000"));
        studentList.addNewStudent("6100000", "a");
        assertNotNull(studentList.findStudentById("6100000"));
    }

    @Test
    void testGiveScoreToId() {
        studentList.addNewStudent("6100000", "a", 50);
        assertEquals(studentList.findStudentById("6100000").getScore(), 50);
        studentList.giveScoreToId("6100000", 20);
        assertEquals(studentList.findStudentById("6100000").getScore(), 70);
    }

    @Test
    void testViewGradeOfId() {

    }
}