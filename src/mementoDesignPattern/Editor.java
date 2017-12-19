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
public class Editor {
    private String editorContents;
    
    public Editor(){
        
    }
    
    public void setState(String contents){
        this.editorContents = contents;
    }
    
    public EditorMemento save(){
        return new EditorMemento(editorContents);
    }
    
    public void restorToState(EditorMemento memento){
        this.editorContents = memento.getSavedState();
    }
    
    @Override
    public String toString(){
        return this.editorContents;
    }
}
