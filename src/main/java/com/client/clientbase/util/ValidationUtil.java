package com.client.clientbase.util;

import com.client.clientbase.HasId;
import com.client.clientbase.error.IllegalRequestDataException;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ValidationUtil {

    public static void checkNew(HasId bean) {
        if (!bean.isNew()) {
            throw new IllegalRequestDataException(bean.getClass().getSimpleName() + " must be new (id=null)");
        }
    }
}