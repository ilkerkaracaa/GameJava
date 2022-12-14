import java.util.Scanner;

public class Player {
    private int damage;
    private int health;
    private int baseHealth;
    private int money;
    private String name;
    private String charName;
    private boolean forestFinish = false;
    private boolean riverFinish = false;
    private boolean caveFinish = false;

    private Inventory inventory;

    private Scanner input = new Scanner(System.in);

    public void selectChar(){
        GameChar[] charList = {new Samurai(), new Archer(), new Knight()};
        System.out.println("Karakterler");
        System.out.println("-----------------------------------------------------------------");
        for (GameChar gameChar : charList) {
            System.out.println("Id : "+gameChar.getId()+
                    "\t Karakter :"+gameChar.getName()+
                    "\t Hasar :"+gameChar.getDamage()+
                    "\t Sağlık :"+gameChar.getHealth()+
                    "\t Para :"+gameChar.getMoney());
        }
        System.out.println("-----------------------------------------------------------------");
        System.out.print("Lütfen bir karakter seçin : ");
        int selectChar = input.nextInt();
        switch (selectChar){
            case 1:
                initPlayer(new Samurai());
                break;
            case 2:
                initPlayer(new Archer());
                break;
            case 3:
                initPlayer(new Knight());
                break;
            default:
                System.out.println("Hata");
        }
        //System.out.println("Karakter : " + this.getCharName() + " \nHasar : " + this.getDamage() + " \nSağlık : " + this.getHealth() + " \nPara : " + getMoney());
    }

    public void initPlayer(GameChar gameChar){
        this.setDamage(gameChar.getDamage());
        this.setHealth(gameChar.getHealth());
        this.setBaseHealth(gameChar.getHealth());
        this.setMoney(gameChar.getMoney());
        this.setCharName(gameChar.getName());
    }

    public Player(String name) {
        this.name = name;
        this.inventory = new Inventory();
    }

    public void printPlayerInfo(){
        System.out.println(
                        "Silah : " +this.getInventory().getWeapon().getName() +
                        ", Zırh : " + this.getInventory().getArmor().getName() +
                        ", Bloklama : " + this.getInventory().getArmor().getBlock() +
                        ", Hasar : " + this.getTotalDamage() +
                        ", Sağlık : " + this.getHealth() +
                        ", Para : " + getMoney());

    }

    public int getTotalDamage(){
        return damage + this.getInventory().getWeapon().getDamage();
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if (health < 0){
            health = 0;
        }
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public int getBaseHealth() {
        return baseHealth;
    }

    public void setBaseHealth(int baseHealth) {
        this.baseHealth = baseHealth;
    }

    public boolean isForestFinish() {
        return forestFinish;
    }

    public void setForestFinish(boolean forestFinish) {
        this.forestFinish = forestFinish;
    }

    public boolean isRiverFinish() {
        return riverFinish;
    }

    public void setRiverFinish(boolean riverFinish) {
        this.riverFinish = riverFinish;
    }

    public boolean isCaveFinish() {
        return caveFinish;
    }

    public void setCaveFinish(boolean caveFinish) {
        this.caveFinish = caveFinish;
    }
}
