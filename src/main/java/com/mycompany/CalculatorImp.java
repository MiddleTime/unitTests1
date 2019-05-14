
package com.mycompany;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;


public class CalculatorImp implements Calculator{

    @Override
    public double calculate(String expression) {
        
   //throw new UnsupportedOperationException();
            //return 0;
            //return Double.parseDouble(expression);
            
            
        ScriptEngine scriptEngine = new ScriptEngineManager().getEngineByName("nashorn");
        try {
            defineMathFunctions(scriptEngine);
            return ((Number) scriptEngine.eval(expression)).doubleValue();
        } catch (ScriptException e) {
            throw new IllegalArgumentException("Failed to evaluate expression", e);
        }
       
    }
    private static void defineMathFunctions(ScriptEngine scriptEngine) throws ScriptException {
        for (String function : new String[] {"sin", "cos", "sqrt"}) {
            scriptEngine.eval("function " + function + "(x) { return Java.type('java.lang.Math')." + function + "(x); }");
        }
    }
    
    
}
