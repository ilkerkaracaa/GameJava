import java.util.Random;

public abstract class BattleLocation extends Location{
    private Monster monster;
    private String award;
    private int maxMonster;
    public BattleLocation(Player player, String name, Monster monster, String award, int maxMonster) {
        super(player, name);
        this.monster = monster;
        this.award = award;
        this.maxMonster = maxMonster;
    }

    @Override
    public boolean onLocation() {
        System.out.println("Şu an buradasınız : " + this.getName());
        System.out.println("Dikkatli Ol! Burada " + this.randomMonsterNumber() + " tane " + this.getMonster().getName() + " yaşıyor!");
        System.out.print("<S>avaş veya <K>aç! : ");
        String selectCase = input.nextLine();
        selectCase = selectCase.toUpperCase();
        if (selectCase.equals("S")){

        }
        return true;
    }

    public boolean combat(int monsNumber){
        for (int i = 0; i < monsNumber; i++){
            playerStats();
            monsterStats();
            while (this.getPlayer().getHealth() > 0 && this.getMonster().getHealth() > 0 ){
                System.out.print("<V>ur veya <K>aç : ");
                String selectCombat = input.nextLine().toUpperCase();
                if(selectCombat.equals("V")){
                    System.out.println("Siz Vurdunuz!");
                    this.getMonster().setHealth(this.getMonster().getHealth() - this.getPlayer().getTotalDamage());
                    afterHit();
                    if(this.getMonster().getHealth() > 0){
                        System.out.println("Canavar Size Vurdu!");
                        int monsterDamage = this.getMonster().getDamage() - this.getPlayer().getInventory().getArmor().getBlock();
                        if(monsterDamage < 0){
                            monsterDamage = 0;
                        }
                        this.getPlayer().setHealth(this.getPlayer().getHealth() - monsterDamage);
                        afterHit();
                    }
                }
            }
        }
        return false;
    }

    public void afterHit(){
        System.out.println("Canınız : " + this.getPlayer().getHealth());
        System.out.println(this.getMonster().getName() + " Canı : " + this.getMonster().getHealth());
    }

    public void playerStats(){
        System.out.println("Oyuncunun Durumu");
        System.out.println("-------------------------------");
        System.out.println("Sağlık : " + this.getPlayer().getHealth());
        System.out.println("Silah : " + this.getPlayer().getInventory().getWeapon().getName());
        System.out.println("Zırh : " + this.getPlayer().getInventory().getArmor().getName());
        System.out.println("Bloklama : " + this.getPlayer().getInventory().getArmor().getBlock());
        System.out.println("Hasar : " + this.getPlayer().getTotalDamage());
        System.out.println("Para : " + this.getPlayer().getMoney());
    }

    public void monsterStats(){
        System.out.println(this.getMonster().getName() + "nın Değerleri");
        System.out.println("-------------------------------");
        System.out.println("Sağlık : " + this.getMonster().getHealth());
        System.out.println("Hasar : " + this.getMonster().getDamage());
        System.out.println("Ödül : " + this.getMonster().getAward());
    }

    public int randomMonsterNumber(){
        Random random = new Random();
        return random.nextInt(this.getMaxMonster()) + 1;
    }

    public Monster getMonster() {
        return monster;
    }

    public void setMonster(Monster monster) {
        this.monster = monster;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public int getMaxMonster() {
        return maxMonster;
    }

    public void setMaxMonster(int maxMonster) {
        this.maxMonster = maxMonster;
    }
}
