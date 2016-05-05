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

public enum ServiceLevel {

    /**
     * The team level describes that the implemented algorithm
     * is able to return results for an environment with 2 teams.
     */
    TEAM,

    /**
     * The mutli-team level describes that the implemented algorithm
     * is able to returns results for an environment with more then 2
     * teams.
     */
    TEAM_MUTLI,

    /**
     * The single level describes that the implemented algorithm
     * is able to return results for an environment where a single entity
     * is in the environment against an A.I. (Artificial Intelligence).
     */
    SINGLE_AI,

    /**
     * The single-single level describes that the implemented algorithm
     * is able to return result for an environment where two individuals
     * are facing each other.
     */
    SINGLE_SINGLE,

    /**
     * The multi-single describes that the implemented algorithm
     * is able to return results for an environment with more then 2
     * individuals facing each other.
     */
    SINGLE_MULTI;

}
