import java.util.Random;

public class Snake extends Monster{

    public Snake() {

        super(4, "Yılan", Snake.randomDamage(), 12, 0);

    }

    public static int randomDamage(){

        Random random = new Random();
        int min =3;
        int max =6;

        int randomDamage = random.nextInt((max -min ) +1) + min;

        return randomDamage;
    }



}