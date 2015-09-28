import java.util.ArrayList;
import java.util.List;

public class FindExpression {
    public static final int inputvalue = -290;

    public static void main(String[] args) {

        stack op1 = new stack();
        stack op2 = new stack();
        stack op3 = new stack();
        stack op4 = new stack();
        stack op5 = new stack();
        stack op6 = new stack();
        stack op7 = new stack();
        stack op8 = new stack();


         String[] operators = {"+", "-", "%"};
         String[] numbers = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
         stack numberStack = new stack();
         numberStack = populateStack(numberStack, numbers);
         stack operatorStack = new stack();
         operatorStack = populateStack(operatorStack, operators);
        stack reversenumber = new stack();
        reversenumber.copyStack(numberStack);
        while (!numberStack.isEmpty())
            numberStack.pop();
        while (!reversenumber.isEmpty()) {
            numberStack.push(reversenumber.pop());
        }
        stack expression = new stack();


        create_OperatorStacks(op1, operatorStack, 1, 3);
        create_OperatorStacks(op2, operatorStack, 3, 9);
        create_OperatorStacks(op3, operatorStack, 9, 27);
        create_OperatorStacks(op4, operatorStack, 27, 81);
        create_OperatorStacks(op5, operatorStack, 81, 243);
        create_OperatorStacks(op6, operatorStack, 243, 729);
        create_OperatorStacks(op7, operatorStack, 729, 2187);
        create_OperatorStacks(op8, operatorStack, 2187, 6561);
        List<stack> stacks = new ArrayList();
        stacks.add(0, op1);
        stacks.add(1, op2);
        stacks.add(2, op3);
        stacks.add(3, op4);
        stacks.add(4, op5);
        stacks.add(5, op6);
        stacks.add(6, op7);
        stacks.add(7, op8);
        stacks.add(8, numberStack);
        boolean found = find_expression(expression, stacks);
        if (!found) {

            System.out.println("Input Value Provided : " + inputvalue);
            System.out.println("Expression Cannot be Made!!");
        }
     }

    public static void printStack(stack printstack) {
        stack tempstack = new stack();
        tempstack.copyStack(printstack);
        while (!printstack.isEmpty())
            System.out.println(printstack.pop());

        printstack.copyStack(tempstack);

    }

    public static void printStackLine(stack printstack) {
        stack tempstack = new stack();
        tempstack.copyStack(printstack);
        String temp = "";
        while (!printstack.isEmpty())
            temp = temp + printstack.pop();
        System.out.println(temp);
        printstack.copyStack(tempstack);

    }
    public static boolean find_expression(stack expression, List<stack> stacks) {
        stack number_stack = new stack();
        number_stack.copyStack(stacks.get(8));

        while (!stacks.get(7).isEmpty()) {
            expression.push(stacks.get(8).pop());
            expression.push(stacks.get(0).pop());
            expression.push(stacks.get(8).pop());
            expression.push(stacks.get(1).pop());
            expression.push(stacks.get(8).pop());
            expression.push(stacks.get(2).pop());
            expression.push(stacks.get(8).pop());
            expression.push(stacks.get(3).pop());
            expression.push(stacks.get(8).pop());
            expression.push(stacks.get(4).pop());
            expression.push(stacks.get(8).pop());
            expression.push(stacks.get(5).pop());
            expression.push(stacks.get(8).pop());
            expression.push(stacks.get(6).pop());
            expression.push(stacks.get(8).pop());
            expression.push(stacks.get(7).pop());
            expression.push(stacks.get(8).pop());

            stacks.get(8).copyStack(number_stack);
            //printStackLine(expression);
            int outval = evaluateExpression(expression);

            if (inputvalue == outval) {
                String final_expression = "";
                while (!expression.isEmpty()) {
                    final_expression = final_expression + expression.pop();
                }
                System.out.println("Input Value Provided : " + inputvalue);
                System.out.println("Expression Found : " + final_expression);
                return true;
            }
            expression.clear();
        }
        return false;
    }

    public static void create_OperatorStacks(stack op1, stack operatorStack, int operatorFrequency, int stackFrequency) {
        int final_value = (int) Math.pow(3, 8);

        stack copyOperator = new stack();

        for (int counter = 1; counter <= (final_value / stackFrequency); counter++) {

            copyOperator.copyStack(operatorStack);
            int j = 0;
            int i = 0;
            while (j < 3) {

                String symbol = operatorStack.pop();
                while (i < operatorFrequency) {

                    op1.push(symbol);
                    i++;
                }
                i = 0;
                j++;
            }
            operatorStack.copyStack(copyOperator);

        }


    }

    public static stack populateStack(stack stack1, String[] values) {
        while (!stack1.isEmpty())
            stack1.pop();

        for (String i : values) {
            if (i != null)
            stack1.push(i);
        }
        return stack1;
    }

    public static int evaluateExpression(stack expression) {
        int total = 0;

        String temp = "";
        stack parsed = new stack();
        int i = 0;
        while (!expression.isEmpty()) {
            String current = expression.pop();
            if (current.equals("+") || current.equals("-")) {
                parsed.push(current);
                continue;
            } else if (current.equals("%")) {
                temp = expression.pop() + parsed.pop();
                current = expression.pop();
                if (current.equals("$")) {
                    parsed.push(temp);
                    break;
                }

                while (current.equals("%")) {
                    temp = expression.pop() + temp;
                    current = expression.pop();
                }
                if (!current.equals("$"))
                    expression.push(current);

                parsed.push(temp);

                continue;
            } else {
                parsed.push(current);
                continue;
            }

        }

        int first, second = 0;

        expression.copyStack(parsed);
        /*String tempparsed="";
        while(!parsed.isEmpty()) {
         tempparsed=tempparsed+parsed.pop();
        }
        System.out.println(tempparsed);
        parsed.copyStack(expression);*/
        String symbol;
        while (!parsed.isEmpty() && parsed.size() > 1) {
            first = Integer.parseInt(parsed.pop());
            symbol = parsed.pop();
            second = Integer.parseInt(parsed.pop());
            if (symbol.equals("+")) {
                total = first + second;
                parsed.push("" + total);
            } else {
                total = first - second;
                parsed.push("" + total);
            }

        }
        if (parsed.size() == 1) {
            total = Integer.parseInt(parsed.pop());
        }

        return total;
    }

}
