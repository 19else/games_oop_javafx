package ru.job4j.chess.firuges.black;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException {
        if (!isDiagonal(position, dest)) {
            throw new ImpossibleMoveException(
                    String.format("Could not way by diagonal from %s to %s", source, dest)
            );
        }
        int size = Math.abs(dest.getX() - source.getX()) - 1;
        Cell[] steps = new Cell[size];
        int deltaX = dest.getX() - source.getX();
        int deltaY = dest.getY() - source.getY();
        int x = source.getX();
        int y = source.getY();
        for (int index = 0; index < size; index++) {
            x = x + deltaX > 0 ? 1 : -1;
            y = y + deltaY > 0 ? 1 : -1;

            steps[index] = Cell.findBy(x,y) ;
        }
        return steps;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        return Math.abs(source.getX()) != Math.abs(dest.getX())
                && Math.abs(source.getY()) != Math.abs(dest.getY());
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
