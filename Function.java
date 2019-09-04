import java.util.ArrayList;

public class Function {
    public static void main(String[] args) {
        function(5);
    }

    public static void function(int value){
        ArrayList values = new ArrayList();
        for (int i = 1; i <= value ; i++) {
            if(value % i == 0){
                values.add(value/i);
            }
        }
        int c = 0;
        for (int i = 1; i < values.size() ; i++) {
            c = c + (int) values.get(i);
        }
        if(c == value){
            System.out.println("perfect: " + c + "\nInputed value: " + value);
        } else if( c == value) {
            System.out.println("abundant: " + c + "\nInputed value: " + value);
        } else {
            System.out.println("deficient: " + c + "\nInputed value: " + value);
        }
    }
}
