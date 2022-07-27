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
package algebraics.unary;

import algebraics.IntegerRing;
import arithmetic.PowerBasis;

public class UnaryRing implements IntegerRing {

    public static final UnaryRing Z = new UnaryRing();

    // TODO: Write tests for this
    @Override
    public int getMaxAlgebraicDegree() {
        return 0;
    }

    // TODO: Write tests for this
    @Override
    public boolean isPurelyReal() {
        return false;
    }

    // TODO: Write tests for this
    @Override
    public int discriminant() {
        return 0;
    }

    // TODO: Write tests for this
    @Override
    public PowerBasis getPowerBasis() {
        return null;
    }

    // TODO: Write tests for this
    @Override
    public String toASCIIString() {
        return null;
    }

    // TODO: Write tests for this
    @Override
    public String toTeXString() {
        return null;
    }

    // TODO: Write tests for this
    @Override
    public String toHTMLString() {
        return null;
    }

    // TODO: Write tests for this
    @Override
    public String toFilenameString() {
        return null;
    }

    private UnaryRing() {
        //
    }

}
