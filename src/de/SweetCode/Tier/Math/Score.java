/*
 * Copyright (c) 2016 Jan Krüger
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package de.SweetCode.Tier.Math;

import de.SweetCode.Tier.Team.TierPlayer;

public class Score {

    private final TierPlayer tierPlayer;
    private final double score;

    public Score(TierPlayer tierPlayer, double score) {
        this.tierPlayer = tierPlayer;
        this.score = score;
    }

    /**
     * Returns the player who belongs to the score.
     * @return
     */
    public TierPlayer getPlayer() {
        return this.tierPlayer;
    }

    /**
     * Returns the score.
     * @return
     */
    public double getScore() {
        return this.score;
    }

    @Override
    public String toString() {

        return this.toString(2);

    }

    public String toString(int precision) {

        return String.format(
                "{player: %s, %." + precision + "f}",
                this.tierPlayer.toString(),
                this.score
        );

    }

}
