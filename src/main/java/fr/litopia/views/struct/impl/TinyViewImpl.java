package fr.litopia.views.struct.impl;

import fr.litopia.views.struct.api.TinyView;

public abstract class TinyViewImpl<T> implements TinyView<T> {
    private boolean cancele = false;

    public TinyViewImpl() {
        init();
    }

    @Override
    public T startAndGetValue(){
        T value = null;
        while (value==null && !cancele){
            display();
            value = getValue();
            clean();
        }
        if (cancele){
            value = null;
        }
        clean();
        return value;
    }

    protected abstract void init();

    protected abstract void display();

    protected abstract T getValue();

    protected void clean(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    protected void cancel(){
        System.out.println("Canceled");
        cancele = true;
    }
}
