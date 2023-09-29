package Lab2_gun;
// 2.Базовый класс – оружие. Производные – огнестрельное и холодное.

// Создать класс ОружейнаяПалата, который может содержать
// оба вида объектов.Предусмотреть метод
// подсчета отдельно огнестрельного и холодного оружия (использовать оператор
// instanceof).

/**
 * Класс Оружие - базовый класс для объектов оружия
 * 
 * @author kr1stoffers
 */
public class Weapon {

    /** Поле для хранения названия оружия */
    private String name;
    /** Поле для хранения производителя оружия */
    private String manufacturer;
    /** Поле для хранения урона оружия */
    private int damage;

    /**
     * Устанавливает значение поля {@link Weapon#name}
     * 
     * @param name - название оружия
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Устанавливает значение поля {@link Weapon#manufacturer}
     * 
     * @param manufacturer - производитель оружия
     */
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    /**
     * Устанавливает значение поля {@link Weapon#damage}
     * 
     * @param damage - урон от оружия
     */
    public void setDamage(int damage) {
        this.damage = damage;
    }

    /**
     * Возвращает значение поля {@link Weapon#name}
     * 
     * @return строка с названием оружия
     */
    public String getName() {
        return this.name;
    }

    /**
     * Возвращает значение поля {@link Weapon#manufacturer}
     * 
     * @return строка с производителем оружия
     */
    public String getManufacturer() {
        return this.manufacturer;
    }

    /**
     * Возвращает значение поля {@link Weapon#damage}
     * 
     * @return целое значение с уроном от оружия
     */
    public int getDamage() {
        return this.damage;
    }

    /**
     * Создает оружие с названием "Без названия", с производителем "Неизвестно" и
     * уроном, равным 0
     */
    public Weapon() {
        this.name = "Без названия";
        this.manufacturer = "Неизвестно";
        this.damage = 0;
    }

    /**
     * Создает оружие с задаными значениями названия, производителя и уроном
     * 
     * @param name         - название оружия
     * @param manufacturer - проиводитель оружия
     * @param damage       - значение урона от оружия
     */
    public Weapon(String name, String manufacturer, int damage) {
        this.name = name;
        this.manufacturer = manufacturer;
        this.damage = damage;
    }

}
