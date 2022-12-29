//Реализуйте структуру телефонной книги с помощью HashMap,
//учитывая, что 1 человек может иметь несколько телефонов.

import java.util.*;

public class Main1 {
    public static void main(String[] args) {
        HashMap<String, List<String>> userList = new HashMap<>();
        userList.put("Ivanov Victor", Arrays.asList("+7(911)111-22-33", "+7(922)222-55-66"));
        userList.put("Sidorov Petr", Arrays.asList("+7(911)543-23-87", "+7(905)245-22-14"));

        List<String> list = getNewRecords();
        userList.put(list.remove(0), list);
        for (Map.Entry<String, List<String>> entry : userList.entrySet()) {
            System.out.println(entry.getKey() + " => " + entry.getValue());
        }
    }

    public static List<String> getNewRecords() {
        ArrayList<String> list = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        System.out.print("Input name: ");
        list.add(input.nextLine());
        System.out.print("Input phone number: ");
        list.add(input.nextLine());
        while (true) {
            System.out.print("One more number yes/no?: ");
            String choice = input.nextLine();
            if (Objects.equals(choice, "yes")) {
                System.out.print("Input phone number: ");
                list.add(input.nextLine());
            } else {
                break;
            }
        }
        return list;
    }
}