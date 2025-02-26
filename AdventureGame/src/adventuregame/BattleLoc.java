
package adventuregame;

import java.util.Scanner;


public abstract class BattleLoc extends Location {
    protected Obstacle obstacle;
    protected String award;
  
    
    Scanner scan = new Scanner(System.in);
    public BattleLoc(Player player, String name, Obstacle obstacle,String award ) { 
        super(player);
        this.name = name;
        this.obstacle=obstacle;
        this.award=award; 
    }
  
            
    public boolean getLocation(){
        int obscount=obstacle.obstacleCount();
        System.out.println("şu an da buradasınız:".toUpperCase() +  this.name.toUpperCase());
        System.out.println("burada ".toUpperCase()+ obscount + " adet ".toUpperCase() + obstacle.getObstacleName() + " BULUNMAKTADIR.");
        System.out.println("<s>avaş or <k>aç".toUpperCase());
        String select=scan.nextLine();
        String select2= select.toUpperCase();
        if(select2.equals("S")){
            if(combat(obscount)== true){// hiçbr şey yazmıyorsa true demek yani combat(obscount)== true ile aynı anlama geliyor 
                System.out.println(this.getName() + "bölgesindeki tüm düşmanları temizlediniz.".toUpperCase());
                if(this.award.equals("food") && player.getInventory().isFood()== false ){
                    System.out.println("food kazandınız");
                    player.getInventory().setFood(true);
                    
            }
                 if(this.award.equals("water ") && player.getInventory().isWater()== false ){
                    System.out.println("food kazandınız");
                    player.getInventory().setWater(true);
                    
            }
                  if(this.award.equals("firewood ") && player.getInventory().isFirewood()== false ){
                    System.out.println("food kazandınız");
                    player.getInventory().setFirewood(true);
                    
            }
              return true;
            }
            if(player.getHealthy()<=0 ){
                System.out.println("hocam öldün bi daha oyna ".toUpperCase());
                return false;
}
            
        }
        
         return true;
    }
   
    public boolean combat(int obscount){
        for( int i=0; i< obscount ;i++){
            int defObsHealth= obstacle.getHealthy();
        playerstates();
        enemystates();
        
        while(player.getHealthy()>0 && obstacle.getHealthy()>0 ){
            System.out.println("<V>ur veya <K>aç ");
            String selCase=scan.nextLine();
            selCase=selCase.toUpperCase();
            
            if(selCase.equals("V")){
                while(obstacle.getHealthy()< player.getrHealthy() ){
                System.out.println("siz vurdunuz".toUpperCase());
                obstacle.setHealthy(obstacle.getHealthy()-player.gettotalDamage());
                afterhit();
                System.out.println();
                if(obstacle.getHealthy()>= 0){
                System.out.println("canavar size vurdu.");
                player.setHealthy(player.getHealthy()- (obstacle.getDamage()- player.getInventory().getArmor()));
                afterhit();
             
                }
            }
            
            }
            else{
                return false;
            }
            
            
            if (obstacle.getHealthy()< player.getrHealthy() ) {
                System.out.println("canavar öldü.");
                player.setMoney(player.getMoney()+obstacle.getAward());
                System.out.println("toplam money :" +player.getMoney() );
                obstacle.setHealthy(defObsHealth);
                
            }
            else{
                return false;
            }
                    
        }
        }
        
        return true;
    }
    
        
        
    public void afterhit(){
             System.out.println("oyuncunun canı :"+ player.getHealthy());
             System.out.println(obstacle.getObstacleName() + " canı :" +obstacle.getHealthy());
    }
            
    public void playerstates(){
        System.out.println("oyuncu bilgileri".toUpperCase());
        System.out.println("player:".toUpperCase()+ player.getName());
        System.out.println("Player cname:".toUpperCase() +  player.getcName());
        System.out.println("player health:".toUpperCase()+ player.getHealthy());
        System.out.println("player damage.".toUpperCase()+ player.gettotalDamage());
        System.out.println("plsyer money:".toUpperCase()+ player.getMoney());
        if(player.getInventory().getDamage()>0){
            System.out.println("SİLAH:"+ player.getInventory().getwName());
        }
        if(player.getInventory().getArmor()> 0){
            System.out.println("armor".toUpperCase()+ player.getInventory().getaName());
        }
                
    }
    public void enemystates(){
        System.out.println(obstacle.getObstacleName() + "BİLGİLERİ");
        System.out.println("health:".toUpperCase() + obstacle.getHealthy() );
        System.out.println("damage :".toUpperCase()+ obstacle.getDamage());
        System.out.println("AWARD:" + obstacle.getAward());
        
    }
    
   
}
