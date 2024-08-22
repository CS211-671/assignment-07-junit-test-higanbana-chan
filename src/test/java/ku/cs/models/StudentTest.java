package ku.cs.models;

// Assert เป็นการเช็ค
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {
    Student s1;
    Student s2;

    // ทุกครั้งที่มีการเรียก Test จะมาทำ block นี้ก่อนตามชื่อ BeforeEach
    @BeforeEach
    void init() {
        s1 = new Student("6100000", "r", 40);
        s2 = new Student("6100001", "a", 60);
    }

    @Test
    void testAddScore() {
        s1.addScore(50.5);
        assertEquals(50.5, s1.getScore());
        s1.addScore(50);
        assertEquals(100.5, s1.getScore());
    }

    @Test
    void testCalculateScore() {
        assertEquals("F", s1.grade());
        s1.addScore(20); // score = 60
        assertEquals("C", s1.grade());
        s1.addScore(30); // score = 90
        assertEquals("A", s1.grade());
    }

    @Test
    void testChangeName() {
        s1.changeName("e");
        assertEquals("e", s1.getName());
        s1.changeName("f");
        assertEquals("f", s1.getName());
    }

    @Test
    void testIsId() {
        assertEquals("6100000", s1.getId());
        assertEquals("6100001", s2.getId());
        assertNotNull(s1.getId());
        assertNotEquals(s1.getId(), s2.getId());
    }

//    @Test
//    void testEquals() {
//        System.out.println(s1.getClass().getName());
//    }
}