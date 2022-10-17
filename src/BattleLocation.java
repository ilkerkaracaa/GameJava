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
        if (this.getMonster().getName().equals("Zombi") && this.getPlayer().isCaveFinish() == true){
            System.out.println("Bu Bölümü Tamamladınız!");
            return true;
        }else if (this.getMonster().getName().equals("Vampir") && this.getPlayer().isForestFinish() == true){
            System.out.println("Bu Bölümü Tamamladınız!");
            return true;
        }else if (this.getMonster().getName().equals("Ayı") && this.getPlayer().isRiverFinish() == true){
            System.out.println("Bu Bölümü Tamamladınız!");
            return true;
        }

        System.out.println("Şu an buradasınız : " + this.getName());
        System.out.println("Dikkatli Ol! Burada " + this.randomMonsterNumber() + " tane " + this.getMonster().getName() + " yaşıyor!");
        System.out.print("<S>avaş veya <K>aç! : ");
        String selectCase = input.nextLine();
        selectCase = selectCase.toUpperCase();
        if (selectCase.equals("S") && combat(this.randomMonsterNumber())) {
            System.out.println(this.getName() + " tüm düşmanları yendiniz!");
            if (this.getMonster().getName().equals("Zombi")){
                this.getPlayer().setCaveFinish(true);
            }else if (this.getMonster().getName().equals("Vampir")){
                this.getPlayer().setForestFinish(true);
            }else if (this.getMonster().getName().equals("Ayı")){
                this.getPlayer().setRiverFinish(true);
            }
            return true;
        }
            if (this.getPlayer().getHealth() < 0){
                System.out.println("Öldünüz!");
                return false;
            }
        return true;
    }

    public boolean combat(int monsNumber){
        for (int i = 0; i < monsNumber; i++){
            this.getMonster().setHealth(this.getMonster().getBaseHealth());
            playerStats();
            monsterStats(i);
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
                }else {
                    return false;
                }
            }
            if(this.getMonster().getHealth() < this.getPlayer().getHealth()){
                System.out.println("Düşmanı Yendin!");
                System.out.println(this.getMonster().getAward() + " para kazandınız!");
                this.getPlayer().setMoney(this.getPlayer().getMoney() + this.getMonster().getAward());
                System.out.println("Güncel Paranız : " + this.getPlayer().getMoney());
            }else {
                return false;
            }
        }
        return true;
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

    public void monsterStats(int i){
        System.out.println((i+1) + ". " + this.getMonster().getName() + "nın Değerleri");
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
