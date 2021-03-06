/*
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 *
 * Copyright 2012-2020 the original author or authors.
 */
package org.assertj.core.internal;

import org.assertj.core.api.AssertionInfo;
import org.assertj.core.util.VisibleForTesting;

/**
 * Reusable assertions for <code>{@link Byte}</code>s.
 *
 * @author Drummond Dawson
 * @author Alex Ruiz
 * @author Joel Costigliola
 * @author Cal027
 */
public class Bytes extends Numbers<Byte> {

  private static final Bytes INSTANCE = new Bytes();

  /**
   * Returns the singleton instance of this class.
   *
   * @return the singleton instance of this class.
   */
  public static Bytes instance() {
    return INSTANCE;
  }

  @VisibleForTesting
  Bytes() {
    super();
  }

  public Bytes(ComparisonStrategy comparisonStrategy) {
    super(comparisonStrategy);
  }

  @Override
  protected Byte zero() {
    return 0;
  }

  @Override
  protected Byte one() {
    return 1;
  }

  @Override
  protected Byte absDiff(Byte actual, Byte other) {
    return (byte) Math.abs(actual - other); // TODO check corner case when diff > max byte
  }

  @Override
  protected boolean isGreaterThan(Byte value, Byte other) {
    return value > other;
  }

  /**
   * Asserts that the actual Byte value is even.
   *
   * @param info contains information about the assertion.
   * @param actual the actual value.
   * @throws AssertionError if the actual value is {@code null}.
   * @throws AssertionError if the actual value is negative.
   */
  // CS304 Issue link: https://github.com/joel-costigliola/assertj-core/issues/1807
  public void assertIsEven(AssertionInfo info, Byte actual) {
    Byte lastDigit = (byte) (actual & one());
    assertIsZero(info, lastDigit);
  }

  /**
   * Asserts that the actual Byte value is odd.
   *
   * @param info contains information about the assertion.
   * @param actual the actual value.
   * @throws AssertionError if the actual value is {@code null}.
   * @throws AssertionError if the actual value is negative.
   */
  // CS304 Issue link: https://github.com/joel-costigliola/assertj-core/issues/1807
  public void assertIsOdd(AssertionInfo info, Byte actual) {
    Byte lastDigit = (byte) (actual & one());
    assertIsNotZero(info, lastDigit);
  }
}
