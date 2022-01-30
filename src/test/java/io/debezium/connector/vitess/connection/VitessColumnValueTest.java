/*
 * Copyright Debezium Authors.
 *
 * Licensed under the Apache Software License version 2.0, available at http://www.apache.org/licenses/LICENSE-2.0
 */
package io.debezium.connector.vitess.connection;

import static org.fest.assertions.Assertions.assertThat;

import java.nio.charset.StandardCharsets;
import java.sql.Types;

import org.junit.Test;

import io.debezium.connector.vitess.VitessType;

public class VitessColumnValueTest {

    @Test
    public void shouldConvertRawValueToBytes() {
        VitessColumnValue value = new VitessColumnValue("1".getBytes(StandardCharsets.UTF_8));
        assertThat(value.asBytes()).isEqualTo("1".getBytes(StandardCharsets.UTF_8));
    }

    @Test
    public void shouldConvertRawValueToString() {
        VitessColumnValue value = new VitessColumnValue("1".getBytes(StandardCharsets.UTF_8));
        assertThat(value.asString()).isEqualTo("1");
    }

    @Test
    public void shouldConvertRawValueToShort() {
        VitessColumnValue value = new VitessColumnValue("1".getBytes(StandardCharsets.UTF_8));
        assertThat(value.asShort()).isEqualTo((short) 1);
    }

    @Test
    public void shouldConvertRawValueToInteger() {
        VitessColumnValue value = new VitessColumnValue("1".getBytes(StandardCharsets.UTF_8));
        assertThat(value.asInteger()).isEqualTo(1);
    }

    @Test
    public void shouldConvertRawValueToLong() {
        VitessColumnValue value = new VitessColumnValue("1".getBytes(StandardCharsets.UTF_8));
        assertThat(value.asLong()).isEqualTo(1L);
    }

    @Test
    public void shouldConvertRawValueToFloat() {
        VitessColumnValue value = new VitessColumnValue("1.2".getBytes(StandardCharsets.UTF_8));
        assertThat(value.asFloat()).isEqualTo(1.2F);
    }

    @Test
    public void shouldConvertRawValueToDouble() {
        VitessColumnValue value = new VitessColumnValue("1.2".getBytes(StandardCharsets.UTF_8));
        assertThat(value.asDouble()).isEqualTo(1.2D);
    }

    @Test
    public void shouldConvertRawValueToStringWhenUnknownIsSet() {
        VitessColumnValue value = new VitessColumnValue("1".getBytes(StandardCharsets.UTF_8));
        assertThat(value.asDefault(new VitessType("foo", Types.OTHER), true)).isEqualTo("1");
    }

    @Test
    public void shouldConvertRawValueToNullWhenUnknownIsUnset() {
        VitessColumnValue value = new VitessColumnValue("1".getBytes(StandardCharsets.UTF_8));
        assertThat(value.asDefault(new VitessType("foo", Types.OTHER), false)).isNull();
    }
}
