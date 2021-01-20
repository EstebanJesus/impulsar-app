package com.impulsar.app.api.annotation;

import com.impulsar.app.api.aggregator.UserAggregator;
import org.junit.jupiter.params.aggregator.AggregateWith;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
@AggregateWith(UserAggregator.class)
public @interface CsvToUser {
}

