//CS304 Issue link https://github.com/joel-costigliola/assertj-core/issues/1853
package org.assertj.core.api;

import java.time.Period;

import static org.assertj.core.error.ShouldHavePeriod.shouldHaveDays;
import static org.assertj.core.error.ShouldHavePeriod.shouldHaveYears;
import static org.assertj.core.error.ShouldHavePeriod.shouldHaveMonths;
import org.assertj.core.internal.Failures;
/**
 * Assertions for {@link Period} type.

 */
public abstract class AbstractPeriodAssert<SELF extends AbstractPeriodAssert<SELF>>
    extends AbstractAssert<SELF, Period> {
  /**
   * Creates a new <code>{@link org.assertj.core.api.AbstractPeriodAssert}</code>
   * @param period the actual value to verify
   * @param selfType the "self type"
   */
  public AbstractPeriodAssert(Period period, Class<?> selfType) {
    super(period, selfType);
  }

  public SELF isZero() {
    isNotNull();
    return isEqualTo(Period.ZERO);
  }
  /**
   * Verifies that the actual {@code Period} has the given days.
   * <p>
   * Example :
   * <pre><code class='java'> // assertion will pass
   * assertThat(Period.ofDays(145)).hasDays(145);
   *
   * // assertion will fail 
   * assertThat(Period.ofDays(145)).hasDays(50);</code></pre>
   * @return this assertion object
   * @throws AssertionError if the actual {@code Period} is {@code null}
   * @throws AssertionError if the actual {@code Period} does not have the given days
   */
  public SELF hasDays(int otherDays) {
    isNotNull();
    int actualDays = actual.getDays();
    if (otherDays != actualDays) {
      throw Failures.instance().failure(info, shouldHaveDays(actual, actualDays, otherDays), actualDays, otherDays);
    }
    return myself;
  }
  /**
   * Verifies that the actual {@code Period} has the given months.
   * <p>
   * Example :
   * <pre><code class='java'> // assertion will pass
   * assertThat(Period.ofMonths(145)).hasMonths(145);
   *
   * // assertion will fail 
   * assertThat(Period.ofMonths(145)).hasMonths(50);</code></pre>
   * @return this assertion object
   * @throws AssertionError if the actual {@code Period} is {@code null}
   * @throws AssertionError if the actual {@code Period} does not have the given months
   */
  public SELF hasMonths(int otherMonths) {
    isNotNull();
    int actualMonths = actual.getMonths();
    if (otherMonths != actualMonths) {
      throw Failures.instance().failure(info, shouldHaveMonths(actual, actualMonths, otherMonths), actualMonths, otherMonths);
    }
    return myself;
  }
  /**
   * Verifies that the actual {@code Period} has the given years.
   * <p>
   * Example :
   * <pre><code class='java'> // assertion will pass
   * assertThat(Period.ofYears(145)).hasYears(145);
   *
   * // assertion will fail 
   * assertThat(Period.ofYears(145)).hasYears(50);</code></pre>
   * @return this assertion object
   * @throws AssertionError if the actual {@code Period} is {@code null}
   * @throws AssertionError if the actual {@code Period} does not have the given months
   */
  public SELF hasYears(int otherYears) {
    isNotNull();
    int actualYears = actual.getYears();
    if (otherYears != actualYears) {
      throw Failures.instance().failure(info, shouldHaveYears(actual, actualYears, otherYears), actualYears, otherYears);
    }
    return myself;
  }
}
