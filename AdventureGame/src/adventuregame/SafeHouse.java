
package adventuregame;


public class SafeHouse extends NormalLoc{

    public SafeHouse(Player player) {
        super(player, "güvenli ev ");
       
    }
    
    public boolean getLocation(){
        player.setHealthy(player.getrHealthy());
        System.out.println("canınız fullendi.".toUpperCase());
        System.out.println("ŞU AN GÜVENLİ EV ADLI YERDESİNİZ ".toUpperCase());
        return true;
        
    }

    
}
