/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programming2;

import javax.swing.ImageIcon;

/**
 *
 * @author feras
 */
public class FatalBombs implements GameObject{
     int xloc, yloc;
    boolean sliced=false;
    boolean movingup = true;
    boolean isFatal = true;

    @Override
    public int getXLocation() {
        return xloc;
    }

    @Override
    public void slice() {
        sliced = true;
    }

    @Override
    public int getYLocation() {
        return yloc;
    }

    @Override
    public void setXLocation(int x) {
        this.xloc = x;
    }

    @Override
    public void setYLocation(int y) {
        this.yloc = y;
    }

    @Override
    public ImageIcon getObjectImage() {
        ImageIcon i = new ImageIcon("bomb2.png");
        return i;
    }

    @Override
    public boolean isSliced() {
        return sliced;
    }

    @Override
    public boolean isMovingUp() {
        return movingup;
    }

    @Override
    public void setMovingup(boolean movingUp) {
        this.movingup = movingUp;
    }

    @Override
    public int getVelocity() {
        return 10;
    }
    public boolean isDangerous(){
        return false;
    }
    public boolean isFatal(){
        return true;
    }
      public boolean isApple(){
        return false;
    }
    public boolean isOrange(){
        return false;
    }
    public boolean notSliced(){
        return false;
    }
    
}
