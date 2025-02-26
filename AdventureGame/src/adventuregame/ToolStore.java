
package adventuregame;

import java.util.Scanner;


public class ToolStore extends NormalLoc{
    private String weaponname , zırhname;
    private int damage ,money;

   
    Scanner scan = new Scanner(System.in);
    public ToolStore(Player player) {
        super(player, "Mağaza ");
    }
    
    @Override
    public boolean getLocation(){
        System.out.println("PARA:" + player.getMoney());
        System.out.println("1.silahlar".toUpperCase());
        System.out.println("2.zırh".toUpperCase());
        System.out.println("3.çıkış:");
        System.out.println("SEÇİNİZ".toUpperCase());
       int selTool=scan.nextInt();
       
        switch (selTool) {
            case 1:
              int selItemID= weaponMenu();
                buyMenu(selItemID);
                break;
            case 2:
                int selectarm= armorMenu();
                buyarmor(selectarm);
                break;
            case 3: 
                System.out.println("çıkış yapıldı");
                break;
            default:
                break;
              
        }
       
         return true ;
    }
    
    public int armorMenu(){
        System.out.println("select your armor ");
        System.out.println("1.hafif armor:   engelleme:1    para:15");
         System.out.println("2.orta armor:   engelleme:3    para:25");
          System.out.println("3.ağır armor:   engelleme:5    para:40");
          System.out.println("4.çıkış");
          int selectarmor=scan.nextInt();
          return selectarmor;
          
    }
    
    public void  buyarmor(int selectarm ){
        int armor=0;
        String aName=null;
        int price=0;
        switch(selectarm){
            case 1: 
                armor = 1;
                aName="hafif";
                price=15;
                break;
            case 2:
                armor = 3;
                aName= "orta";
                price = 25;
                break;
            case 3:
                armor = 5;
                aName= "ağır";
                price = 40;
                break;
            case 4:
                System.out.println("siistemden çıkış yapıldı.");
                break;
            
        }
        if(player.getMoney()>0){
        if (player.getMoney()>= price){
            player.getInventory().setArmor(armor);
            player.getInventory().setaName(aName);
            player.setMoney(player.getMoney()-price);
            System.out.println("kalan para:" + player.getMoney());
            System.out.println("engellenen hasar:"+ player.getInventory().getArmor());
             
        }
        else{
            System.out.println("zırhı alacak para yok.");
        }
}
        else{
                
         }
        
    }
    
    public int weaponMenu(){
        
        System.out.println("Select your weapon".toUpperCase());
        System.out.println("1.tabanca: hasar: 2 para: 25 ".toUpperCase());
        System.out.println("2.kılıç: hasar :3  para: 35".toUpperCase());
        System.out.println("3.tüfek: hasar:7 para: 45 ".toUpperCase());
        System.out.println("4.çıkış:");
        
        int selweaponID= scan.nextInt();
        return selweaponID;
        
    }
    
    public void buyMenu(int itemID ){
        int damage = 0; 
        int price=0;
        String wName =null;
        if (itemID >0 || itemID< 5){
            switch(itemID){
                case 1:
                    damage= 2;
                    wName="TABANCA";
                    price= 5;
                    break;
                case 2:
                    damage= 3;
                    wName="kılıç";
                    price= 35;
                    break;
                case 3:
                    damage= 7;
                    wName="tüfek";
                    price= 45;
                    break;
                case 4:
                    System.out.println("çıkış yapıldı.");
                    break;
                    default:
                        System.out.println("yanlış numara seçimi.");
                        break;
                            
            }
            if(price>0){
            if ( player.getMoney()>= price){
           player.getInventory().setDamage(damage);
           player.getInventory().setwName(wName);
           player.setMoney(player.getMoney()-price);
          // aplayer.setDamage(player.getDamage()+ player.getInventory().getDamage());
               System.out.println( wName + "silahı satın aldınız.".toUpperCase()+ "       önceki hasar:".toUpperCase() +player.getDamage() + "    yeni hasar :".toUpperCase()+ player.gettotalDamage());
                System.out.println("kalan bakiye: ".toUpperCase()+ player.getMoney());
            }
            else{
                System.out.println("para yetmiyor hacı ".toUpperCase());
            }
        
        }
            else{
                
            }
        
    }

  }

    public int getDamage() {
        return damage;
    }

    public int getMoney() {
        return money;
    }

    public String getWeaponname () {
        return weaponname;
    }
      
    public String getZırhname() {
        return zırhname;
    }

    public void setWeaponname(String weaponname) {
        this.weaponname = weaponname;
    }

    public void setZırhname(String zırhname) {
        this.zırhname = zırhname;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
 /*   int selectweapon;
  
    public void selectweaponn(){

        switch (selectweapon) {
            case 1:
                selectweapon2("tabanca" , 2, 25);
               
            case 2:
                selectweapon2("kılıç", 3, 35);
            case 3:
                selectweapon2("tüfek", 7, 45);  
        }
         System.out.println("your choise:" +  getWeaponname() + "hasar:" + getDamage() + "money:" + getMoney());
    }
    
    public int weaponmenu(){
        
        System.out.println("Select your weapon".toUpperCase());
        System.out.println("1.tabanca: hasar: 2 para: 25 ".toUpperCase());
        System.out.println("2.kılıç: hasar :3  para: 35".toUpperCase());
        System.out.println("3.tüfek: hasar:7 para: 45 ".toUpperCase());
        System.out.println("4.çıkış:");
        
        selectweapon= scan.nextInt();
        
        while( selectweapon<1 || selectweapon> 4 ){
            System.out.println(" geçersiz ".toUpperCase());
            System.out.println("your choise:".toUpperCase());
            selectweapon= scan.nextInt();
        }
         return selectweapon;
        
    }
    public void selectweapon2(String weaponname ,int damage , int money){
        setDamage(damage);
        setMoney(money);
        setWeaponname(weaponname);
        
    }
*/
    
    
    
    
    
    
}
