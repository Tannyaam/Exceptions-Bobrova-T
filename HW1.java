import java.util.ArrayList;
import java.util.Scanner;

public class HW1 {
    public static void main(String[] args) {
        /*User user = new User();
        user.createUser();
        user.createUser();
        user.createUser();
        for (User i: user.allUsers) {
            System.out.println(i);
        }*/

        int[] array1 = {1, 2, 3, 4, 5};
        int[] array2 = {6, 7, 8, 9};
        arraySubtraction(array1, array2);
    }
    public static class User {
        public String name;
        public String password;
        public String mail;
        public ArrayList<User> allUsers = new ArrayList<>();
        public Scanner in = new Scanner(System.in);

        public void createUser() {
            try {
                User newUser = new User();
                System.out.print("Введите имя пользователя: ");
                String newUserName = in.nextLine();
                for (User i : allUsers) {
                    if (i.name.equals(newUserName)) {
                        throw new Exception("Пользователь с таким именем существует. Задайте другое.");
                    }
                }
                newUser.name = newUserName;
                System.out.print("Введите пароль: ");
                String newUserPassword = in.nextLine();
                if (newUserPassword.length() < 5) {
                    throw new Exception("Пароль должен содержать не менее 5 символов.");
                }
                newUser.password = newUserPassword;
                System.out.print("Введите e-mail: ");
                String newUserEmail = in.nextLine();
                if (!newUserEmail.contains("@")){
                    throw new Exception("Неверно введен e-mail.");
                }
                newUser.mail = newUserEmail;
                allUsers.add(newUser);
                System.out.println("Пользователь успешно создан!");
            }
            catch (Exception e){
                System.out.println(e.getMessage() + "Повторите ввод данных.");
                createUser();
            }
        }

        @Override
        public String toString() {
            return "name: " + this.name
                    + " e-mail: " + this.mail;
        }
    }
    public static void arraySubtraction(int[] array1, int[] array2){
        try{
            if(array1.length != array2.length){
                throw new Exception("Попарное вычитание массивов невозможно. Разные длины массивов.");
            }
            int[] newArray = new int[array1.length];
            for (int i = 0; i < array1.length; i++) {
                newArray[i] = array1[i] - array2[i];
            }
            for (int i = 0; i < array1.length; i++) {
                System.out.print(newArray[i] + " ");
            }
        }
        catch (Exception e){
            System.out.print(e.getMessage() + " Повторите попытку.");
        }
    }

    public static void arrayDivision(int[] array1, int[] array2){
        try{
            if(array1.length != array2.length){
                throw new Exception("Попарное деление массивов невозможно. Разные длины массивов.");
            }
            for (int i = 0; i < array1.length; i++) {
                if (array2[i] == 0){
                    throw new Exception("Попарное деление массивов невозможно. Знаменатель - 0.");
                }
            }
            int[] newArray = new int[array1.length];
            for (int i = 0; i < array1.length; i++) {
                newArray[i] = array1[i] / array2[i];
            }
            for (int i = 0; i < array1.length; i++) {
                System.out.print(newArray[i] + " ");
            }
        }
        catch (Exception e){
            System.out.print(e.getMessage() + " Повторите попытку.");
        }
    }
}
