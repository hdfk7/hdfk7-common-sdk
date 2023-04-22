package com.hdfk7.proto.base.util;

import com.hdfk7.proto.base.json.JacksonObjectMapperInstance;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JsonUtil {
    private static final ObjectMapper mapper = JacksonObjectMapperInstance.getMapper();

    public static String toJsonStr(Object obj) {
        if (obj == null) return null;
        if (obj instanceof String) return (String) obj;
        try {
            return mapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }

    public static <T> T toObject(String json, Class<T> type) {
        if (json == null) return null;
        try {
            return mapper.readValue(json, type);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }

    public static <T> T toObject(String json, TypeReference<T> reference) {
        if (json == null) return null;
        try {
            return mapper.readValue(json, reference);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }

    public static <T> T toObject(Object json, Class<T> type) {
        return toObject(toJsonStr(json), type);
    }

    public static <T> T toObject(Object json, TypeReference<T> reference) {
        return toObject(toJsonStr(json), reference);
    }
}
