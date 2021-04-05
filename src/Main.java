import javax.imageio.IIOException;
import java.io.IOException;

public class Main {
    public static void main(String[] args){
        String path = "C:\\Users\\andry\\Desktop\\lab5-op\\src\\";
        String fileName = "test.txt";
        try{
            System.out.println(Task3.rarestWords(path + fileName));
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
