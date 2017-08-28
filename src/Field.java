package l1_test4_seabattle.src;

/**
 * Created by igor on 18.10.15.
 */
public class Field {
    private int fieldSize;
    private char[][] cells;
    public boolean isNotEmpty = true;
    private int shipsLife = 0;

    public void setShipsLife(int shipsLife) {
        this.shipsLife = shipsLife;
    }

    public int getShipsLife() {
        return shipsLife;
    }


    private void setFieldSize(int fieldSize) {
        this.fieldSize = fieldSize;
    }

    public void init(int size) {
        setFieldSize(size);
        cells = new char[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                cells[i][j] = '.';
            }
        }
    }

    public void showField() {
        for (int i = 0; i < fieldSize; i++) {
            for (int j = 0; j < fieldSize; j++) {
                System.out.print(cells[i][j]);
            }
            System.out.println();
        }
    }


    public void setShip(int numOfShips, int shipSize) {
        Ship ship = new Ship();
        for (int i = 0; i < numOfShips; i++) {
            int x = 0;
            int y = 0;

            do {
                x = ship.getPosition(fieldSize);
                y = ship.getPosition(fieldSize);
            } while (cells[x][y] == 'X' | cells[x][y + 2] == 'X');

            for (int k = 0; k < shipSize; ++k) {
                cells[x][y + k] = 'X';
                setShipsLife(getShipsLife() + 1);
            }
        }
    }

    public void doStrike(String coords) {
        int x = 100;
        int y = 100;
        String[] coordinates = new String[1];

        coordinates = coords.split("\\s");
        x = Integer.parseInt(coordinates[0]);
        y = Integer.parseInt(coordinates[1]);


        switch (cells[x][y]) {
            case '.':
                System.out.println("Не попал");
                cells[x][y] = '*';
                break;
            case 'X':
                System.out.println("Попал");
                cells[x][y] = '#';
                shipsLife--;
                if (shipsLife == 0) isNotEmpty = false;
                break;
            case '*':
            case '#':
                System.out.println("Уже стреляли");
                break;
            default:
                System.out.println("Снаряд вылетел за поле боевых действий");
        }
    }

    public void nuclearStrike() {
        cells = new char[fieldSize][fieldSize];
        for (int i = 0; i < fieldSize; i++) {
            for (int j = 0; j < fieldSize; j++) {
                cells[i][j] = '@';
                isNotEmpty = false;
                shipsLife = 0;
            }
        }
    }

    public int takeDamage() {
        int x = (int) (Math.random() * shipsLife);
        return x;
    }
}



