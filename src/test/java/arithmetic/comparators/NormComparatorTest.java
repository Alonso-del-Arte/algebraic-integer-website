/*
 * Copyright (C) 2021 Alonso del Arte
 *
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 *
 * You should have received a copy of the GNU General Public License along with
 * this program. If not, see <http://www.gnu.org/licenses/>.
 */
package arithmetic.comparators;

import algebraics.AlgebraicInteger;
import algebraics.quadratics.ImaginaryQuadraticInteger;
import algebraics.quadratics.ImaginaryQuadraticRing;
import algebraics.quadratics.RealQuadraticInteger;
import algebraics.quadratics.RealQuadraticRing;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test of the NormComparator class. These tests use no algebraic integers of
 * algebraic degree higher than 2.
 * @author Alonso del Arte
 */
class NormComparatorTest {

    /**
     * The ring <b>Z</b>[&radic;&minus;2], the ring of algebraic integers of
     * <b>Q</b>(&radic;&minus;2).
     */
    private static final ImaginaryQuadraticRing RING_ZI2
            = new ImaginaryQuadraticRing(-2);

    /**
     * The ring <b>Z</b>[<i>i</i>], the ring of algebraic integers of
     * <b>Q</b>(<i>i</i>).
     */
    private static final ImaginaryQuadraticRing RING_GAUSSIAN
            = new ImaginaryQuadraticRing(-1);

    /**
     * The ring <b>Z</b>[&radic;2], the ring of algebraic integers of
     * <b>Q</b>(&radic;2).
     */
    private static final RealQuadraticRing RING_Z2 = new RealQuadraticRing(2);

    /**
     * The number 14 &minus; 10&radic;2, which has norm &minus;4.
     */
    private static final RealQuadraticInteger NORM_NEG_4_NUMBER
            = new RealQuadraticInteger(14, -10, RING_Z2);

    /**
     * The number &radic;3, which has norm &minus;3.
     */
    private static final RealQuadraticInteger NORM_NEG_3_NUMBER
            = new RealQuadraticInteger(0, 1, new RealQuadraticRing(3));

    /**
     * The number &radic;2, which has norm &minus;2.
     */
    private static final RealQuadraticInteger NORM_NEG_2_NUMBER
            = new RealQuadraticInteger(0, 1, RING_Z2);

    /**
     * The number &minus;1 + &radic;2, which has norm &minus;1.
     */
    private static final RealQuadraticInteger NORM_NEG_1_NUMBER
            = new RealQuadraticInteger(-1, 1, RING_Z2);

    /**
     * The number 0 presented as an imaginary quadratic integer from the ring
     * <b>Z</b>[&radic;&minus;2]. Regardless of the ring, it has norm 0.
     */
    private static final ImaginaryQuadraticInteger NORM_0_NUMBER
            = new ImaginaryQuadraticInteger(0, 0, RING_GAUSSIAN);

    /**
     * The number <i>i</i> such that <i>i</i><sup>2</sup> = &minus;1, which has
     * norm 1..
     */
    private static final ImaginaryQuadraticInteger NORM_1_NUMBER
            = new ImaginaryQuadraticInteger(0, 1, RING_GAUSSIAN);

    /**
     * The number &radic;&minus;2, which has norm 2.
     */
    private static final ImaginaryQuadraticInteger NORM_2_NUMBER
            = new ImaginaryQuadraticInteger(0, 1, RING_ZI2);

    /**
     * The number 1 + &radic;&minus;2, which has norm 3.
     */
    private static final ImaginaryQuadraticInteger NORM_3_NUMBER
            = new ImaginaryQuadraticInteger(1, 1, RING_ZI2);

    /**
     * Test of compare method, of class NormComparator.
     */
    @Test
    public void testCompare() {
        System.out.println("compare");
        ArrayList<AlgebraicInteger> expected = new ArrayList<>();
        expected.add(NORM_NEG_4_NUMBER);
        expected.add(NORM_NEG_3_NUMBER);
        expected.add(NORM_NEG_2_NUMBER);
        expected.add(NORM_NEG_1_NUMBER);
        expected.add(NORM_0_NUMBER);
        expected.add(NORM_1_NUMBER);
        expected.add(NORM_2_NUMBER);
        expected.add(NORM_3_NUMBER);
        ArrayList<AlgebraicInteger> actual = new ArrayList<>();
        actual.add(NORM_3_NUMBER);
        actual.add(NORM_NEG_3_NUMBER);
        actual.add(NORM_0_NUMBER);
        actual.add(NORM_2_NUMBER);
        actual.add(NORM_NEG_1_NUMBER);
        actual.add(NORM_NEG_4_NUMBER);
        actual.add(NORM_1_NUMBER);
        actual.add(NORM_NEG_2_NUMBER);
        actual.sort(new NormComparator());
        assertEquals(expected, actual);
    }

    /**
     * Another test of compare method, of class NormComparator.
     */
    @Test
    public void testCompareReversed() {
        ArrayList<AlgebraicInteger> expected = new ArrayList<>();
        expected.add(NORM_3_NUMBER);
        expected.add(NORM_2_NUMBER);
        expected.add(NORM_1_NUMBER);
        expected.add(NORM_0_NUMBER);
        expected.add(NORM_NEG_1_NUMBER);
        expected.add(NORM_NEG_2_NUMBER);
        expected.add(NORM_NEG_3_NUMBER);
        expected.add(NORM_NEG_4_NUMBER);
        ArrayList<AlgebraicInteger> actual = new ArrayList<>();
        actual.add(NORM_3_NUMBER);
        actual.add(NORM_NEG_3_NUMBER);
        actual.add(NORM_0_NUMBER);
        actual.add(NORM_2_NUMBER);
        actual.add(NORM_NEG_1_NUMBER);
        actual.add(NORM_NEG_4_NUMBER);
        actual.add(NORM_1_NUMBER);
        actual.add(NORM_NEG_2_NUMBER);
        actual.sort(new NormComparator().reversed());
        assertEquals(expected, actual);
    }

}
