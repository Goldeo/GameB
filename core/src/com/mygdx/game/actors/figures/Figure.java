package com.mygdx.game.actors.figures;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;
import com.mygdx.game.actors.panels.Cell;
import com.mygdx.game.actors.panels.Field;
import com.mygdx.game.actors.panels.Panel;
import com.mygdx.game.listeners.MyDragListener;
import com.mygdx.game.screens.PlayScreen;

import java.util.ArrayList;

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

    private PlayScreen screen;
    private Field field;
    private Vector2 standardPosition = new Vector2();
    private MoveToAction moveToAction = new MoveToAction();

    public Figure(PlayScreen screen) {
        this.screen = screen;
        this.field = screen.getField();
        toFront();
        addListener(new MyDragListener(screen, this));
    }

    public int getChildrenCount() {
        return getChildren().size;
    }

    public static Figure create(int type, PlayScreen screen) {
        switch (type) {
            case 0:
                return new FigureAqua(screen);
            case 1:
                return new FigureBlue1(screen);
            case 2:
                return new FigureBlue2(screen);
            case 3:
                return new FigureBlue3(screen);
            case 4:
                return new FigureBlue4(screen);
            case 5:
                return new FigureGreen1(screen);
            case 6:
                return new FigureGreen2(screen);
            case 7:
                return new FigureGreen3(screen);
            case 8:
                return new FigureGreen4(screen);
            case 9:
                return new FigureLime(screen);
            case 10:
                return new FigureOrange1(screen);
            case 11:
                return new FigureOrange2(screen);
            case 12:
                return new FigurePink1(screen);
            case 13:
                return new FigurePink2(screen);
            case 14:
                return new FigurePurple(screen);
            case 15:
                return new FigureRed1(screen);
            case 16:
                return new FigureRed2(screen);
            case 17:
                return new FigureYellow1(screen);
            case 18:
                return new FigureYellow2(screen);
            default:
                return new FigurePurple(screen);
        }
    }

    public void repositionPanels() {
        for (Actor panel: getChildren()) {
            ((Panel) panel).setRectangleBounds();
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

    public void check() {
        int n = 0;
        ArrayList<Panel> panels = new ArrayList<Panel>();
        ArrayList<Cell> cells = new ArrayList<Cell>();

        panels.clear();
        cells.clear();

        for (Actor panel: getChildren()) {
            for (Actor cell: field.getChildren()) {
                if (((Panel) panel).isInsideCell(((Cell)cell))) {
                    ++n;
                    panels.add((Panel) panel);
                    cells.add((Cell) cell);
                    break;
                }
            }
        }

        if (getChildrenCount() == n) {
            stickFigure(panels, cells);
        }
        else
            goToStandardPosition();
    }

    private void stickFigure(ArrayList<Panel> panels, ArrayList<Cell> cells) {
        for (int i = 0; i < panels.size(); ++i) {
            panels.get(i).stickPanel(cells.get(i));
        }


        getParent().removeActor(this);
        setTouchable(Touchable.disabled);
        screen.getFigureGroup().setFigures();
    }
}
