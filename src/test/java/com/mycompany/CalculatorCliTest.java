
package com.mycompany;

import org.mockito.Mockito;
import com.mycompany.Calculator;
import com.mycompany.CalculatorCli;

import java.io.StringReader;
import org.junit.*;

import static org.mockito.Mockito.*;


public class CalculatorCliTest {
    
    private Calculator calculatorMock;
    
    private CalculatorCli calculatorCli;

    @Before
    public void setUp() {
        //создаем тестового дублера
        calculatorMock = Mockito.mock(Calculator.class);
        calculatorCli = new CalculatorCli(calculatorMock);
    }

    @Test
    public void empty_expressions_must_be_skipped() {
        calculatorCli.runInteractiveSession(new StringReader(";\n;   ;;;\t\n;"));
        
        //проверяем что с этим моком не было ни единого взаимодействия
        //то есть ничего калькулятор не отдавалось на калькулирование
        Mockito.verifyZeroInteractions(calculatorMock);
    }


    @Test
    public void each_expression_separated_by_semicolon_must_be_evaluated() {
        calculatorCli.runInteractiveSession(new StringReader("1;2;3;"));

        verify(calculatorMock).calculate("1");
        verify(calculatorMock).calculate("2");
        verify(calculatorMock).calculate("3");
        verifyNoMoreInteractions(calculatorMock);
    }


    @Test
    public void each_expression_separated_by_semicolon_must_be_evaluated_2() {
        when(calculatorMock.calculate("1")).thenReturn(1d);
        when(calculatorMock.calculate("2")).thenReturn(2d);
        when(calculatorMock.calculate("3")).thenReturn(3d);

        calculatorCli.runInteractiveSession(new StringReader("1;2;3;"));
        verify(calculatorMock).calculate("1");
        verify(calculatorMock).calculate("2");
        verify(calculatorMock).calculate("3");
        verifyNoMoreInteractions(calculatorMock);
    }
    
}
