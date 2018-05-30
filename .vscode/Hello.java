import com.sun.org.apache.xpath.internal.SourceTree;

public class Hello{
    int number;
    public static void main(String[] args){
        System.out.println("Hello world");
        int sum = 0 ;
        for (int i = 0; i < 100; i++) {
            sum+=i;
            System.out.println(sum);
        }
    }
}