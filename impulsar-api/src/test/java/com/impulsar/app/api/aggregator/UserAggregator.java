package com.impulsar.app.api.aggregator;

import com.impulsar.app.api.domain.UserApp;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.aggregator.ArgumentsAggregationException;
import org.junit.jupiter.params.aggregator.ArgumentsAggregator;

public class UserAggregator implements ArgumentsAggregator {
    @Override
    public Object aggregateArguments(ArgumentsAccessor arguments, ParameterContext parameterContext) throws ArgumentsAggregationException {
        UserApp userApp = new UserApp();
        userApp.setId(arguments.getLong(0));
        userApp.setLogin(arguments.getString(1));
        userApp.setEmail(arguments.getString(2));
        userApp.setFirstName(arguments.getString(3));
        userApp.setLastName(arguments.getString(4));
        userApp.setImageUrl(arguments.getString(5));
        userApp.setLangKey(arguments.getString(6));
        return userApp;
    }
}
