/*
 * Copyright (c) 2016 Jan Krüger
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package de.SweetCode.Tier.Service;

import de.SweetCode.Tier.Match.Match;
import de.SweetCode.Tier.Math.CalculationCallback;

public interface TierService<T extends Match> {

    /**
     * Returns the name of the algorithms.
     * @return
     */
    String getName();

    /**
     * This method checks if the implemented service is supporting this level.
     * @param level
     * @return returns true if the level is supported by the service, otherwise false.
     */
    boolean supports(ServiceLevel level);

    /**
     * Returns the default rating for a new player. - The value is just a recommendation and
     * can always be changed.
     * @return
     */
    double getDefaultRating();

    /**
     * Will be called to calculate the final results.
     * @param match
     * @param callback
     */
    void calculate(T match, CalculationCallback callback);

}
