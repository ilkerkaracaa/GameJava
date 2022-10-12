import java.util.Scanner;

public class Game {
    Scanner input = new Scanner(System.in);
    public void start(){
        System.out.println("Macera oyununa hoşgeldiniz!");
        System.out.print("Bir isim giriniz : ");
        String playerName = input.nextLine();
        Player player = new Player(playerName);
        System.out.println(player.getName() + " Hoşgeldiniz!");
        System.out.println("Lütfen bir karakter seçin: ");
        player.selectChar();
    }
}
