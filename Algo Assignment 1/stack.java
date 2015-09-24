import java.util.ArrayList;
public class stack{
    private ArrayList stack = new ArrayList();
    private  int top=0;
    public void push(String value){
        stack.add(top, value);
        //System.out.println("Pushed value =="+value);
        top++;
        
    }

    public int size() {
        return top;
    }

    public void copyStack(stack copyFrom) {
        stack temp_stack = new stack();
        while (!copyFrom.isEmpty()) {
            temp_stack.push(copyFrom.pop());
        }
        while (!this.isEmpty())
            this.pop();
        while (!temp_stack.isEmpty()) {
            String temp = temp_stack.pop();
            this.push(temp);
            copyFrom.push(temp);
        }

    }

    public void clear() {
        while (!this.isEmpty())
            this.pop();
    }
    public boolean isEmpty(){
        return stack.isEmpty();
    }
    public String pop(){
    String value;    
        if(!stack.isEmpty()){
            top--;
            value=(String)stack.get(top);
            //System.out.println("Popped Value =="+(String)stack.get(top));
            stack.remove(top);
            return value;
            
        }else{
            //System.out.println("Stack Is Empty!!");
            return "$";
        }
    }
}
