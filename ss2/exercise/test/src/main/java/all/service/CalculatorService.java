package all.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService implements ICalculatorService {
    public String check(double num1,double num2,String operator){
        if(num2==0){
            return "khong chia cho 0";
        }else {
            return String.valueOf(calculator(num1,num2,operator));
            
        }
    }

    @Override
    public double calculator(double num1, double num2, String operator) {
        double result = 0;
        switch (operator) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                    result = num1 / num2;
                break;
        }
        return result;
    }
}

