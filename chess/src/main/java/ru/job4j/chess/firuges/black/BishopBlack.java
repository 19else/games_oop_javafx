package ru.job4j.chess.firuges.black;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import javax.crypto.MacSpi;

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
        int size = Math.abs(dest.getX() - source.getX()); //путь на единицу короче, это понимаю, потому что
                                                              //в индекс массива начинается с 0?
        Cell[] steps = new Cell[size]; // создаем новый массив размера сайз
        int deltaX = (dest.getX() - source.getX()) > 0 ? 1 : -1; // вычисляем разницу по Х.
        int deltaY = (dest.getY() - source.getY()) > 0 ? 1 : -1; // разницу по Y
        int x = source.getX(); // начальная точка пути по Х
        int y = source.getY(); // начальная по Y

        for (int index = 0; index < size; index++) { // Почему идем до size, а не по steps.length?
            x += deltaX;
            y += deltaY;

            steps[index] = Cell.findBy(x,y) ;// Вычисляем (Cell.findBy()) значение ячейки - С1, С3 и т.д. Так?
        }
        return steps;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        return Math.abs(dest.getX() - source.getX()) ==
                Math.abs(dest.getY() - source.getY());
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
