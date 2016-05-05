/*
 * Copyright (c) 2016 Jan Krüger
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package de.SweetCode.Tier.Test;

import de.SweetCode.Tier.Match.Matches.SingleSingleMatch;
import de.SweetCode.Tier.Math.CalculationCallback;
import de.SweetCode.Tier.Math.CalculationEntry;
import de.SweetCode.Tier.Service.Services.ELO.EloService;
import de.SweetCode.Tier.Tier;

import java.util.List;

public class Test {

    public static void main(String[] args) {

        // using the Elo-Algo to calculate
        EloService service = Tier.create(EloService.class);

        // create a new match
        SingleSingleMatch match = new SingleSingleMatch(new TestPlayer("Yonas", 50), new TestPlayer("m0ys", 50));

        // set the scores (13:5)
        match.setScore(SingleSingleMatch.Type.A, 13);
        match.setScore(SingleSingleMatch.Type.B, 5);

        // Calculate the rankings
        service.calculate(match, new CalculationCallback() {

            @Override
            public void results(List<CalculationEntry> entries) {

                for (CalculationEntry entry : entries) {
                    System.out.println(entry);
                }

            }

        });

    }

}
