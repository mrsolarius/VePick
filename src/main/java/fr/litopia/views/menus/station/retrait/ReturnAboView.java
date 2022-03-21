package fr.litopia.views.menus.station.retrait;

import fr.litopia.model.LocationAbonne;
import fr.litopia.model.LocationNonAbonne;
import fr.litopia.views.struct.api.View;
import fr.litopia.views.tinyView.ReturnLocTinyView;

public class ReturnAboView extends ReturnComonContext{
    public ReturnAboView(View view) {
        super(view);
    }

    private LocationAbonne locationAbonne;


    @Override
    protected void init() {


    }

    @Override
    protected void display() {
        System.out.println("=================");
        System.out.println("RENDRE UN VÉLO");
        System.out.println("==================");

    }

    @Override
    protected void close() {

    }
}
