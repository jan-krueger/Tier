/*
 * Copyright (c) 2016 Jan Krüger
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package de.SweetCode.Tier.Team.Teams;

import de.SweetCode.Tier.Service.TierService;
import de.SweetCode.Tier.Team.TierPlayer;
import de.SweetCode.Tier.Team.Team;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class DefaultTeam implements Team<UUID> {

    private final UUID identifier = UUID.randomUUID();
    private final List<TierPlayer> players = Collections.emptyList();

    private final Class<TierService> service;

    public DefaultTeam(Class<TierService> service) {
        this.service = service;
    }

    @Override
    public UUID getIdentifier() {
        return this.identifier;
    }

    @Override
    public double getAverageRating() {

        double average = 0;

        for(TierPlayer player : this.players) {
            average += player.getRating(this.service);
        }

        return (average / this.players.size());
    }

    /**
     * Returns one team.
     * @return
     */
    public List<TierPlayer> getPlayers() {
        return this.players;
    }

    /**
     * Adds one player to
     * @param tierPlayer
     */
    public void add(TierPlayer tierPlayer) {

        if(this.contains(tierPlayer)) {
            throw new IllegalArgumentException(String.format(
                    "The player (%s) already belongs to this team.",
                    tierPlayer.toString()
            ));
        }

        this.players.add(tierPlayer);

    }

    /**
     * This method checks if this team contains the player.
     * @param tierPlayer
     * @return returns true if the player belongs to the team, otherwise false.
     */
    public boolean contains(TierPlayer tierPlayer) {
        return this.players.contains(tierPlayer);
    }

    @Override
    public String toString() {

        return String.format(
                "{identifier: %s, players: %s}",
                this.identifier.toString(),
                this.players.toString()
        );

    }

}
