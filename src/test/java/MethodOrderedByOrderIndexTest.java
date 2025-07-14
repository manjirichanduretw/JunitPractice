import org.junit.jupiter.api.*;

//this is default lifecycle method
//@TestInstance(TestInstance.Lifecycle.PER_METHOD)
//only one instance of test class for every test method
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MethodOrderedByOrderIndexTest {

    StringBuilder str = new StringBuilder("");

    @AfterEach
    void afterEachMethod(){
       System.out.println(str);
    }

    @Order(3)
    @Test
    void testA(){
        System.out.println("Running test A");
        str.append("3");
    }

    @Order(1)
    @Test
    void testB(){
        System.out.println("Running test B");
        str.append("1");
    }

    @Order(2)
    @Test
    void testC(){
        System.out.println("Running test C");
        str.append("2");
    }

    @Order(4)
    @Test
    void testD(){
        System.out.println("Running test D");
        str.append("4");
    }

}
