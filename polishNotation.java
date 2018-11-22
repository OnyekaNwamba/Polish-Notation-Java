//Author: ONYEKA NWAMBA
import java.util.Scanner;

public class polishNotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the operators");
        System.out.println("for operators +, -, *, and !");
        System.out.println("Leave spaces between all operators and digits " +
                " if using 2 + numbers");
        System.out.print("expression: ");
        System.out.println("value = " + evaluateEXP(scanner));
    }

    //input contains the expression user has entered
    public static int evaluateEXP(Scanner scanner) {
        //checks if there is another digit after current one
        //allows expression to be looked at from right to left
        if (scanner.hasNextInt())
            return scanner.nextInt();

        //if there is another digit after current one then
        //operands and operators are established
        char operator = scanner.next().charAt(0);
        int operand1 = evaluateEXP(scanner);
        int operand2 = 0;
        //only take second operand for factorial if operator is not unary
        if (operator != '!') {
            operand2 = evaluateEXP(scanner);
        }
        return evaluateOP(operator, operand1, operand2);
    }

    //operator has to be one of +, - , * or ! otherwise error is given
    public static int evaluateOP(char operator, int operand1, int operand2) {
        if (operator=='+') {
            return operand1 + operand2;
        } else if(operator=='-') {
            return operand1 - operand2;
        } else if (operator=='*') {
            return operand1 * operand2;
        } else if (operator=='/') {
            return operand1 / operand2;
        } else if (operator=='!') {
            //if ! used then uses factorial method
            return factorial(operand1);
        } else {
            //RunTimeException allows to return an error string in a int "type" method
            throw new RuntimeException("operator not allowed for this language");
        }
    }
    private static int factorial(int n) {
        if(n==1) {
            return 1;
        } else {
            return factorial(n - 1) * n;
        }
    }

}
