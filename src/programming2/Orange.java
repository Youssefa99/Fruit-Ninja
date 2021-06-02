/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programming2;

import javax.swing.ImageIcon;

/**
 *
 * @author OWNER 2
 */
public class Orange implements GameObject {

    int xloc, yloc;
    boolean sliced=false;
    boolean movingup = true;
    boolean isFatal = false;
    boolean isDangerous =  false;
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
        ImageIcon i = new ImageIcon("Webp.net-resizeimage (5).png");
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
        return 20;
    }
    public boolean isDangerous(){
        return false;
    }
    public boolean isFatal(){
        return false;
    }
     public boolean isApple(){
        return false;
    }
    public boolean isOrange(){
        return true;
    }
    public boolean notSliced(){
        return false;
    }
    
}
