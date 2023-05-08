package com.example.entertainmentresource.utils;

import com.example.entertainmentresource.models.entertainment.EntertainmentData;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class ListSorter <T>{
    public static <T> void sort(List<T> list, Function<T, Comparable> keyExtractor, boolean ascending) {
        Comparator<T> comparator = Comparator.comparing(keyExtractor);
        if (!ascending) {
            comparator = comparator.reversed();
        }
        Collections.sort(list, comparator);
    }
}
