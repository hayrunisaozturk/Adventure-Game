
package adventuregame;

import java.util.Scanner;

public class Game {
    private Player player;                 
    private Location location;
    
    Scanner scan=new Scanner(System.in);
    public void login(){
        
        System.out.println("Macera  Oyununa Hoşgeldiniz!".toUpperCase());
        System.out.print("Kullanıcı adınızı giriniz!\nKullanıcı Adı:".toUpperCase());
        String playerName= scan.nextLine();
        player = new Player(playerName);
                                        
                                        
        player.selectCha();
        start();
        
    }
    int selectLoc;
    public void start (){
        while(true){
        System.out.println("");
        System.out.println("***********************");
        System.out.println("");
        System.out.println("Bir yer seçiMİ YAPINIZ".toUpperCase());
        System.out.println("1.güvenli ev: Size ait güvenli mekan, düşman yok.".toUpperCase());
        System.out.println("2.mağara: zombi çıkabilir.".toUpperCase());
        System.out.println("3.orman: vampir çıkabilir.".toUpperCase());
        System.out.println("4.nehir: ayı çıkabilir.".toUpperCase());
        System.out.println("5.mağaza: silah veya zırh alabilirsin.".toUpperCase());
        System.out.print("yer seçiminiz:".toUpperCase());
        int selectloc = scan.nextInt();
        
        
          while (selectloc < 1 || selectloc > 5) {
            System.out.println("Geçersiz numara".toUpperCase());
            System.out.println("");
            System.out.print("Bir yer seçiniz".toUpperCase());
          
            selectloc = scan.nextInt();
        }
        
          switch (selectloc) {
            case 1:
                location= new SafeHouse(player);
                                                
               break;
            case 2:
                location =new Cave(player);
               break;
            case 3:
                location=new Forest(player);
                break;
            case 4:
                location = new River(player);
                break;
            case 5: 
                location=new ToolStore(player);
               default:
                location= new SafeHouse(player); 
                break;
            
        }
        if(player.getInventory().isFirewood()== true && player.getInventory().isFood() == true && player.getInventory().isWater()== true  ){
            System.out.println("Oyunu Başarıyla tammaladınız.".toUpperCase());
            
        }
        if(location.getLocation()== false){
            System.out.println("oyun bitti".toUpperCase());
            break;
                   }
        
    }
    }
}
