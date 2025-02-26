
package adventuregame;                       



import java.util.Random;

public class Obstacle {
    
    private String obstacleName;
    private int damage, healthy , award ,maxNumber;

    public Obstacle(String obstacleName, int damage, int healthy, int award, int maxNumber) {
        this.obstacleName = obstacleName;
        this.damage = damage;
        this.healthy = healthy;
        this.award = award;
        this.maxNumber = maxNumber;
    }
    
    public int obstacleCount(){
        Random Random = new Random();
        return Random.nextInt(this.maxNumber) +1 ;
    
    }
    
    public String getObstacleName() {
        return obstacleName;
    }

    public int getDamage() {
        return damage;
    }

    public int getHealthy() {
        return healthy;
    }

    public int getAward() {
        return award;
    }

    public int getMaxNumber() {
        return maxNumber;
    }

    public void setObstacleName(String obstacleName) {
        this.obstacleName = obstacleName;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setHealthy(int healthy) {
        this.healthy = healthy;
    }

    public void setAward(int award) {
        this.award = award;
    }

    public void setMaxNumber(int maxNumber) {
        this.maxNumber = maxNumber;
    }

 
    
    

   
}
