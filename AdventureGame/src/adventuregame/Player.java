package adventuregame;

import java.util.Scanner;

class Player {
    private int damage,healthy,money,rHealthy;
    private String name,cName;
    private Inventory inventory;
   
    Scanner scan= new Scanner(System.in);
    public Player(String name  ){
        this.name=name;
        this.inventory=new Inventory();
        
        
    }
    
    public void selectCha(){
        switch(chaMenu()){
            case 1:
                initPlayer ( "samuray ", 5, 21, 15);
                break;
            case 2:
               initPlayer ( "okçu ", 7, 18, 20);
                break;
            case 3:
                 initPlayer ( "şövalye  ", 8, 24, 5);
                break;
            default:
                initPlayer ( "samuray ", 5, 21, 15);
                break;
        }
        System.out.println("KARAKTERINIZ: "+ getcName().toUpperCase()+"  Hasar:".toUpperCase()+ getDamage() + "  sağlık:".toUpperCase()+  getHealthy()+ "   PARA:" + getMoney());
    }
    
 
    public int chaMenu(){
        System.out.println("Karakter seçimi yapınız: ".toUpperCase());
        System.out.println("1.samuray:   hasar:5   sağlık :21   para:15 ".toUpperCase());
        System.out.println("2.OKÇU:      hasar:7   sağlık :18   para:20 ".toUpperCase());
        System.out.println("3.ŞÖVALYE:   hasar:8   sağlık :24   para:5 ".toUpperCase());
        System.out.print("karakter seçiminiz: ".toUpperCase());
        
        int chaID= scan.nextInt();
        
        
        while ( chaID < 1|| chaID> 3 ){
            System.out.println("Lütfen geçerli bir karakter seçimi yapınız!".toUpperCase());
            System.out.print("karakter seçiminiz: ".toUpperCase());
            chaID= scan.nextInt();
        }
          return chaID;
        
    }
    
    public void initPlayer (String name , int dmg , int health , int money){
        setcName(name);
        setDamage(dmg);
        setHealthy(health);
        setMoney(money);
        setrHealthy(health);
    }
       
    public int gettotalDamage(){// toplam damage ı her yerde kullanacağım için bu şekilde göstermiş olduk.
       return  this.getDamage()+ this.getInventory().getDamage();
    }

    public int getDamage() {
        return damage;
    }

    public int getHealthy() {
        return healthy;
    }
 
    public int getMoney() {
        return money;
    }

    public String getName() {
        return name;
    }

    public String getcName() {
        return cName;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setHealthy(int healthy) {
        this.healthy = healthy;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public int getrHealthy() {
        return rHealthy;
    }

    public void setrHealthy(int rHealthy) {
        this.rHealthy = rHealthy;
    }
    
}