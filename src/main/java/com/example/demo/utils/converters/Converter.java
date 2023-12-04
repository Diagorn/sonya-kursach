package com.example.demo.utils.converters;

public interface Converter<T, R> {
    R convert(T obj);
}
