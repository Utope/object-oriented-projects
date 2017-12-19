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
public class Client {
    public static void main(String[] args){
        Editor editor = new Editor();
        editor.setState("I am some contents of an editor!");
        System.out.println(editor);
        EditorMemento memento = editor.save();
        editor.setState("Oh no my state has been overwritten!");
        System.out.println(editor);
        editor.restorToState(memento); //yay my state has been restored!
        System.out.println(editor);
    }
}
