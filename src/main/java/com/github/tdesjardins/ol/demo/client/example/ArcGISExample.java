/*******************************************************************************
 * Copyright 2014, 2017 gwt-ol3
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
package com.github.tdesjardins.ol.demo.client.example;

import com.github.tdesjardins.ol.demo.client.utils.DemoUtils;

import ol.Coordinate;
import ol.Map;
import ol.MapOptions;
import ol.OLFactory;
import ol.View;
import ol.control.Rotate;
import ol.control.ScaleLine;
import ol.interaction.KeyboardPan;
import ol.interaction.KeyboardZoom;
import ol.layer.Image;
import ol.layer.LayerOptions;
import ol.source.ImageArcGisRest;
import ol.source.ImageArcGisRestOptions;
import ol.source.ImageArcGisRestParams;

/**
 * Example with ArcGIS Server layer
 *
 * @author Peter Zanetti
 */
public class ArcGISExample implements Example {

    /* (non-Javadoc)
     * @see de.desjardins.ol3.demo.client.example.Example#show() */
    @Override
    public void show(String exampleId) {

        ImageArcGisRestParams params = new ImageArcGisRestParams();
        params.showLayers("2");

        ImageArcGisRestOptions options = new ImageArcGisRestOptions();
        options.setUrl(
                "https://sampleserver1.arcgisonline.com/ArcGIS/rest/services/Specialty/ESRI_StateCityHighway_USA/MapServer");
        options.setParams(params);
        options.setRatio(1f);

        ImageArcGisRest source = new ImageArcGisRest(options);

        LayerOptions layerOptions = OLFactory.createOptions();
        layerOptions.setSource(source);

        Image layer = new Image(layerOptions);

        // create a view
        View view = new View();

        Coordinate center = OLFactory.createCoordinate(-10997148, 4569099);

        view.setCenter(center);
        view.setZoom(4);

        // create the map
        MapOptions mapOptions = OLFactory.createOptions();
        mapOptions.setTarget(exampleId);
        mapOptions.setView(view);

        Map map = new Map(mapOptions);

        map.addLayer(layer);

        // add some controls
        map.addControl(new ScaleLine());
        DemoUtils.addDefaultControls(map.getControls());

        // add some interactions
        map.addInteraction(new KeyboardPan());
        map.addInteraction(new KeyboardZoom());
        map.addControl(new Rotate());

    }

}