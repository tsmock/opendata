//    JOSM opendata plugin.
//    Copyright (C) 2011-2012 Don-vip
//
//    This program is free software: you can redistribute it and/or modify
//    it under the terms of the GNU General Public License as published by
//    the Free Software Foundation, either version 3 of the License, or
//    (at your option) any later version.
//
//    This program is distributed in the hope that it will be useful,
//    but WITHOUT ANY WARRANTY; without even the implied warranty of
//    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//    GNU General Public License for more details.
//
//    You should have received a copy of the GNU General Public License
//    along with this program.  If not, see <http://www.gnu.org/licenses/>.
package org.openstreetmap.josm.plugins.opendata.modules.fr.datagouvfr.datasets.transport;

import java.nio.charset.Charset;

import org.openstreetmap.josm.data.osm.DataSet;
import org.openstreetmap.josm.data.osm.Node;
import org.openstreetmap.josm.plugins.opendata.modules.fr.datagouvfr.datasets.DataGouvDataSetHandler;

public class PassageNiveauHandler extends DataGouvDataSetHandler {

    public PassageNiveauHandler() {
        super("Passages-à-niveau-30383135");
        setName("Passages à niveau");
        setDataGouvFrUrl("passage_a_niveau.csv");
    }

    @Override
    public boolean acceptsFilename(String filename) {
        return acceptsCsvFilename(filename, "passage_a_niveau(\\.csv-fr)?");
    }

    @Override
    public void updateDataSet(DataSet ds) {
        for (Node n : ds.getNodes()) {
            n.put("railway", "level_crossing");
        }
    }

    /* (non-Javadoc)
     * @see org.openstreetmap.josm.plugins.opendata.core.datasets.AbstractDataSetHandler#getCsvCharset()
     */
    @Override
    public Charset getCsvCharset() {
        return Charset.forName(ISO8859_15);
    }
}
