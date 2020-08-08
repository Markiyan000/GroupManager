package com.derevetskyi.markiyan.groupmanager.app.wrapper;

import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JacksonWrapper {

    private SimpleFilterProvider provider;

    public JacksonWrapper() {
        this.provider = new SimpleFilterProvider();
    }

    private void addFilter(String id, String...fields) {
        provider.addFilter(id, SimpleBeanPropertyFilter.filterOutAllExcept(fields));
        provider.setFailOnUnknownId(false);
    }

    public MappingJacksonValue wrap(List list, String id, String...fields) {
        MappingJacksonValue wrapper = new MappingJacksonValue(list);
        addFilter(id, fields);
        wrapper.setFilters(provider);

        return wrapper;
    }
}
