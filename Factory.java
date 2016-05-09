
package factory;
import java.util.Scanner;

 abstract class EnemyShip{
    private String name;
    private double speed;
    private double amtDamage;
    
    final void setName(String n){
        name=n;
    }
     String getName(){
        return name;
    }
    
    final void setDamage(double d){
        amtDamage=d;
    }
    double getDamage(){
        return amtDamage;
    }
    
    void followHeroShip(){
        System.out.println(getName()+" is following the hero!");
    }
    
    void displayEnemyShip(){
        System.out.println(getName()+" is on the screen");
    }
    
    void enemyShipShoots(){
        System.out.println(getName()+" attacks and does damage "+getDamage());
    }
    
    
}

class UFOEnemyShip extends EnemyShip{
    UFOEnemyShip(){
        setName("UFOEnemyShip");
        setDamage(20.0);
    }
}

class RocketEnemyShip extends EnemyShip{
    RocketEnemyShip(){
        setName("RocketEnemyShip");
        setDamage(10.0);
    }
}

class BigUFOEnemyShip extends UFOEnemyShip{
    public BigUFOEnemyShip(){
        setName("BigUFOEnemyShip");
        setDamage(40.0);
    }
}

class EnemyShipFactory{
    EnemyShip makeEnemyShip(String shipName){
       // EnemyShip ship=null;
        if(shipName.equals("U")){
            return new UFOEnemyShip();
        }
        if(shipName.equals("R")){
            return new RocketEnemyShip();
        }
        if(shipName.equals("B")){
            return new BigUFOEnemyShip();
        }
        
        return null;     
    }
}


public class Factory {

    /**
     * @param args the command line arguments
     */
    static void doStuffEnemy(EnemyShip E){
        E.displayEnemyShip();
        E.followHeroShip();
        E.enemyShipShoots();
    }
    public static void main(String[] args) {
        // TODO code application logic here
        EnemyShipFactory shipFactory=new EnemyShipFactory();
        EnemyShip theEnemy;
        Scanner sc=new Scanner(System.in);
        System.out.println("UFO,Rocket of Big UFO EnemyShip? (U/R/B)");
        if(sc.hasNextLine()){
        String typeofShip=sc.nextLine();
        theEnemy=shipFactory.makeEnemyShip(typeofShip);
            if(theEnemy!=null){
                doStuffEnemy(theEnemy);
            }
            else{
                System.out.println("Please enter U,R or B next time!");
            }
        }
        
    }
    
}
