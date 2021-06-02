/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programming2;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author OWNER 2
 */
public class Player {

    private static Player p = null;
    private int Score;
    ArrayList<Observer> observers = new ArrayList<Observer>();
    
    public int getScore() {
        return Score;
    }
   
    

    public void attach(Observer o) {
        System.out.println("inside add");
        observers.add(o);
                System.out.println(observers.size());

        
    }

    public void notifyAllObservers() {
        System.out.println(observers.size());
        for (int i = 0; i < observers.size(); i++) {
            System.out.println("inside observers");
            observers.get(i).Update();
        }
    }

    public void setScore(int Score) {
        this.Score = Score + Score;
        notifyAllObservers();
    }

    private Player() {
        
    }

    public static Player getInstance() {
        if (p == null) {
            p= new Player();
            return p;
        }
        return p;
    }

}
