package l1_test4_seabattle.src;

/**
 * Created by igor on 18.10.15.
 */
public class Ship {


    public int getPosition(int distace) {
        int position;
        position = (int) (Math.random() * (distace - 3));
        return position;
    }
}
