package aston.modul_1;



public class Main {
    public static void main(String[] args) {

        MyHashMap<Integer, String> map = new MyHashMap<>();
        map.insert(985, "Aleksey");
        map.insert(5799, "Andrey");
        map.insert(2234, "Vasiliy");
        map.insert(876, "Петя");
        map.insert(654767, "Вася");
        map.insert(97054, "Vasiliy");
        map.insert(178743, "Гоша");
        map.insert(7454356, "Роберт");
        map.insert(93663, "Федор");
        map.insert(23364, "Миша");
        map.insert(32364, "Andrey");
        map.insert(53448, "Гриша");
        map.insert(12378, "Коля");
        map.insert(25454, "Марина");
        map.insert(92887, "Альюина");
        map.insert(2254, "Василиса ");
        map.insert(5874, "Анжела");
        map.insert(5658, "Света");
        map.insert(156743, "Таня ");
        map.insert(75676, "Оля");
        map.insert(998663, "Катя ");
        map.insert(25683, "Лида ");
        map.insert(32984, "Люда");
        map.insert(5348, "Инга");


//        for (String s : map) {
//            System.out.println(s);
//        }

        System.out.println(map.get(75676));
        System.out.println(map.remove(75676));
        System.out.println(map.get(75676));
    }
}












