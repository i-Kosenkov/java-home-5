//Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений.
//Отсортировать по убыванию популярности.

import java.util.*;
import java.util.stream.Collectors;

public class Main2 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>(Arrays.asList("Светлана Петрова", "Кристина Белова", "Анна Мусина",
                "Анна Крутова", "Иван Юрин", "Петр Лыков", "Павел Чернов", "Петр Чернышов", "Мария Федорова",
                "Марина Светлова", "Мария Савина", "Мария Рыкова", "Марина Лугова", "Анна Владимирова", "Иван Мечников",
                "Петр Петин", "Иван Ежов"));

        Map<String, Integer> map = GetMap(list);
        GetSortedMap(map);
    }

    public static Map<String, Integer> GetMap(List<String> list) {
        Map<String, String> map = new HashMap<>();
        Map<String, Integer> newMap = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            List<String> newList = Arrays.asList(list.get(i).split(" "));
            map.put(newList.get(1), newList.get(0)); //в map пишем все значения
            newMap.put(newList.get(0), 0); //в newMap пишем без дублей
        }
//        System.out.println(map);
        for (String item : map.values()) {
            for (String newItem : newMap.keySet()) {
                if (Objects.equals(item, newItem)) {
                    newMap.put(item, newMap.get(newItem) + 1);
                }
            }
        }
//        System.out.println(newMap);
        return newMap;
    }

    //Сортировку map по значениям честно скажу стащил из сети :\
    public static void GetSortedMap(Map<String, Integer> map) {
        Map<String, Integer> sortedMap = map.entrySet().stream()
                .sorted(Comparator.comparingInt(e -> -e.getValue())).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> {
                    throw new AssertionError();
                }, LinkedHashMap::new));
        sortedMap.entrySet().forEach(System.out::println);
    }
}