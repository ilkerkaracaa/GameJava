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
        Location location = null;
        while (true){
            player.printPlayerInfo();
            System.out.println("Bölgeler");
            System.out.println("1 - Güvenli Ev");
            System.out.println("2 - Eşya Dükkanı");
            System.out.println("3 - Mağara");
            System.out.println("4 - Orman");
            System.out.println("5 - Nehir");
            System.out.println("6 - Oyundan Çık");
            System.out.print("Lütfen gitmek istediğiniz bölümü seçin : ");
            int selectLoc = input.nextInt();
            switch (selectLoc){
                case 1:
                    location = new SafeHouse(player);
                    break;
                case 2:
                    location = new ToolStore(player);
                    break;
                case 3:
                    location = new Cave(player);
                    break;
                case 4:
                    location = new Forest(player);
                    break;
                case 5:
                    location = new River(player);
                case 6:
                    System.out.println("Tekrar Görüşürüz!");
                    return;
                default:
                    System.out.println("Hata");
            }
            if (!location.onLocation()){
                System.out.println("GAME OVER!");
                break;
            }
        }
    }
}
