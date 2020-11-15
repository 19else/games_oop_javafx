package ru.job4j.chess;

import org.junit.Assert;
import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;
import ru.job4j.chess.firuges.black.PawnBlack;
import static org.hamcrest.core.Is.is;

public class LogicTest {

    @Test
    public void move()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        logic.move(Cell.C1, Cell.H6);
    }
    @Test
    public void testFigureNotFoundException()
        throws OccupiedCellException, FigureNotFoundException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        try {
            logic.move(Cell.E2, Cell.C3);
        } catch (FigureNotFoundException fnf) {
            Assert.assertNull(fnf.getMessage());
        }
    }
    @Test
    public void testImpossibleMoveException()
        throws OccupiedCellException, FigureNotFoundException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        try {
            logic.move(Cell.C1, Cell.H2);
        } catch (ImpossibleMoveException ime) {
            Assert.assertEquals(String.format("Could not way by diagonal from %s to %s" , Cell.C1, Cell.H2), ime.getMessage());
        }
    }
    @Test
    public void testOccupiedCell()
            throws OccupiedCellException, FigureNotFoundException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        logic.add(new PawnBlack(Cell.B2));
        try {
            logic.move(Cell.C1, Cell.H6);
        } catch (OccupiedCellException oce) {
            System.out.println(oce.getMessage());
            Assert.assertThat(Cell.B2, is(oce.getMessage()));
        }
    }
}
