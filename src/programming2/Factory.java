/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programming2;

/**
 *
 * @author OWNER 2
 */
public class Factory {
    public GameObject getGameObject(String oname)
    {
        if(oname.equals("apple"))
            return new Apple();
        if(oname.equals("orange"))
            return new Orange();
        if(oname.equals("dangerousbomb"))
            return new DangerousBombs();
        if(oname.equals("fatalbombs"))
            return new FatalBombs();
        
        return null;
    }
}
