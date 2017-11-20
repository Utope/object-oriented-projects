/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package observerpattern_templatepattern;

/**
 *
 * @author robert
 */
public class Gates implements AlarmListener {

    @Override
    public void alarm() {
        System.out.println("gates close");
    }
    
}
