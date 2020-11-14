package ru.job4j.chess.firuges.black;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import javax.swing.text.Position;

import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BishopBlackTest {
    @Test
    public void testPosition() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1); //Создал объект
        Cell checkPosition = bishopBlack.position(); // Вызвал метод position
        Assert.assertEquals(checkPosition, (Cell.C1)); // Проверяю, что Cell position == ячейке создания
                                                       // Я думаю, что тут ерунда получается, т.к. я сравниванию
                                                       // мной заданные значения друг с другом и они не могут
                                                       // быть разными, если я этого сам не захочу. Метод position
                                                       // только возвращает заданное значение. Либо я не понимаю
    }

    @Test
    public void testCopy() {
        BishopBlack black = new BishopBlack(Cell.C1);
        // ctrl+alt+v
        Figure figure = black.copy(Cell.D5);
        assertThat(figure.position(), is(Cell.D5));
    }
    @Test
    public void testIsDiagonalTrue() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
         assertThat(bishopBlack.isDiagonal(Cell.C1, Cell.B2), is(true));

    }
    @Test
    public void testIsDiagonalFalse() {
        BishopBlack black = new BishopBlack(Cell.C1);
        assertThat(black.isDiagonal(Cell.C1, Cell.C3), is(false));
    }
    @Test
    public void testIsWay() throws ImpossibleMoveException {
        BishopBlack black = new BishopBlack(Cell.C1);
        System.out.println(Arrays.toString(black.way(Cell.C1, Cell.G5)));
        Cell[] rsl = new Cell[] {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertThat(black.way(Cell.C1, Cell.G5), is(rsl));
    }
}