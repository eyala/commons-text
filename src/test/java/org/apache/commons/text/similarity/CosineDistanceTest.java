/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.commons.text.similarity;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Unit tests for {@link org.apache.commons.text.similarity.CosineSimilarity}.
 *
 * @since 0.1
 */
public class CosineDistanceTest {

    /**
     * Cosine distance under test.
     */
    private static CosineDistance cosineDistance;

    /**
     * Creates the cosine distance object used throughout the tests.
     */
    @BeforeClass
    public static void setUp() {
        cosineDistance = new CosineDistance();
    }

    /**
     * Tests the cosine distance with several inputs.
     */
    @Test
    public void testCosineDistance() {
        assertEquals(Double.valueOf(0.5d), roundValue(cosineDistance.compare("the house", "da house")));
        assertEquals(Double.valueOf(0.0d), roundValue(cosineDistance.compare("AB", "AB")));
        assertEquals(Double.valueOf(1.0d), roundValue(cosineDistance.compare("AB", "BA")));
        assertEquals(Double.valueOf(0.08d), roundValue(cosineDistance.compare(
                "the boy was from tamana shi, kumamoto ken, and the girl was from rio de janeiro, rio",
                "the boy was from tamana shi, kumamoto, and the boy was from rio de janeiro, rio de janeiro")));
    }

    // --- Utility methods

    /**
     * Rounds up a value.
     *
     * @param value a value
     * @return rounded up value
     */
    private Double roundValue(Double value) {
        return (Double) new BigDecimal(value).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

}