package com.mygdx.game.actors.figures;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.mygdx.game.GameB;
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
    private int panelCountWidth;
    private int panelsCountHeight;
    private static float LOW_VOLUME = 0.2f;
    private static final float DURATION = .2f;
    static final float NO_PADDING = 0;
    static final float LITTLE_PADDING = 15;
    static final float PADDING = 20;
    static final float MEDIUM_PADDING = 25;
    static final float BIG_PADDING = 30;
    private static final float SPACING = 2;
    protected static final float PANEL_WIDTH = SPACING + Panel.LENGTH;

    private PlayScreen screen;
    private Field field;
    private Vector2 standardPosition = new Vector2();

    public Figure(PlayScreen screen) {
        this.screen = screen;
        this.field = screen.getField();
        toFront();
        addListener(new MyDragListener(this));
    }

    public int getPanelsCount() {
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

    public void setStandardPosition() {
        standardPosition.set(getX(), getY());
    }

    public void goToStandardPosition() {

        for (Actor panel: getChildren()) {
            ((Panel) panel).decSize();
        }

        addAction(Actions.moveTo(standardPosition.x, standardPosition.y, DURATION));
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

        for (Actor panel: getChildren()) {
            for (Cell cell: field.getCellsArray()) {
                if (((Panel) panel).isInsideCell((cell))) {
                    ++n;
                    panels.add((Panel) panel);
                    cells.add(cell);
                    break;
                }
            }
        }

        if (getPanelsCount() == n) {
            stickFigure(panels, cells);
            playStickSound();
        } else {
            goToStandardPosition();
            playIncapacitySound();
        }
    }

    private void stickFigure(ArrayList<Panel> panels, ArrayList<Cell> cells) {
        for (int i = 0; i < panels.size(); ++i) {
            panels.get(i).stickPanel(cells.get(i));
        }

        getParent().removeActor(this);

        setTouchable(Touchable.disabled);
        screen.getFigureGroup().setFigures();
        field.check(cells);
    }

    private void playStickSound() {
        screen.getGame().getAssetManager().get(GameB.PLASTIC_SOUND2_PATH, Sound.class).play(LOW_VOLUME);
    }

    private void playIncapacitySound() {
        screen.getGame().getAssetManager().get(GameB.SWAP_SOUND1_PATH, Sound.class).play();
    }

    protected void setSize(int panelsCountWidth, int panelsCountHeight, float paddingWidth, float paddingHeight) {
        this.panelCountWidth = panelsCountWidth;
        this.panelsCountHeight = panelsCountHeight;

        float w = panelsCountWidth * Panel.LENGTH + (panelsCountWidth - 1) * SPACING + 2 * paddingWidth;
        float h = panelsCountHeight * Panel.LENGTH + (panelsCountHeight - 1) * SPACING + 2 * paddingHeight;
        setSize(w, h);
    }
}
