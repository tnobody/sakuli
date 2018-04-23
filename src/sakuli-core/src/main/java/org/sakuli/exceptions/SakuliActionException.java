/*
 * Sakuli - Testing and Monitoring-Tool for Websites and common UIs.
 *
 * Copyright 2013 - 2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.sakuli.exceptions;

import org.sakuli.actions.screenbased.RegionImpl;

/**
 * Wrapper for Sakuli Exceptions from a {@link org.sakuli.actions.screenbased.Region}.
 *
 * @author tschneck
 * Date: 01.09.13
 */
public class SakuliActionException extends SakuliCheckedException {

    protected RegionImpl lastRegion;

    public SakuliActionException(String s) {
        super(s);
    }

    public SakuliActionException(String s, RegionImpl lastRegion) {
        super(s);
        this.lastRegion = lastRegion;
    }

    public SakuliActionException(Exception e, RegionImpl lastRegion) {
        super(e);
        this.lastRegion = lastRegion;
    }

    public RegionImpl getLastRegion() {
        return lastRegion;
    }
}