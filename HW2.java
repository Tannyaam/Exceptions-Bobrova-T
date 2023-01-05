import java.io.FileNotFoundException;
import java.util.Scanner;

public class HW2 {
    public static void main(String[] args) {
        /*task1();
        int d = 0;
        int[] array = {3, 4, 5, 6, 7, 8, 9, 10};
        int index = 8;
        task2(d, array, index);
        task3();*/
        try {
            task4();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public static void task1(){
        Scanner in = new Scanner(System.in);
        System.out.print("Введите дробное число: ");
        String num = in.nextLine();
        String finalNum = num.replace(',', '.');
        try{
            System.out.println("Введенное число: " + Float.parseFloat(finalNum));
        } catch (Exception e){
            System.out.println("Неправильный ввод числа. Повторите попытку.");
            task1();
        }
    }

    public static void task2(int d, int[]intArray, int index){
        try {
            double catchedRes1 = intArray[index] / d;
            System.out.println("catchedRes1 = " + catchedRes1);
        } catch (ArithmeticException e) {
            System.out.println("Catching exception: " + e);
        } catch (IndexOutOfBoundsException e){
            System.out.println("Catching exception: " + e);
        }

    }
    public static void task3() {
        try {
            int a = 90;
            int b = 3;
            System.out.println(a / b);
            printSum(23, 234);
            int[] abc = {1, 2,3};
            abc[2] = 9;
        } catch (NullPointerException ex) {
            System.out.println("Указатель не может указывать на null!");
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Массив выходит за пределы своего размера!");
        } catch (Throwable ex) {
            System.out.println("Что-то пошло не так...");
        }
    }
    public static void printSum(Integer a, Integer b) throws FileNotFoundException {
        System.out.println(a + b);
    }
    public static void inputVoid() throws Exception{
        Scanner in = new Scanner(System.in);
        System.out.print("Введите данные: ");
        String inputData = in.nextLine();
        if(inputData == ""){
            throw new Exception("Пустые строки вводить нельзя. Повторите ввод.");
        }
        else System.out.print(inputData);
    }
    public static void task4(){
        try {
            inputVoid();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            task4();
        }
    }
}
