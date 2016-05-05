/*
 * Copyright (c) 2016 Jan Krüger
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package de.SweetCode.Tier.Match.Matches;

import de.SweetCode.Tier.Match.Match;
import de.SweetCode.Tier.Service.ServiceLevel;
import de.SweetCode.Tier.Team.TierPlayer;

import java.util.UUID;

public class SingleSingleMatch implements Match<UUID> {

    private final UUID identifier = UUID.randomUUID();

    private final TierPlayer playerA;
    private final TierPlayer playerB;

    private double scoreA;
    private double scoreB;

    public SingleSingleMatch(TierPlayer playerA, TierPlayer playerB) {
        this.playerA = playerA;
        this.playerB = playerB;
    }

    @Override
    public UUID getIdentifier() {
        return this.identifier;
    }

    @Override
    public ServiceLevel getServiceLevel() {
        return ServiceLevel.SINGLE_SINGLE;
    }

    public double getScore(SingleSingleMatch.Type type) {

        if(type == Type.A) {
            return this.scoreA;
        }

        if(type == Type.B) {
            return this.scoreB;
        }

        return -1;

    }

    public TierPlayer getPlayer(SingleSingleMatch.Type type) {

        if(type == Type.A) {
            return this.playerA;
        }

        if(type == Type.B) {
            return this.playerB;
        }

        return null;

    }

    public void setScore(SingleSingleMatch.Type type, double value) {

        if(type == Type.A) {
            this.scoreA = value;
        }

        if(type == Type.B) {
            this.scoreB = value;
        }

    }

    public enum Type {

        A, B;

    }

}
