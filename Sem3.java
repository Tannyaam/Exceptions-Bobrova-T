import java.io.FileReader;

class FactorialException extends Exception{
    private int number;
    public int getNumber(){
        return number;
    }
    public FactorialException(String message, int num){
        super(message);
        number = num;
    }
}

class Factorial{
    public static int getFactorial(int num) throws FactorialException{
        int result = 1;
        if(num < 0) throw new FactorialException("Число меньше 0", num);
        for (int i = 0; i <= num; i++) {
            result *= i;
        }
        return result;
    }
}

class Counter{
    public static int counter;
    public static int add(){
        counter += 1;
        return counter;
    }
}

public class Sem3 {
    public static void main(String[] args) {
        /*try {
            int res = Factorial.getFactorial(1);
            System.out.println(res);
        } catch (FactorialException e){
            System.out.println(e.getMessage());
            System.out.println(e.getNumber());
        }*/
        try(FileReader test = new FileReader("test.txt")
        ) {
            int c;
            String fileText = "";
            while ((c = test.read()) != -1) {
                fileText += (char)c;
            }
            System.out.print(fileText);
        }catch (Exception e){
            System.out.print("Ошибка");
        }
    }
}
