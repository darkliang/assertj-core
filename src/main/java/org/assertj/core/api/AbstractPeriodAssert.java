package org.assertj.core.api;

import java.time.Period;

import static org.assertj.core.error.ShouldHavePeriod.shouldHaveDays;
import static org.assertj.core.error.ShouldHavePeriod.shouldHaveYears;
import static org.assertj.core.error.ShouldHavePeriod.shouldHaveMonths;
import org.assertj.core.internal.Failures;

public abstract class AbstractPeriodAssert<SELF extends AbstractPeriodAssert<SELF>>
    extends AbstractAssert<SELF, Period> {
  public AbstractPeriodAssert(Period period, Class<?> selfType) {
    super(period, selfType);
  }

  public SELF isZero() {
    isNotNull();
    return isEqualTo(Period.ZERO);
  }
  public SELF hasDays(int otherDays) {
    isNotNull();
    int actualDays = actual.getDays();
    if (otherDays != actualDays) {
      throw Failures.instance().failure(info, shouldHaveDays(actual, actualDays, otherDays), actualDays, otherDays);
    }
    return myself;
  }
  public SELF hasMonths(int otherMonths) {
    isNotNull();
    int actualMonths = actual.getMonths();
    if (otherMonths != actualMonths) {
      throw Failures.instance().failure(info, shouldHaveMonths(actual, actualMonths, otherMonths), actualMonths, otherMonths);
    }
    return myself;
  }
  public SELF hasYears(int otherYears) {
    isNotNull();
    int actualYears = actual.getYears();
    if (otherYears != actualYears) {
      throw Failures.instance().failure(info, shouldHaveYears(actual, actualYears, otherYears), actualYears, otherYears);
    }
    return myself;
  }
}
