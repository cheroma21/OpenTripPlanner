/* This program is free software: you can redistribute it and/or
 modify it under the terms of the GNU Lesser General Public License
 as published by the Free Software Foundation, either version 3 of
 the License, or (at your option) any later version.

 This program is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 GNU General Public License for more details.

 You should have received a copy of the GNU General Public License
 along with this program.  If not, see <http://www.gnu.org/licenses/>. */

package org.opentripplanner.routing.vertextype;

import org.opentripplanner.common.MavenVersion;
import org.opentripplanner.routing.bike_rental.BikeRentalStation;
import org.opentripplanner.routing.graph.Graph;
import org.opentripplanner.routing.graph.Vertex;

import java.util.Set;

/**
 * A vertex for a bike rental station.
 * It is connected to the streets by a StreetBikeRentalLink.
 * To allow transitions on and off a bike, it has RentABike* loop edges.
 *
 * @author laurent
 * 
 */
public class BikeRentalStationVertex extends Vertex {

    private static final long serialVersionUID = MavenVersion.VERSION.getUID();

    private int bikesAvailable;

    private int spacesAvailable;

    private boolean pickupAllowed;
    /**
     * isFloatingBike denotes whether a bike is dockless or not.
     */
    public final boolean isFloatingBike;

    private String id;

    /**
     * List of compatible network names. Null (default) to be compatible with all.
     */
    public Set<String> networks;

    public BikeRentalStationVertex(Graph g, BikeRentalStation station) {
        //FIXME: raw_name can be null if bike station is made from graph updater
        super(g, "bike rental station " + station.id, station.x, station.y,
                station.name);
        this.setId(station.id);
        this.networks = station.networks;
        this.setBikesAvailable(station.bikesAvailable);
        this.setSpacesAvailable(station.spacesAvailable);
        this.setPickupAllowed(station.allowPickup);
        this.isFloatingBike = station.isFloatingBike;
    }

    public int getBikesAvailable() {
        return bikesAvailable;
    }

    public int getSpacesAvailable() {
        return spacesAvailable;
    }

    public void setBikesAvailable(int bikes) {
        this.bikesAvailable = bikes;
    }

    public void setSpacesAvailable(int spaces) {
        this.spacesAvailable = spaces;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isPickupAllowed() {
        return pickupAllowed;
    }

    public void setPickupAllowed(boolean pickupAllowed) {
        this.pickupAllowed = pickupAllowed;
    }
}
