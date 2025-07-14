import org.example.Calculator;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class DemoRepeatedTest {

    private Calculator calculator;

    @BeforeEach
    void beforeEachMethod(){
        calculator = new Calculator();
        System.out.println("Executing BeforeEach method");
    }

    @DisplayName("Integer/0 return ArithmeticException")
    @RepeatedTest(3)
    void testIntegerDivision_WhenDivisorIsZero_ShouldReturnArithmeticExpection(
            RepetitionInfo repetitionInfo, TestInfo testInfo){
        System.out.println("Executing IntegerDivisionByZero method");
        System.out.println("Running " + testInfo.getTestMethod().get().getName());
        System.out.println("Repetition #" + repetitionInfo.getCurrentRepetition() + " of "
          + repetitionInfo.getTotalRepetitions());

//        Arrange
        int dividend = 4;
        int divisior = 0;
//        Act & Assert
        assertThrows(ArithmeticException.class, ()->{
                    calculator.integerDivision(dividend, divisior);
                },
                "Divided by zero should throw Arithmetic Exception");

    }
}
