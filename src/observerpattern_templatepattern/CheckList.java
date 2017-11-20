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
public class CheckList {
    public void byTheNumbers(){
        localize();
        isolate();
        identify();
    }
    
    protected void localize(){
        System.out.println("establish a permieter");
    }
    
    protected void isolate(){
        System.out.println("isolate the grid");
    }
    
    protected void identify(){
        System.out.println("identify the source");
    }
}
