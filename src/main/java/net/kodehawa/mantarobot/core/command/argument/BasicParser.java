/*
 * Copyright (C) 2016 Kodehawa
 *
 * Mantaro is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * Mantaro is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Mantaro. If not, see http://www.gnu.org/licenses/
 *
 */

package net.kodehawa.mantarobot.core.command.argument;

import net.kodehawa.mantarobot.core.command.NewContext;

import javax.annotation.Nonnull;
import java.util.Optional;
import java.util.function.Function;

/**
 * Basic argument parsing, applying a transformation to a string.
 *
 * @param <T> Resulting type of the transformation.
 */
public class BasicParser<T> implements Parser<T> {
    private final Function<String, T> parseFunction;

    public BasicParser(@Nonnull Function<String, T> parseFunction) {
        this.parseFunction = parseFunction;
    }

    @SuppressWarnings("unused")
    @Nonnull
    @Override
    public Optional<T> parse(@Nonnull NewContext context, @Nonnull Arguments arguments) {
        return Optional.of(parseFunction.apply(arguments.next().getValue()));
    }
}
