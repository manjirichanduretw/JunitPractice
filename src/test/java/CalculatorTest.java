import org.example.Calculator;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test Mathematical Operation with calculator")
public class CalculatorTest {

    private Calculator calculator;

    @BeforeAll
    static void setUp(){
        System.out.println("Executing BeforeAll method");
    }

    @AfterAll
    static void cleanUp(){
        System.out.println("Executing AfterAll method");
    }

    @BeforeEach
    void beforeEachMethod(){
        calculator = new Calculator();
        System.out.println("Executing BeforeEach method");
    }

    @AfterEach
    void afterEachMethod(){
        System.out.println("Executing AfterEach method");
    }
//    test<System Under Test>_<Condition or state change>_<Expected Result>
//integerDivisionTest() before it was like this
    @DisplayName("8/4 = 2")
    @Test
    void testIntegerDivision_whenEightDividedByFour_ShouldReturn2(){
        System.out.println("Executing IntegerDivision method");
//        Calculator calculator = new Calculator();
        int result = calculator.integerDivision(8,4);
        assertEquals(2,result, "integerDivision() does not produce expected value");
    }

//    @Disabled("To be implemented")
    @DisplayName("Integer/0 return ArithmeticException")
    @Test
    void testIntegerDivision_WhenDivisorIsZero_ShouldReturnArithmeticExpection(){
        System.out.println("Executing IntegerDivisionByZero method");
//        Arrange
        int dividend = 4;
        int divisior = 0;
//        Act & Assert
        assertThrows(ArithmeticException.class, ()->{
               calculator.integerDivision(dividend, divisior);
                },
                "Divided by zero should throw Arithmetic Exception");

//        fail("Not Implemented Yet!");
    }

    @DisplayName("11-10 = 1")
    @Test
    void testIntegerSubstraction_whenElevenSubstractedByTen_OneShouldReturn(){

        System.out.println("Executing IntegerSubstraction method");
        int integer1 = 11;
        int integer2 = 10;
        int actualResult = calculator.integerSubstractions(integer1, integer2);
        int expectedResult = 1;

        //get executed always for avoiding and allow to only when fails
//        assertEquals(expectedResult, actualResult, integer1 + " - " + integer2 + " is not equals " + expectedResult);

        //use lambda function to only execute when it gets failed
        assertEquals(expectedResult, actualResult, ()-> integer1 + " - " + integer2 + " is not equals " + expectedResult);

    }

    @DisplayName("Test Integer Subtraction [minuend, subtrahend, expectedResult] ")
    @ParameterizedTest
//    @MethodSource("IntegerSubtractionInputParameters")
//    @MethodSource() // instead of seperate name, can give same name as test menthod and junit detects it
    @CsvSource({
            "33, 1, 32",
            "45, 1, 44",
            "90, 6, 84"
    })  // list of strings accept
    void integerSubstraction(int minuend, int subtrahend, int expectedResult){

        System.out.println(minuend + " - " + subtrahend + " = " + expectedResult);

        int actualresult = calculator.integerSubstractions(minuend, subtrahend);
        assertEquals(expectedResult, actualresult, ()-> minuend + " - " + subtrahend + " did not produce " + expectedResult);
    }

    private static Stream<Arguments> integerSubstraction(){
        return Stream.of(
               Arguments.of(33, 1, 32),
               Arguments.of(54, 1, 53),
               Arguments.of(98, 6, 92)
        );
    }
}
