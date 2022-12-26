import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class task_01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, HashMap<String, String>> numblist = new HashMap<>();
        int vr = -1;
        while (vr!=0) {
            System.out.println("=== Телефонная книга ===\n");
            System.out.println("1)Добавить номер\n2)Удалить номер\n3)Удалить весь контакт\n4)Найти номер\n5)Отобразить все номера\n\n0)Выход");
            System.out.print("Выберите функцию: ");
            vr = sc.nextInt();
            switch (vr){
                case 1:
                    addnum(numblist);
                    break;
                case 2:
                    delnum(numblist);
                    break;
                case 3:
                    delcont(numblist);
                    break;
                case 4:
                    findnum(numblist);
                    break;
                case 5:
                    allnums(numblist);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Некорректный ввод, попробуйте снова.");
                    break;
            }
        }
    }
    public static void addnum(HashMap<String, HashMap<String, String>> nums){
        Scanner sc = new Scanner(System.in);
        HashMap<String, String> fullinfo= new HashMap<>();
        System.out.print("Введите Имя: ");
        String name = sc.nextLine();
        for (var el: nums.entrySet()){
            if (el.getKey().equals(name)){
                fullinfo = el.getValue();
            }
        }
        System.out.print("Введите значение телефона(домашний/рабочий/любое другое): ");
        String numpar = sc.nextLine();
        System.out.print("Введите номер телефона: ");
        String num = sc.nextLine();
        fullinfo.put(numpar,num);
        nums.put(name, fullinfo);
        System.out.println("Номер успешно добавлен. Нажмите Enter для возврата в главное меню.");
        String z = sc.nextLine();
    }
    public static void delnum(HashMap<String, HashMap<String, String>> nums){
        Scanner sc = new Scanner(System.in);
        HashMap<String, String> fullinfo= new HashMap<>();
        System.out.print("Введите Имя: ");
        String name = sc.nextLine();
        for (var el: nums.entrySet()){
            if (el.getKey().equals(name)){
                fullinfo = el.getValue();
                for (var elem: fullinfo.entrySet()){
                    System.out.println(elem.getKey()+' '+elem.getValue());
                }
            }
        }
        System.out.print("Введите значение телефона(не номер) который хотите удалить: ");
        String numpar = sc.nextLine();
        String rem = "";
        for (var elem: fullinfo.entrySet()){
            if (elem.getKey().equals(numpar)){
                rem = elem.getKey();
            }
        }
        if (rem.length()>0) {
            fullinfo.remove(rem);
            nums.put(name, fullinfo);
            System.out.println("Номер успешно удален. Нажмите Enter для возврата в главное меню.");
        }
        else {
            System.out.println("Номер с таким заечением не найден. Нажмите Enter для возврата в главное меню.");
        }
        String z = sc.nextLine();
    }
    public static void delcont(HashMap<String, HashMap<String, String>> nums){
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите Имя: ");
        String name = sc.nextLine();
        if (nums.remove(name)!= null){
            System.out.println("Контакт успешно удален. Нажмите Enter для возврата в главное меню.");
        }
        else {
            System.out.println("Контакт с таким именем не найден. Нажмите Enter для возврата в главное меню.");
        }
        String z = sc.nextLine();
    }
    public static void findnum(HashMap<String, HashMap<String, String>> nums){
        Scanner sc = new Scanner(System.in);
        boolean flag = false;
        System.out.print("\n\nПоиск производится по именам\nВведите имя: ");
        String name = sc.nextLine();
        for (var el : nums.entrySet()){
            if (el.getKey().toLowerCase().contains(name.toLowerCase())){
                System.out.println(el.getKey());
                for (var elem: el.getValue().entrySet()){
                    System.out.println("  "+elem.getKey()+" : "+elem.getValue());
                }
                flag = true;
            }
        }
        if (flag) System.out.println("Контакты успешно найдены. Нажмите Enter для возврата в главное меню.");
        else System.out.println("Контакты по данному запросы не найдены. Нажмите Enter для возврата в главное меню.");
        String z = sc.nextLine();
    }
    public static void allnums(HashMap<String, HashMap<String, String>> nums){
        Scanner sc = new Scanner(System.in);
        for (var el : nums.entrySet()){
            System.out.println(el.getKey());
            for (var elem: el.getValue().entrySet()){
                System.out.println("  "+elem.getKey()+" : "+elem.getValue());
            }
        }
        System.out.println("Контакты успешно отображены. Нажмите Enter для возврата в главное меню.");
        String z = sc.nextLine();
    }
}
