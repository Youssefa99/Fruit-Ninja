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
public interface GameObject {

    public int getXLocation();

    public void slice();

    public boolean isSliced();

    public int getYLocation();

    public void setXLocation(int x);

    public void setYLocation(int xy);

    public ImageIcon getObjectImage();

    public boolean isMovingUp();

    public void setMovingup(boolean movingUp);


    public int getVelocity();
    public boolean isDangerous();
    public boolean isFatal();
    public boolean isApple();
    public boolean isOrange();
    public boolean notSliced();
}
