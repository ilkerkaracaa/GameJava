public class ToolStore extends NormalLoc{

    public ToolStore(Player player) {
        super(player, "Mağaza");
    }

    @Override
    public boolean onLocation() {
        System.out.println("Mağazaya Hoşgeldiniz!");
        System.out.println("1 - Silahlar");
        System.out.println("2 - Zırhlar");
        System.out.println("3 - Çıkış Yap");
        System.out.print("Seçiminiz : ");
        int selectCase = input.nextInt();
        while (selectCase < 1 && selectCase > 3){
            System.out.print("Geçersiz bir seçim yaptınız!\n Lütfen yeni bir seçim yapınız : ");
            selectCase = input.nextInt();
        }
        switch (selectCase){
            case 1:
                printWeapons();
                break;
            case 2:
                printArmors();
                break;
            case 3:
                return true;
        }
        return true;
    }
    public void printWeapons(){
        System.out.println("-------- Silahlar --------");
        for (Weapon w : Weapon.weapons()) {
            System.out.println("Id : \t" +w.getId() + "\tSilah Adı : " + w.getName() + "\tHasar : " + w.getDamage() + "\tFiyat : " + w.getPrice());
        }
    }
    public void printArmors(){
        System.out.println("Silahlar");
    }
}
