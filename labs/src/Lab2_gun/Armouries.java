package Lab2_gun;
//Создать класс ОружейнаяПалата, который может содержать оба вида объектов.

//Предусмотреть метод подсчета отдельно огнестрельного и холодного оружия(использовать оператор instanceof).

import java.util.ArrayList;

/**
 * Класс Арсенал, который может содержать объекты типа Оружия
 * 
 * @author kr1stoffers
 */
public class Armouries {
    /** Поле для хранения списка объектов Оружия */
    private ArrayList<Weapon> Weapons = new ArrayList<Weapon>();

    /**
     * Метод добавление объекта в список объектов Оружия
     * 
     * @param object - объект класса Оружие
     */
    public void addWeapon(Weapon object) {
        Weapons.add(object);
    }

    /**
     * Метод вывода всех объктов из списка Арсенала
     * 
     */
    public void printWeapon() {
        System.out.println("В арсенале: ");
        for (Weapon weapon : Weapons) {
            System.out.println("\t" + weapon.toString());
        }
    }

    /**
     * Подсчитывает и выводит на экран количество огнестрельного и холодного оружия
     * в списке объектов Оружия.
     */
    public void countWeapon() {
        int countFirearm = 0;
        int countEdged = 0;

        for (Weapon w : Weapons) {
            if (w instanceof Firearm) {
                countFirearm++;
            } else {
                countEdged++;
            }
        }

        System.out.println("Count of firearm: " + countFirearm);
        System.out.println("Count of edged: " + countEdged);
    }

    /** Создает Арсенла без заданых параметров */
    public Armouries() {

    }

    /**
     * Создает Арсенал с заданым списком оружия
     * 
     * @param array - список объектов типа Оружия
     */
    public Armouries(ArrayList<Weapon> array) {
        Weapons = array;
    }
}
