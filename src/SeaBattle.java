package l1_test4_seabattle.src;

/**
 * Created by igor on 18.10.15.
 */
public class SeaBattle {

    public static void main(String[] args) { // должен быть маленьким
        int numOfShips = 3;
        int fieldSize = 10;
        int shipSize = 3;
        doGame(fieldSize, numOfShips, shipSize); // alt-enter
    }

    public static void doGame(int fieldSize, int numOfShips, int shipSize) {
        Field field = new Field();
        Player player = new Player();
        String coords;
        player.setName();

        System.out.println("Привет " + player.getName() + " Я хочу сыграть с тобой в одну игру…");

        System.out.println("Инциализация поля боя");
        field.init(fieldSize);
        System.out.println("Размещение боевых едениц");
        field.setShip(numOfShips, shipSize);
        System.out.println("Ну что же приступим, смотри не жульничай... (nuclearStrike,showField,needHeals)");
        System.out.println("Вводи координаты от \"0 0\" до \"9 9\"");

        while (field.isNotEmpty | player.getPoints() == 0) {
            coords = player.getInput("Ваш ход:");
            if (coords.matches("[0-9]{1}\\s[0-9]{1}")) {
                field.doStrike(coords);
            } else if (coords.matches("nuclearStrike")) {
                field.nuclearStrike();
            } else if (coords.matches("showField")) {
                field.showField();
            } else if (coords.matches("needHeals")) {
                player.setPoints(100);
            } else {
                System.out.println("Осечка");
            }
            player.shotCount++;
            int dmg = field.takeDamage();
            int hp = player.getPoints();
            player.setPoints(hp - dmg);
            System.out.println("Кол-во боеспособных палуб врага: " + field.getShipsLife());
            System.out.println("Внимание!!! Отетный огонь противника: " + dmg);
            System.out.println("Осталось здоровья: " + (hp - dmg));
        }

        if (player.getPoints() == 0) {
            System.out.println("Поражение. Кол-во потраченных снарядов: " + player.shotCount);
        } else if (!field.isNotEmpty) {
            System.out.println("Победа. Кол-во потраченных снарядов: " + player.shotCount);
            System.out.println("Осталось здоровья игрока: " + player.getPoints());
        }

        field.showField();
    }
}
