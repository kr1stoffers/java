package Lab2_gun;

public class Test {
    public static void main(String[] args) {
        Armouries armouries = new Armouries();
        Firearm gun1 = new Firearm("Револьвер Лефоше", "Казимира Лефоше", 7, 7, "Барабан");
        Firearm gun2 = new Firearm("ППШ 41", "Иран", 8, 25, "Барабан");
        Firearm gun3 = new Firearm("Walther P38", "Walther, Spreewerk и Mauser", 4, 9, "Самозарядный");
        Firearm gun4 = new Firearm("Maxim M/32-33", "Аймо Лахти", 8, 53, "Самозарядный");
        Edged blade1 = new Edged("Катана", "Япония", 4, 100, 60);
        Edged blade2 = new Edged("Кусаригама", "Япония", 5, 80, 55);

        armouries.addWeapon(gun1);
        armouries.addWeapon(gun2);
        armouries.addWeapon(gun3);
        armouries.addWeapon(gun4);
        armouries.addWeapon(blade1);
        armouries.addWeapon(blade2);

        armouries.countWeapon();
    }
}