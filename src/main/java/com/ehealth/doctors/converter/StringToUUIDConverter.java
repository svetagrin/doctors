package com.ehealth.doctors.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

import java.util.UUID;

/**
 * Created by vilyam on 17.02.17.
 */
public class StringToUUIDConverter implements Converter<String, UUID> {

    @Override
    public UUID convert(String source) {
        return (StringUtils.hasLength(source) ? UUID.fromString(source.trim()) : null);
    }
}
