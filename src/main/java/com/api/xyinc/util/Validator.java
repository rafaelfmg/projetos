package com.api.xyinc.util;

import java.util.List;

import javax.validation.ValidationException;

import org.apache.commons.lang3.StringUtils;

public class Validator {
    public static void validateParameter(final String param) {
        if (StringUtils.isBlank(param)) {
            throw new ValidationException("Parâmetro deve ser informado");
        }
    }

    public static <E> void validateResult(final List<E> result) {
        if (result == null || result.size() == 0) {
            throw new ValidationException("Não foram encontrados registros!");
        }
    }
}
