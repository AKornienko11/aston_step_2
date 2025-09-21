package aston.modul_1;

public class Main {
    public static void main(String[] args) {
        MyHashMap<Integer, String> map = new MyHashMap<>();
        map.put(17763, "Aleksey");
        map.put(226, "Andrey");
        map.put(3334, "Vlad");
        map.put(47745, "Петя");
        map.put(5356, "Вася");
        map.put(645, "Vasiliy");
        map.put(178743, "Гоша");
        map.put(7454356, "Роберт");
        map.put(93663, "Федор");
        map.put(23364, "Миша");
        map.put(32364, "Andrey");
        map.put(53448, "Гриша");
        map.put(12378, "Коля");
        map.put(25454, "Марина");
        map.put(92887, "Альбина");
        map.put(2254, "Василиса ");
        map.put(5874, "Анжела");
        map.put(5658, "Света");
        map.put(156743, "Таня ");
        map.put(75676, "Оля");
        map.put(998663, "Катя ");
        map.put(25683, "Лида ");
        map.put(32984, "Люда");
        map.put(5348, "Инга");
        map.put(5348, "Инга Михайловна");

        System.out.println("Количество элементов до  удаления - " + map.getSize());
        map.remove(156743);
        System.out.println("Количество элементов после удаления - " + map.getSize());


        System.out.println(map.get(998663));
        System.out.println("----------------------");


        for (String s : map) {
            System.out.println(s);
        }


    }
}


















