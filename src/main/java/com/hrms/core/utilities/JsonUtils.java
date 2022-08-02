package com.hrms.core.utilities;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hrms.core.utilities.constants.CoreMessages;
import com.hrms.core.utilities.results.DataResult;
import com.hrms.core.utilities.results.ErrorDataResult;
import com.hrms.core.utilities.results.SuccessDataResult;

import java.io.IOException;

public class JsonUtils {

    /**
     * Parses json to given object class.
     * <p>
     * Please don't forget to delete file after using it.
     *
     * @param json       object as json string format.
     * @param valueType  class type to parse json to
     *
     * @return           parsed object as {@link DataResult} if successful or,
     * <p>
     *                   null and exception message as {@link DataResult}
     */
    public static <T> DataResult<T> jsonToObject(String json, Class<T> valueType){
        T object;
        try {
            object = new ObjectMapper().readValue(json, valueType);
            return new SuccessDataResult<>(object);
        }
        catch (IOException e){
            return new ErrorDataResult<>(null, e.getMessage());
        }
    }
}
