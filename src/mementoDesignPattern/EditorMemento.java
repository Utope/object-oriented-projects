/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mementoDesignPattern;

/**
 *
 * @author robert
 */
public class EditorMemento {
    private String editorState;
    
    public EditorMemento(String editorState){
        this.editorState = editorState;
    }
    
    public String getSavedState(){
        return this.editorState;
    }
}
