package org.assertj.core.api;
//CS304 https://github.com/joel-costigliola/assertj-core/issues/1853
import java.time.Period;

/**
 * Assertion methods for {@link Period}
 *
 */
public class PeriodAssert extends AbstractPeriodAssert<PeriodAssert> {
  /**
   * Creates a new <code>{@link PeriodAssert}</code>
   * @param period the actual value to verify
   */
  public PeriodAssert(Period period) {
    super(period, PeriodAssert.class);
  }
}
