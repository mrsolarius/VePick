package fr.litopia.view;

import fr.litopia.controler.Controler;

public abstract class ViewWithControler<T> extends View{
    protected Controler controler;
    T getCastedControler(){
        return (T) this.controler;
    }
}
