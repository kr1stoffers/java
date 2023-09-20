// 1.Добавить к гаражу возможность удаления из него машины, а к классу Auto
// добавить поле с гос. номером.

public class Auto {
    private String firm;
    private int maxSpeed;
    private String carNumber;

    public void setFirm(String firma) {
        firm = firma;
    }

    public void setMaxSpeed(int speed) {
        maxSpeed = speed;
    }

    public void setCarNumber(String number) {
        carNumber = number;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public String getFirm() {
        return firm;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public Auto() {
        firm = "Без названия";
        maxSpeed = 0;
        carNumber = "Номер";
    }

    public Auto(String firma, int speed, String number) {
        firm = firma;
        maxSpeed = speed;
        carNumber = number;
    }
}
