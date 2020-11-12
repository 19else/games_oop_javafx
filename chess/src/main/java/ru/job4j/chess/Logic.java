package ru.job4j.chess;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import java.util.Arrays;

/**
 * //TODO add comments.
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class Logic {
    private final Figure[] figures = new Figure[32];
    private int index = 0;

    public void add(Figure figure) {
        this.figures[this.index++] = figure;
    }

    public void move(Cell source, Cell dest)
            throws FigureNotFoundException, ImpossibleMoveException, OccupiedCellException {
        int index = this.findBy(source);
        Cell[] steps = this.figures[index].way(source, dest);
        if (!isFree(steps)) {
            throw new OccupiedCellException();
        }
        this.figures[index] = this.figures[index].copy(dest);
    }

    private boolean isFree(Cell[] steps) {
         {
            for (int i = 0; i != this.figures.length ; i++) { // проход по массиву с фигурами
                for (int j = 0; j != steps.length; j++) {     // проход по массиву пути движения фигуры?
                    if (this.figures[i] != null && this.figures[i].position().equals(steps[j])){
                        return false;
                    } // проверка this.figures[index] != null в ячейке есть фигура
                }     // проверка this.figures[index].position().equals(steps) на пути движения нет фигур?
            }

         }
        return true;
    }

    public void clean() {
        Arrays.fill(this.figures, null);
        this.index = 0;
    }

    private int findBy(Cell cell) throws FigureNotFoundException {
        for (int index = 0; index != this.figures.length; index++) {
            if (this.figures[index] != null && this.figures[index].position().equals(cell)) {
                return index;
            }
        }
        throw new FigureNotFoundException();
    }


    }

