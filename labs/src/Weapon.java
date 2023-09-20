public class Weapon {
    // 2.Базовый класс – оружие. Производные – огнестрельное и холодное.
    // Создать класс ОружейнаяПалата, который может содержать
    // оба вида объектов.Предусмотреть метод
    // подсчета отдельно огнестрельного и холодного оружия (использовать оператор
    // instanceof).

    private String _name;
    private int _damage;
    private String _manufacturer;

    public void setName(String name) {
        _name = name;
    }

    public void setDamage(int damage) {
        _damage = damage;
    }

    public void setManufacturer(String manufacturer) {
        _manufacturer = manufacturer;
    }

    public String getName() {
        return _name;
    }

    public int getDamage() {
        return _damage;
    }

    public String getManufacturer() {
        return _manufacturer;
    }

    public Weapon() {
        _name = "Без названия";
        _damage = 0;
        _manufacturer = "Неизвестно";
    }

    public Weapon(String name, int damage, String manufacturer) {
        _name = name;
        _damage = damage;
        _manufacturer = manufacturer;
    }

}
