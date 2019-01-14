package com.github.tdesjardins.ol.demo.client;

import com.github.nalukit.nalu.client.application.IsApplication;
import com.github.nalukit.nalu.client.application.annotation.Application;
import com.github.nalukit.nalu.client.application.annotation.Debug;
import com.github.nalukit.nalu.plugin.elemental2.client.DefaultElemental2Logger;

@Application(context = GwtOlDemoContext.class, startRoute = "/application/map", loader = GwtOlDemoLoader.class, routeError = "/error/error")
@Debug(logger = DefaultElemental2Logger.class, logLevel = Debug.LogLevel.DETAILED)
public interface GwtOlDemoApplication extends IsApplication {}
