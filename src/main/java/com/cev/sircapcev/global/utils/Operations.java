package com.cev.sircapcev.global.utils;

import java.util.Comparator;
import java.util.List;

import com.cev.sircapcev.global.entity.EntityId;

public class Operations {

    public static String trimBrackets(String message) {
        return message.replaceAll("[\\[\\]]", "");
    }
    public static int autoIncrement(List<? extends EntityId> list) {
        if (list.isEmpty()) {
            return 1;
        } else {
            return list.stream().max(Comparator.comparing(EntityId::getId)).get().getId() + 1;
        }
    }
}
