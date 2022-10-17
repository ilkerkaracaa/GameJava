public class SafeHouse extends NormalLoc{

    public SafeHouse(Player player) {
        super(player, "Güvenli Ev");
    }

    @Override
    public boolean onLocation() {
        if(this.getPlayer().isCaveFinish() == true && this.getPlayer().isForestFinish() == true && this.getPlayer().isRiverFinish() == true){
            System.out.println("Tebrikler Oyunu Tamamladınız!");
            return false;
        }
        System.out.println("Güvenli Evdesiniz!");
        System.out.println("Canınız Yenilendi!");
        this.getPlayer().setHealth(this.getPlayer().getBaseHealth());
        return true;
    }
}
