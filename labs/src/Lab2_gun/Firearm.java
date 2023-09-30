package Lab2_gun;

/**
 * Класс Огнестрельное оружие - расширение класса Оружие
 * 
 * @author kr1stoffers
 */
public class Firearm extends Weapon {
    /** Поле для хранения значения калибра оружия */
    private Integer caliber;
    /** Поле для хранения типа перезарядки оружия */
    private String recharge;

    /**
     * Устанавливает значение поля {@link Firearm#caliber}
     * 
     * @param caliber - значение калибра оружия
     */
    public void setCaliber(int caliber) {
        this.caliber = caliber;
    }

    /**
     * Устанавливает значение поля {@link Firearm#recharge}
     * 
     * @param recharge - тип перезарядки оружия
     */
    public void setRecharge(String recharge) {
        this.recharge = recharge;
    }

    /**
     * Возвращает значение поля {@link Firearm#caliber}
     * 
     * @return целое значение калибра оружия
     */
    public Integer getCaliber() {
        return this.caliber;
    }

    /**
     * Возвращает значение поля {@link Firearm#recharge}
     * 
     * @return строка с типом перезарядки оружия
     */
    public String getRecharge() {
        return this.recharge;
    }

    /**
     * Выводит все поля объекта
     * 
     * @return строка со всеми значениями объекта
     */
    public String toString() {
        return getName() + " " + getManufacturer() + " " + getDamage() + " " + caliber + " " + recharge;
    }

    /**
     * Создает огнестрельное оружие, с вызовом конструктора родительского класса без
     * параметров, и задает значение калибру 0, а типу перезараядки - "Неизвестно"
     */
    public Firearm() {
        super();
        this.caliber = 0;
        this.recharge = "Неизвестно";
    }

    /**
     * Создает огнестрельное оружие с задаными значениями калибра и типа
     * перезарядки, и вызывает конструктор родительского класса с задаными
     * значениями
     * 
     * @param name         - название оружия
     * @param manufacturer - производитель
     * @param damage       - урон от оружия
     * @param caliber      - калибр
     * @param recharge     - тип перезарядки
     */
    public Firearm(String name, String manufacturer, int damage, int caliber, String recharge) {
        super(name, manufacturer, damage);
        this.caliber = caliber;
        this.recharge = recharge;
    }

}
