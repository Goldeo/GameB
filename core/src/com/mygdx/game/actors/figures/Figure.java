package com.mygdx.game.actors.figures;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;
import com.mygdx.game.actors.panels.Field;
import com.mygdx.game.actors.panels.Panel;
import com.mygdx.game.listeners.MyDragListener;

/**
 * Created by Sergey on 05.10.2016.
 */

public abstract class Figure extends Group {

    protected Panel panel;
    protected float width;
    protected float height;
    protected static final float PADDING_Y = 30;
    protected static final float SPACING = 2;
    protected static final float PANEL_SPACING = SPACING + Panel.LENGTH;
    private Field field;
    private Vector2 standardPosition = new Vector2();
    private MoveToAction moveToAction = new MoveToAction();

    public Figure(Field field) {
        this.field = field;
        addListener(new MyDragListener(this));
    }

    public static Figure create(int type, Field field) {
        switch (type) {
            case 0:
                return new FigureAqua(field);
            case 1:
                return new FigureBlue1(field);
            case 2:
                return new FigureBlue2(field);
            case 3:
                return new FigureBlue3(field);
            case 4:
                return new FigureBlue4(field);
            case 5:
                return new FigureGreen1(field);
            case 6:
                return new FigureGreen2(field);
            case 7:
                return new FigureGreen3(field);
            case 8:
                return new FigureGreen4(field);
            case 9:
                return new FigureLime(field);
            case 10:
                return new FigureOrange1(field);
            case 11:
                return new FigureOrange2(field);
            case 12:
                return new FigurePink1(field);
            case 13:
                return new FigurePink2(field);
            case 14:
                return new FigurePurple(field);
            case 15:
                return new FigureRed1(field);
            case 16:
                return new FigureRed2(field);
            case 17:
                return new FigureYellow1(field);
            case 18:
                return new FigureYellow2(field);
            default:
                return new FigurePurple(field);
        }
    }

    public void setStandartPosition() {
        standardPosition.set(getX(), getY());
    }

    public void goToStandardPosition() {
        moveToAction.setPosition(standardPosition.x, standardPosition.y);
        moveToAction.setDuration(0.2f);

        for (Actor panel: getChildren()) {
            ((Panel) panel).decSize();
        }

        moveToAction.restart();
        addAction(moveToAction);
    }

    public void incSize() {
        for (Actor panel: getChildren()) {
            ((Panel) panel).incSize();
        }
    }

    /*public boolean isInsideField() {
        for (Actor: panel
             ) {

        }
    }*/

    public void stickFigure() {

    }

}
