package fr.litopia.views.struct.impl;

import fr.litopia.views.struct.api.ViewContext;

import java.util.HashMap;

public class ViewContextImpl implements ViewContext {
    private final String name;
    private final HashMap<String,Object> context;

    public ViewContextImpl(String name) {
        this(name, new HashMap<>());
    }

    public ViewContextImpl(String name, HashMap<String,Object> context) {
        this.name = name;
        this.context = context;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public HashMap<String, Object> getContext() {
        return this.context;
    }





}
