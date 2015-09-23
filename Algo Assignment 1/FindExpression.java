
public class FindExpression {

     public static void main(String []args){

         String[] operators = {"+", "-", "%"};
         String[] numbers = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
         stack numberStack = new stack();
         numberStack = populateStack(numberStack, numbers);
         stack operatorStack = new stack();
         operatorStack = populateStack(operatorStack, operators);
         while (!numberStack.isEmpty()) {
             System.out.println("Popped Number : " + numberStack.pop() + operatorStack.pop());

         }


     }

    public static stack populateStack(stack stack1, String[] values) {
        while (!stack1.isEmpty())
            stack1.pop();

        for (String i : values) {
            stack1.push(i);
        }
        return stack1;
    }

    public static int evaluateExpression(stack expression) {
        int total = 0;
        String prev = "";
        String temp = "";
        String[] parsed;
        while (!expression.isEmpty()) {


        }
        return total;
    }

}
