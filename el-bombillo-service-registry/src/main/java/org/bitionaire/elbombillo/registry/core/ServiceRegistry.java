package org.bitionaire.elbombillo.registry.core;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bitionaire.elbombillo.registry.api.model.Service;

import java.util.*;
import java.util.stream.Collectors;

public class ServiceRegistry {

    @JsonProperty
    private List<Service> services = new ArrayList<>();

    @JsonCreator
    public ServiceRegistry(@JsonProperty("services") final Service... services) {
        final long distinctBaseUrlCount = Arrays.stream(services).map(service -> service.getBaseUrl()).distinct().count();
        if (distinctBaseUrlCount != services.length) {
            throw new IllegalArgumentException("services list contains duplicate base URLs");
        }

        this.services = Arrays.asList(services);
    }

    /**
     * Returns an unmodifiable list of all service instance.
     *
     * @return an unmodifiable list of all service instance
     */
    public List<Service> services() {
        return Collections.unmodifiableList(services);
    }

    /**
     * Returns all listed service instance for the specified name.
     *
     * @param serviceName the service name
     * @return all listed service instance for the specified name
     */
    public List<Service> services(final String serviceName) {
        return services.stream().filter(service -> service.getName().equals(serviceName)).collect(Collectors.toList());
    }

}
