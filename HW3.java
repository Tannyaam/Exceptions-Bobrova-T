import java.io.IOException;
import java.nio.file.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

public class HW3 {
    static class Person {
        String surname;
        String name;
        String patronymic;
        String birthday;
        long phoneNumber;
        char sex;

        public Person(String surname, String name, String patronymic, String birthday, long phoneNumber, char sex) {
            this.surname = surname;
            this.name = name;
            this.patronymic = patronymic;
            this.birthday = birthday;
            this.phoneNumber = phoneNumber;
            this.sex = sex;
        }
        @Override
        public String toString() {
            return surname + " " + name + " " + patronymic + " " + birthday + " " + phoneNumber + " " + sex;
        }
        public String convertToString(){
            String userDataStr = this.surname + " | " + this.name + " | " + this.patronymic + " | " + this.birthday + " | " + this.phoneNumber + " | " + this.sex;
            return userDataStr;
        }
    }

    public static void main(String[] args) {
        newUserInfo();
    }
    public static void newUserInfo(){
        ArrayList<String> newUser = dataInput();
        dataCheck(newUser);
        Person user = new Person(newUser.get(0), newUser.get(1), newUser.get(2), newUser.get(3), Long.parseLong(newUser.get(4)), newUser.get(5).charAt(0));
        String userDataStr = user.convertToString() + "\n";
        addNewUser(user.surname, userDataStr);
    }

    public static ArrayList<String> dataInput() {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите данные через пробел в формате: Фамилия Имя Отчество ДатаРождения(01.01.1900) НомерТелефона(79998887766) Пол(f/m): ");
        String input = in.nextLine();
        ArrayList<String> inputData = new ArrayList<String>(List.of(input.split(" ")));
        return inputData;
    }

    public static void dataCheck(ArrayList<String> inputData){
        try {
            if (inputData.size() > 6) {
                throw new Exception("Введено больше данных, чем требуется. Повторите ввод.");
            }
            if (inputData.size() < 6) {
                throw new Exception("Введено меньше данных, чем требуется. Повторите ввод.");
            }

            String inputSurname = inputData.get(0);
            String inputName = inputData.get(1);
            String inputPatronymic = inputData.get(2);
            String inputBirthday = inputData.get(3);
            String inputPhone = inputData.get(4);
            char sex = inputData.get(5).charAt(0);

            if (inputBirthday.length() != 10) {
                throw new Exception("Неверно указана дата рождения. Формат должен быть в виде ДД.ММ.ГГГГ. Повторите ввод.");
            }

            if (inputPhone.length() != 11){
                throw new Exception("Неверно указан номер телефона. Формат - 11 цифр. Повторите ввод.");
            }
            long phoneNumber = Long.parseLong(inputPhone);

            if ((sex != 'f') && (sex != 'm') && (sex != 'F') && (sex != 'M')) {
                throw new Exception("Неверно указан пол. Укажите f или m. Повторите ввод.");
            }

            Person userData = new Person(inputSurname, inputName, inputPatronymic, inputBirthday, phoneNumber, sex);
            String userDataStr = userData.convertToString();
            System.out.println(userDataStr);

        } catch (NumberFormatException e){
            System.out.println("Неверно указан номер телефона. Формат - 11 цифр. Повторите ввод.");
            dataInput();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            dataInput();
        }
    }
    public static void addNewUser(String fileName, String userData){
        try {
            Files.write(Paths.get(fileName), (userData + "\n").getBytes(), StandardOpenOption.APPEND);
        } catch(NoSuchFileException e){
            createNewUserFile(fileName, userData);
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
    public static void createNewUserFile(String fileName, String userData){
        try {
            Files.write(Paths.get(fileName), userData.getBytes());

        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}

