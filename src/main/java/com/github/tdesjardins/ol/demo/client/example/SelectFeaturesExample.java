/*******************************************************************************
 * Copyright 2014, 2019 gwt-ol
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
/**
 *
 */
package com.github.tdesjardins.ol.demo.client.example;

import com.github.tdesjardins.ol.demo.client.constants.DemoConstants;
import com.github.tdesjardins.ol.demo.client.utils.DemoUtils;
import com.google.gwt.user.client.Window;

import ol.Collection;
import ol.Coordinate;
import ol.Feature;
import ol.FeatureOptions;
import ol.Map;
import ol.MapOptions;
import ol.OLFactory;
import ol.View;
import ol.control.MousePosition;
import ol.control.MousePositionOptions;
import ol.control.ScaleLine;
import ol.events.condition.Condition;
import ol.geom.Polygon;
import ol.interaction.Select;
import ol.interaction.SelectOptions;
import ol.layer.Base;
import ol.layer.LayerOptions;
import ol.layer.Tile;
import ol.layer.VectorLayerOptions;
import ol.proj.Projection;
import ol.proj.ProjectionOptions;
import ol.source.Osm;
import ol.source.Vector;
import ol.source.VectorOptions;
import ol.source.XyzOptions;

/**
 * Example for feature selection.
 *
 * @author Tino Desjardins
 */
public class SelectFeaturesExample implements Example {

    /* (non-Javadoc)
     * @see de.desjardins.ol3.demo.client.example.Example#show() */
    @Override
    public void show(String exampleId) {

        Coordinate centerCoordinate = new Coordinate(13.37, 52.52);
        Coordinate transformedMidPoint = Projection.transform(centerCoordinate, DemoConstants.EPSG_4326, DemoConstants.EPSG_3857);

        // create a polygon
        Polygon polygon = DemoUtils.createTestPolygon();

        // create a feature
        FeatureOptions featureOptions = OLFactory.createOptions();
        // TODO Setter for ID seems to doesn't have an effect in feature options.
        // featureOptions.setId("g1");
        featureOptions.setGeometry(polygon);

        Feature feature = new Feature(featureOptions);
        feature.setId("g1");
        feature.set("name", "triangle");

        // create another feature via cloning
        Feature feature2 = feature.clone();
        feature2.setId("g2");
        feature2.getGeometry().rotate(180, transformedMidPoint);

        Collection<Feature> lstFeatures = new Collection<Feature>();
        lstFeatures.push(feature);
        lstFeatures.push(feature2);

        VectorOptions vectorSourceOptions = OLFactory.createOptions();
        vectorSourceOptions.setFeatures(lstFeatures);
        Vector vectorSource = new Vector(vectorSourceOptions);

        VectorLayerOptions vectorLayerOptions = OLFactory.createOptions();
        vectorLayerOptions.setSource(vectorSource);
        ol.layer.Vector vectorLayer = new ol.layer.Vector(vectorLayerOptions);

        // create an OSM-layer
        XyzOptions osmSourceOptions = OLFactory.createOptions();
        Osm osmSource = new Osm(osmSourceOptions);
        LayerOptions osmLayerOptions = OLFactory.createOptions();
        osmLayerOptions.setSource(osmSource);
        Tile osmLayer = new Tile(osmLayerOptions);

        // create a view
        View view = new View();

        view.setCenter(transformedMidPoint);
        view.setZoom(14);

        // create the map
        MapOptions mapOptions = OLFactory.createOptions();
        mapOptions.setTarget(exampleId);
        mapOptions.setView(view);
        Collection<Base> lstLayer = new Collection<Base>();
        lstLayer.push(osmLayer);
        lstLayer.push(vectorLayer);
        mapOptions.setLayers(lstLayer);
        Map map = new Map(mapOptions);

        // add some controls
        map.addControl(new ScaleLine());

        MousePositionOptions mousePositionOptions = OLFactory.createOptions();
        ProjectionOptions projectionOptions = OLFactory.createOptions();
        projectionOptions.setCode(DemoConstants.EPSG_4326);
        mousePositionOptions.setProjection(new Projection(projectionOptions));

        MousePosition mousePosition = new MousePosition(mousePositionOptions);
        mousePosition.setCoordinateFormat(Coordinate.createStringXY(5));
        map.addControl(mousePosition);

        SelectOptions selectOptions = new SelectOptions();
        selectOptions.setCondition(Condition.getClick());

        // create a select interaction
        final Select selectFeature = new Select(selectOptions);
        map.addInteraction(selectFeature);

        selectFeature.on("select", (Select.Event event) -> {

            Feature[] selectedFeatures = event.getSelected();

            if (selectedFeatures.length > 0) {
                Feature selectedFeature = selectedFeatures[0];
                String output = "You selected feature with id '" + selectedFeature.getId() + "'"
                        + " and name '" + selectedFeature.get("name") + "'"
                        + " and geometry name '" + selectedFeature.getGeometryName() + "'"
                        + ".";
                Window.alert(output);
            }

        });

    }

    @Override
    public String getDescription() {
        return "Example for feature selection.";
    }

}
