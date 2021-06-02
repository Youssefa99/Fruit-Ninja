/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programming2;

import java.util.Random;

/**
 *
 * @author OWNER 2
 */
public class GameController implements GameActions {

    Factory f = new Factory();

    @Override
    public GameObject CreateGameObject() {
        Random r = new Random();
        int m = r.nextInt(4);
        if (m == 0) {
            return f.getGameObject("apple");
        } 
        else if(m == 1)  {
            return f.getGameObject("orange");
        }
        else if(m == 2)
    return f.getGameObject("dangerousbomb");
else if(m == 3)
     return f.getGameObject("fatalbombs");

        return null;
    }
   /*/ public GameObject CreateBombs(){
                Random r = new Random();
int m = r.nextInt(2);
if(m == 0)
    return f.getGameObject("dangerousbomb");
else if(m == 1)
     return f.getGameObject("fatalbombs");
    return null;
        
    }/*/

}
