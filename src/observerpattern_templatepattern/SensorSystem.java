/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package observerpattern_templatepattern;

import java.util.ArrayList;

/**
 *
 * @author robert
 */
public class SensorSystem {
    ArrayList<AlarmListener> listeners = new ArrayList<>();
    
    public void soundTheAlarm(){
        for(AlarmListener listener: listeners){
            listener.alarm();
        }
    }
    
    public void register(AlarmListener listener){
        listeners.add(listener);
    }
}
