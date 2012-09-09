/*
 * Copyright 2012 Hannes Janetzek
 *
 * This program is free software: you can redistribute it and/or modify it under the
 * terms of the GNU Lesser General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A
 * PARTICULAR PURPOSE. See the GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License along with
 * this program. If not, see <http://www.gnu.org/licenses/>.
 */
package org.mapsforge.android.mapgenerator;

import org.mapsforge.core.Tile;

/**
 * 
 */
public class JobTile extends Tile implements Comparable<JobTile> {
	/**
	 * tile is loaded and ready for drawing. (set and used by render thread after uploading data to gl).
	 */
	public boolean isReady;

	/**
	 * tile is removed from JobQueue and loading in DatabaseRenderer. set by MapWorker.
	 */
	public boolean isLoading;

	/**
	 * tile is in view region. (set and used by render thread)
	 */
	public boolean isVisible;

	/**
	 * tile is used by render thread. set by updateVisibleList (main thread).
	 */
	public boolean isActive;

	/**
	 * distance from center, used in TileScheduler set by updateVisibleList.
	 */
	public float distance;

	/**
	 * @param tileX
	 *            ...
	 * @param tileY
	 *            ...
	 * @param zoomLevel
	 *            ..
	 */
	public JobTile(int tileX, int tileY, byte zoomLevel) {
		super(tileX, tileY, zoomLevel);
	}

	@Override
	public int compareTo(JobTile o) {
		if (this.distance < o.distance) {
			return -1;
		} else if (this.distance > o.distance) {
			return 1;
		}
		return 0;
	}
}