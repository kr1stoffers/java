package Lab2_auto;
// 1.Добавить к гаражу возможность удаления из него машины, а к классу Auto добавить поле с гос. номером.

/**
 * Класс Автомобиль - базовый класс для объектов транспорта
 * 
 * @author Слива М.В.
 */
public class Auto {
    /** Поле для хранения названия фирмы автомобиля */
    private String firm;
    /** Поле для хранения максимальной скорости автомобиля */
    private int maxSpeed;
    /** Поле для хранения гос. номера автомобиля */
    private String number;

    /**
     * Устанавливает значение поля {@link Auto#firm}
     * 
     * @param firma - название фирмы автомобиля
     */
    public void setFirm(String firma) {
        firm = firma;
    }

    /**
     * Устанавливает значение поля {@link Auto#maxSpeed}
     * 
     * @param speed - значение максимальной скорости автомобиля
     */
    public void setMaxSpeed(int speed) {
        maxSpeed = speed;
    }

    /**
     * Установить значение поля {@link Auto#number}
     * 
     * @param number - гос. номер автомобиля
     */
    public void setNumber(String number) {
        this.number = number;
    }

    /**
     * Возвращает значение поля {@link Auto#maxSpeed}
     * 
     * @return целое значение максимальной скорости автомобиля
     */
    public int getMaxSpeed() {
        return maxSpeed;
    }

    /**
     * Возвращает значение поля {@link Auto#firm}
     * 
     * @return строку с названием фирмы автомобиля
     */
    public String getFirm() {
        return firm;
    }

    /**
     * Возвращает значение поля {@link Auto#number}
     * 
     * @return строка с гос. номером автомобиля
     */
    public String getNumber() {
        return number;
    }

    /**
     * Создает автомобиль с фирмой "Без названия", максимальной скоростью, равной 0
     * и с гос. номером "А000АА"
     */
    public Auto() {
        firm = "Без названия";
        maxSpeed = 0;
        number = "A000AA";
    }

    /**
     * Создает автомобиль с задаными значениями фирмы, максимальной скорости и гос.
     * номером
     * 
     * @param firma  - название фирмы автомобиля
     * @param speed  - значение максимальной скорости автомобиля
     * @param number - гос. номер автомобиля
     */
    public Auto(String firma, int speed, String number) {
        firm = firma;
        maxSpeed = speed;
        this.number = number;
    }
}
