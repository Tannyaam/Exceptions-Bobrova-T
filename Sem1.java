import java.util.Scanner;

public class Sem1 {
    public static void main(String[] args) {
        //String inputString = inputData();
        //checkString(inputString);
        int[] array = {1, 2, 3, 4, 5};
        findNum(array, 7);
    }
    public static String inputData(){
        Scanner in = new Scanner(System.in);
        System.out.print("Input a number: ");
        String inputString = in.nextLine();
        return inputString;
    }
    public static void checkString(String inputString){
        try{
            int num = Integer.parseInt(inputString);
            System.out.print(num);
        }
        catch (Exception ex){
            System.out.println("Введенные данные не являются числом. Повторите попытку.");
            String newInputString = inputData();
            checkString(newInputString);
        }
    }

    public static void findNum(int[] array, int num){
        try{
            if (array.length < 2)
                throw new Exception("-1");
            int index = -1;
            for (int i = 0; i < array.length; i++)
                if(num == array[i]) index = i;
            if (index == -1)
                throw new Exception("-2");
            if (array == null)
                throw new Exception("-3");
            System.out.println(index);
        }
        catch (Exception e) {
            switch (Integer.parseInt(e.getMessage())){
                case -1 -> System.out.println("Array is too small");
                case -2 -> System.out.println("Element is not exist in array");
                case -3 -> System.out.println("Array is empty");
            }
        }
    }
}
