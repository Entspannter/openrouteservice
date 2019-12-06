package org.heigit.ors.routing.graphhopper.extensions.edgefilters.core;

/*  This file is part of Openrouteservice.
        *
        *  Openrouteservice is free software; you can redistribute it and/or modify it under the terms of the
        *  GNU Lesser General Public License as published by the Free Software Foundation; either version 2.1
        *  of the License, or (at your option) any later version.
        *  This library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
        *  without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
        *  See the GNU Lesser General Public License for more details.
        *  You should have received a copy of the GNU Lesser General Public License along with this library;
        *  if not, see <https://www.gnu.org/licenses/>.
        */

import com.graphhopper.routing.util.EdgeFilter;
import com.graphhopper.storage.GraphStorage;
import com.graphhopper.util.EdgeIteratorState;
import com.graphhopper.routing.util.FlagEncoder;
import org.heigit.ors.config.AppConfig;
import org.heigit.ors.routing.graphhopper.extensions.storages.GraphStorageUtils;
import org.heigit.ors.routing.graphhopper.extensions.storages.HeavyVehicleAttributesGraphStorage;

/**
 * This class includes in the core all edges with turn restrictions.
 *
 * @author Athanasios Kogios
 */

public class TurnRestrictionsCoreEdgeFilter implements EdgeFilter {
    private HeavyVehicleAttributesGraphStorage storage;
    public final FlagEncoder flagEncoder;

    public TurnRestrictionsCoreEdgeFilter(FlagEncoder encoder, GraphStorage graphStorage) {
        this.flagEncoder = encoder;
        if (!flagEncoder.isRegistered())
            throw new IllegalStateException("Make sure you add the FlagEncoder " + flagEncoder + " to an EncodingManager before using it elsewhere");
        storage = GraphStorageUtils.getGraphExtension(graphStorage, HeavyVehicleAttributesGraphStorage.class);
    }

    //TODO Find how to get edge flags looking at code from CarFlagEncoder adn VehicleFlagEncoder.
    @Override
    public boolean accept(EdgeIteratorState edge) {
        EdgeIteratorState edgeTest = edge;
        //if ( flagEncoder.isTurnRestricted(edge.getFlags() ) ) { //If the max speed of the road is greater than that of the limit include it in the core.
         if( 1 != 1 ){
            return false;
        } else {
             boolean test = flagEncoder.isTurnRestricted(edge.get("turnCOstEncoder")) !=0 ? true : false ;
            return true;
        }
    }
}

