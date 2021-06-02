/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programming2;

/**
 *
 * @author feras
 */

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author feras
 */
public class GamePanel3  extends JPanel implements ActionListener, MouseMotionListener, MouseListener {

    GameController gcontrol;
    ArrayList<GameObject> arr = new ArrayList<>();
     
       static int score1;
    Timer t = new Timer(150, this);
    int time = 0;
    ArrayList<GameObject>bombs = new ArrayList<>();
    static int life = 3;
     static int frame;
  

    public GamePanel3() {
        gcontrol = new GameController();

        fillArray();
        addMouseMotionListener(this);
        t.start();
    }
  

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
          ImageIcon im = new ImageIcon("backgoun.png");
         g.drawImage(im.getImage(), 0, 0, this); 
//To change body of generated methods, choose Tools | Templates.
        for (int i = 0; i < arr.size(); i++) {
           if (!arr.get(i).isSliced()) {
                g.drawImage(arr.get(i).getObjectImage().getImage(), arr.get(i).getXLocation(), arr.get(i).getYLocation(), this);
                //Player.getInstance().life = Player.getInstance().loseLife(Player.getInstance().life);
                //System.out.println("kosom 7ayaty");
            }
            if(!t.isRunning()){
                
                  for (int j = 0; j < arr.size(); j++) {
            
g.drawImage(arr.get(j).getObjectImage().getImage(), 1000, 1000, this);                //Player.getInstance().life = Player.getInstance().loseLife(Player.getInstance().life);
                
            

            }
        }
    }}

    public void fillArray() {
        
        Random posX = new Random();
        Random posY = new Random();
       // int startX = posX.nextInt(800);
        //int starty = posY.nextInt(600);
        Random r = new Random();
        int m = r.nextInt(5) + 1;
        for (int i = 0; i < m; i++) {
            int startX = posX.nextInt(300);
        int starty = 300;
            GameObject go = gcontrol.CreateGameObject();
            go.setXLocation(startX);
            go.setYLocation(starty);
            //startX += 100;
            arr.add(go);
        }
        /*Random b = new Random();
        int q = b.nextInt(1);
        for(int j = 0 ; j <=q ;j++){
            int startX = posX.nextInt(800);
        int starty = 600;
            GameObject go = gcontrol.CreateBombs();
            go.setXLocation(startX);
            go.setYLocation(starty);
            //startX += 100;
            bombs.add(go);
        }*/
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        time++;
        int flag=0;
        System.out.println(life);
      //Player  p = Player.getInstance();
      Random m = new Random();
        for (int i = 0; i < arr.size(); i++) {
           
            if (arr.get(i).isMovingUp()) {
                int y = arr.get(i).getYLocation();
                y -= arr.get(i).getVelocity();
                arr.get(i).setYLocation(y);
                alterArray();
                if (y < m.nextInt(50)) {
                    arr.get(i).setMovingup(false);
                }
            } else {
                //System.out.println(arr.get(i).isMovingUp());
                int y = arr.get(i).getYLocation();
                y += arr.get(i).getVelocity();
                arr.get(i).setYLocation(y);
                alterArray();
                if(y>591){
                        if(arr.get(i).isOrange()&&arr.get(i).getYLocation()>591 && !arr.get(i).isDangerous() && !arr.get(i).isFatal()){
                        System.out.println("hena");
                        flag=1; 
                         
                    }
               arr.remove(i);
                
                }
                
            }
            if(arr.isEmpty())
                fillArray();
            
        }
        if(flag==1){
            life--;
            frame = getLife(life);
            flag=0;
        }
         for(int x = 0 ; x < arr.size() ; x++){
                    if(arr.get(x).getYLocation() == 590){
                        
                
                     //   arr.remove(x);
                //arr.get(i).setMovingup(true);
                
                    }
                     if(life==0){
                            t.stop();
                        }}
        if(life == 0)
            t.stop();
        int j;
        for(j = 0 ; j<arr.size() ; j++){
            
        }
        /* for (int i = 0; i < bombs.size(); i++) {
           
            if (bombs.get(i).isMovingUp()) {
                int y = bombs.get(i).getYLocation();
                y -= bombs.get(i).getVelocity();
                bombs.get(i).setYLocation(y);
                alterArray();
                if (y < m.nextInt(450)) {
                    bombs.get(i).setMovingup(false);
                }
            } else {
                //System.out.println(arr.get(i).isMovingUp());
                int y = bombs.get(i).getYLocation();
                y += bombs.get(i).getVelocity();
                bombs.get(i).setYLocation(y);
                alterArray();
                if(y>650)
                bombs.get(i).setMovingup(true);
                
            }
            
        }
        
        /*int count = 0;
        int x = 0;
        for(x = 0 ; x<arr.size();x++){
            if(arr.get(x).getYLocation() > 650)
                count++;
        }
        if(count == arr.size()){
            destroy();
            fillArray();
        }/*/
        repaint();
    }
    
    

    @Override
    public void mouseDragged(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        for (int i = 0; i < arr.size(); i++) {
            GameObject gc = arr.get(i);
            int xg = gc.getXLocation();
            int yg = gc.getYLocation();
            if (x >= xg && x <= xg + gc.getObjectImage().getIconWidth()&&y >= yg && y <= yg + gc.getObjectImage().getIconHeight()) {
               
                    for(int j = 0 ; j <arr.size() ; j++){
                        if(arr.get(j).getXLocation() == xg && arr.get(j).getYLocation() == yg){
                            if(arr.get(j).isDangerous()){
                               
                                life--;
                                frame = getLife(life);
                                arr.remove(j);           
                              
                            }
                           else if(arr.get(j).isFatal()){
                             life=0;
                             frame = getLife(life);
                             arr.remove(j);
                            t.stop();
                            
                        }else  {
                               arr.get(i).slice();
                               System.out.println(arr.get(i).isSliced());
                              arr.remove(j);
                                score1=score1+100;
                    System.out.println(score1);
                           }
                       
                    } 
                    }
                    
                   
                    Player.getInstance().setScore(10);
                   // arr.remove(i);
                    
                   
                        
                } 
          
                
            }
        
         if(arr.isEmpty()){
             
                fillArray();
                            }
         
        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
    public void destroy(){
        int i;
        for(i = 0 ; i<arr.size() ; i++)
            arr.remove(i);
    }
    public void alterArray(){
       Random startX = new Random();
       int x;
       x = startX.nextInt(600);
       int i;
       for(i = 0 ; i < arr.size() ; i++){
           if(arr.get(i).getYLocation() > 650)
           arr.get(i).setXLocation(x);
       }
    }
    public int getLife(int x){
        return x;
    }
            
    
}
    

