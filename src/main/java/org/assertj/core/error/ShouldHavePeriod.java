package org.assertj.core.error;

import java.time.Period;
//CS304 https://github.com/joel-costigliola/assertj-core/issues/1853
public class ShouldHavePeriod extends BasicErrorMessageFactory {
  private static final String SHOULD_HAVE_PERIOD_UNIT = "%n"
                                                        + "Expecting Period:%n"
                                                        + " <%s>%n"
                                                        + "to have %s %s%n"
                                                        + "but had %s";

  private ShouldHavePeriod(Period actual, int actualSpecific, int expectedSpecific, String metric) {
    super(SHOULD_HAVE_PERIOD_UNIT, actual, expectedSpecific, metric, actualSpecific);
  }

  public static ShouldHavePeriod shouldHaveYears(Period actual, int actualYears, int expectedYears) {
    String metric;
    if (expectedYears == 1 || expectedYears == -1) {
      metric = "year";
    } else {
      metric = "years";
    }
    return new ShouldHavePeriod(actual, actualYears, expectedYears, metric);
  }
  public static ShouldHavePeriod shouldHaveMonths(Period actual, int actualMonths, int expectedMonths) {
    String metric;
    if (expectedMonths == 1 || expectedMonths == -1) {
      metric = "month";
    } else {
      metric = "months";
    }
    return new ShouldHavePeriod(actual, actualMonths, expectedMonths, metric);
  }
  public static ShouldHavePeriod shouldHaveDays(Period actual, int actualDays, int expectedDays) {
    String metric;
    if (expectedDays == 1 || expectedDays == -1) {
      metric = "Day";
    } else {
      metric = "Days";
    }
    return new ShouldHavePeriod(actual, actualDays, expectedDays, metric);
  }
}
