/*
 * Copyright (c) 2016 Jan Krüger
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package de.SweetCode.Tier.Team.Containers;

import de.SweetCode.Tier.Team.TierPlayer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PlayerContainer<T extends TierPlayer> implements Container {

    private final List<T> players;
    private final int size;

    public PlayerContainer(int size) {
        this.players = new ArrayList<>(size);
        this.size = size;
    }

    /**
     * Returns all stored players.
     * @return
     */
    public List<T> getPlayers() {
        return Collections.unmodifiableList(this.players);
    }

    /**
     * Adds a team to the container.
     * @param player
     */
    public void add(T player) {

        if(this.players.contains(player)) {
            throw new IllegalArgumentException("This players already exists in this container.");
        }

        if(this.players.size() + 1 > this.size) {
            throw new ArrayIndexOutOfBoundsException("The list is full. The maximum amount of players in this container are %d.");
        }

        this.players.add(player);

    }

}
