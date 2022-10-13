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
                buyWeapon();
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

    public void buyWeapon(){
        System.out.print("Silah seçiniz : ");
        int selectWeaponID = input.nextInt();
        while (selectWeaponID < 1 && selectWeaponID > Weapon.weapons().length){
            System.out.print("Geçersiz bir seçim yaptınız!\n Lütfen yeni bir seçim yapınız : ");
            selectWeaponID = input.nextInt();
        }

        Weapon selectedWeapon = Weapon.getWeaponObjByID(selectWeaponID);
        if(selectedWeapon != null){
            if(selectedWeapon.getPrice() > this.getPlayer().getMoney()){
                System.out.println("Yeterli paranız bulunmamaktadır!");
            }else {
                System.out.println(selectedWeapon.getName() + " silahını satın aldınız!");
                int balance = this.getPlayer().getMoney() - selectedWeapon.getPrice();
                this.getPlayer().setMoney(balance);
                System.out.println("Kalan paranız : " + this.getPlayer().getMoney());
                this.getPlayer().getInventory().setWeapon(selectedWeapon);
            }
        }
    }

    public void printArmors(){
        System.out.println("Silahlar");
    }
}
