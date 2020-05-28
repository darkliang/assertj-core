package org.assertj.core.api.period;

//CS304 https://github.com/joel-costigliola/assertj-core/issues/1853
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.AssertionsUtil.assertThatAssertionErrorIsThrownBy;
import static org.assertj.core.util.FailureMessages.actualIsNull;


import java.time.Period;

import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.assertj.core.error.ShouldHavePeriod;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
@DisplayName("PeriodAssert hasYears")

public class PeriodAssert_hasYears_Test{
  @Test
  void should_pass_if_period_has_matching_years() {
    // GIVEN
    Period period = Period.ofYears(4);
    // WHEN/THEN
    assertThat(period).hasYears(4);
  }
  @Test
  void should_fail_when_period_is_null() {
    // GIVEN
    Period period = null;
    // WHEN
    ThrowingCallable code = () -> assertThat(period).hasYears(5);
    // THEN
    assertThatAssertionErrorIsThrownBy(code).withMessage(actualIsNull());
  }
  @Test
  void should_fail_if_period_does_not_have_matching_years() {
    // GIVEN
    Period period = Period.ofYears(10);
    // WHEN
    ThrowingCallable code = () -> assertThat(period).hasYears(15);
    // THEN
    assertThatAssertionErrorIsThrownBy(code).withMessage(ShouldHavePeriod.shouldHaveYears(period, 10, 15).create());
  }
}
