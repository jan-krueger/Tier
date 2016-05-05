/*
 * Copyright (c) 2016 Jan Krüger
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package de.SweetCode.Tier.Service.Services.ELO;

import de.SweetCode.Tier.Match.Matches.SingleSingleMatch;
import de.SweetCode.Tier.Math.CalculationCallback;
import de.SweetCode.Tier.Math.CalculationEntry;
import de.SweetCode.Tier.Service.ServiceLevel;
import de.SweetCode.Tier.Service.TierService;
import de.SweetCode.Tier.Team.TierPlayer;

import java.util.ArrayList;

public class EloService implements TierService<SingleSingleMatch> {

    @Override
    public String getName() {
        return "Elo";
    }

    @Override
    public boolean supports(ServiceLevel level) {

        return level.equals(ServiceLevel.SINGLE_SINGLE) || level.equals(ServiceLevel.SINGLE_AI);

    }

    @Override
    public double getDefaultRating() {
        return 1000;
    }

    @Override
    public void calculate(SingleSingleMatch match, CalculationCallback callback) {

        if(match == null) {
            throw new IllegalArgumentException("The Match cannot be null.");
        }

        if(callback == null) {
            throw new IllegalArgumentException("The CalculationCallback cannot be null");
        }

        final TierPlayer playerA = match.getPlayer(SingleSingleMatch.Type.A);
        final TierPlayer playerB = match.getPlayer(SingleSingleMatch.Type.B);

        final double scoreA = EloService.calculateElo(playerA, playerB, match.getScore(SingleSingleMatch.Type.A), match.getScore(SingleSingleMatch.Type.B));
        final double scoreB = EloService.calculateElo(playerB, playerA, match.getScore(SingleSingleMatch.Type.B), match.getScore(SingleSingleMatch.Type.A));


        callback.results(new ArrayList<CalculationEntry>() {{

            this.add(new CalculationEntry(playerA, scoreA, playerA.getRating(EloService.class) + scoreA));
            this.add(new CalculationEntry(playerB, scoreB, playerA.getRating(EloService.class) + scoreB));

        }});

    }

    /**
     * Calculates the new Elo-Value for the player.
     * @param player
     * @param opponent
     * @param playerScore
     * @param opponentScore
     * @return
     */
    private static double calculateElo(TierPlayer player, TierPlayer opponent, double playerScore, double opponentScore) {

        double value = Math.abs(playerScore * (1 - getExpectedScore(player.getAverageRating(EloService.class), opponent.getAverageRating(EloService.class))));

        // If the player lost the game then the player will lose
        // points.
        if(playerScore < opponentScore) {
            value *= -1;
        }

        return value;

    }


    /**
     * Returns the expected score based on both players.
     * @param opponent
     * @param player
     * @return
     */
    private static double getExpectedScore(double opponent, double player) {
        return (1D / (1D + Math.pow(10D, (player - opponent) / 400)));
    }

}
