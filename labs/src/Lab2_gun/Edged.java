package Lab2_gun;

/**
 * Класс Холодное оружие - расширение класса Оружие
 * 
 * @author kr1stoffers
 */
public class Edged extends Weapon {
    /** Поле для хранения значения длины оружия */
    private Integer bladeLength;
    /** Поле для хранения значения твердости оружия */
    private Integer bladeHardness;

    /**
     * Устанавливает значение поля {@link Edged#bladeLength}
     * 
     * @param length - значение длинны оружия
     */
    public void setBladeLength(int length) {
        this.bladeLength = length;
    }

    /**
     * Устанавливает значение поля {@link Edged#bladeHardness}
     * 
     * @param hardness - значение твердости оружия
     */
    public void setBladeHardness(int hardness) {
        this.bladeHardness = hardness;
    }

    /**
     * Возвращает значение поля {@link Edged#bladeLength}
     * 
     * @return целое значение длинны оружия
     */
    public Integer getBladeLength() {
        return this.bladeLength;
    }

    /**
     * Возвращает значение поля {@link Edged#bladeHardness}
     * 
     * @return целое значение твердости оружия
     */
    public Integer getBladeHardness() {
        return this.bladeHardness;
    }

    /**
     * Выводит все поля объекта
     * 
     * @return строка со всеми значениями объекта
     */
    public String toString() {
        return getName() + " " + getManufacturer() + " " + getDamage() + " " + bladeLength + " " + bladeHardness;
    }

    /**
     * Создает холодное оружие, с вызовом конструктора родительского класса без
     * параметров, и задает значение длины и твердости - 0
     */
    public Edged() {
        super();
        this.bladeLength = 0;
        this.bladeHardness = 0;
    }

    /**
     * Создает холодное оружие с задаными значениями длины и твердости, и
     * вызывает конструктор родительского класса с задаными значениями
     * 
     * @param name         - название холодного оружия
     * @param manufacturer - производитель
     * @param damage       - урон от оружия
     * @param length       - длина холодного оружия
     * @param hardness     - твердость оружия
     */
    public Edged(String name, String manufacturer, int damage, int length, int hardness) {
        super(name, manufacturer, damage);
        this.bladeLength = length;
        this.bladeHardness = hardness;
    }

}
