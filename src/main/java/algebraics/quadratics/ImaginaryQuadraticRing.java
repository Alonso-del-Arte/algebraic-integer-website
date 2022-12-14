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
package algebraics.quadratics;

/**
 * Defines objects to represent imaginary quadratic rings.
 * @author Alonso del Arte
 */
public class ImaginaryQuadraticRing extends QuadraticRing {

    private static final long serialVersionUID = 4547847535800105779L;

    /**
     * Indicates that this ring is not purely real. This ring contains purely 
     * imaginary numbers as well as complex numbers, in addition to purely real 
     * integers.
     * @return Always false, since this is an imaginary quadratic ring.
     */
    @Override
    public final boolean isPurelyReal() {
        return false;
    }

    /**
     * This function is included strictly only to simplify inheritance from 
     * {@link QuadraticRing} to {@link RealQuadraticRing}.
     * @return Nothing, ever.
     * @throws UnsupportedOperationException Always thrown, because a floating 
     * point number can't represent a purely imaginary number. If you need the 
     * square root of the radicand divided by <i>i</i>, use {@link
     * #getAbsNegRadSqrt() getAbsNegRadSqrt()} instead.
     */
    @Override
    public double getRadSqrt() {
        String excMsg = "Since the radicand is negative, sqrt(" + this.radicand
                + ") requires an object that can represent an imaginary number";
        throw new UnsupportedOperationException(excMsg);
    }

    /**
     * Gives a numeric approximation of the square root of the absolute value of 
     * the radicand. For imaginary quadratic rings, use this function instead of 
     * {@link #getRadSqrt()}.
     * @return A numeric approximation of &radic;<i>d</i>/<i>i</i>. For example, 
     * for <b>Z</b>[&radic;&minus;10], we see that &radic;&minus;10 = 
     * <i>i</i>&radic;10, so this function returns approximately 3.1622777.
     */
    @Override
    public int getAbsNegRad() {
        return this.absRadicand;
    }

    /**
     * Gives the numeric value of the square root of the radicand divided by the 
     * imaginary unit <i>i</i>.
     * @return A double with a rational approximation of the square root of the 
     * radicand divided by <i>i</i>. For example, for <b>Z</b>[&radic;&minus;2], 
     * this would be roughly 1.414213562373; for <b>Z</b>[&radic;&minus;3], this 
     * would be roughly 1.7320508.
     */
    @Override
    public double getAbsNegRadSqrt() {
        return this.realRadSqrt;
    }

    /**
     * Constructs a new object representing an imaginary quadratic ring.
     * @param d A squarefree, negative integer. Examples: &minus;3, &minus;58, 
     * &minus;163.
     * @throws IllegalArgumentException If <code>d</code> is 0 or positive, or 
     * negative but the multiple of a nontrivial square. For example, 3583 would 
     * cause this exception on account of being positive; &minus;12 would cause 
     * it because it's a multiple of 2<sup>2</sup>, even though it's negative.
     */
    public ImaginaryQuadraticRing(int d) {
        super(d);
        if (d > -1) {
            String excMsg = "Negative integer required for parameter d.";
            throw new IllegalArgumentException(excMsg);
        }
        this.d1mod4 = (d % 4 == -3);
    }

}
