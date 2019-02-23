package org.jordi.application.config;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.json.bind.JsonbConfig;

import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

@Provider
public class JSONConfigurator implements ContextResolver {

    @Override
    public Jsonb getContext(@SuppressWarnings("rawtypes") Class type) {
        JsonbConfig config = new JsonbConfig().withPropertyVisibilityStrategy(new PrivateVisibilityStrategy());
        return JsonbBuilder.newBuilder().withConfig(config).build();
    }
}