
package adventuregame;


public abstract class Location {
  protected Player player;
  protected String name ;
    
    
     public Location(Player player){
         this.player=player;
     }
     
     
    public abstract boolean getLocation(); 

    public Player getPlayer(){
        return player;
    }

    public String getName() {
        return name;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setName(String name) {
        this.name = name;
    }
     
}
