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
import de.SweetCode.Tier.Team.Containers.PlayerContainer;

import java.util.UUID;

public class SingleMultiMatch implements Match<UUID> {

    private final UUID identifier = UUID.randomUUID();

    private final PlayerContainer container;

    public SingleMultiMatch(PlayerContainer container) {
        this.container = container;
    }

    @Override
    public UUID getIdentifier() {
        return this.identifier;
    }

    @Override
    public ServiceLevel getServiceLevel() {
        return ServiceLevel.SINGLE_MULTI;
    }

    public PlayerContainer getContainer() {
        return this.container;
    }
}
