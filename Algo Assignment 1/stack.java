import java.util.ArrayList;
public class stack{
    private ArrayList stack = new ArrayList();
    private  int top=0;
    public void push(String value){
        stack.add(top, value);
        //System.out.println("Pushed value =="+value);
        top++;
        
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
        return "Stack Is Empty!!";
        }
    }
}
