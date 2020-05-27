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
package org.assertj.core.api.objectarray;

import static org.assertj.core.util.Lists.newArrayList;
import static org.mockito.Mockito.verify;

import java.util.List;

import org.assertj.core.api.ObjectArrayAssert;
import org.assertj.core.api.ObjectArrayAssertBaseTest;
import org.junit.jupiter.api.DisplayName;

/**
 * Tests for <code>{@link ObjectArrayAssert#containsOnlyOnceElementsOf(Iterable)}</code>.
 *
 * @author CAL027
 */
@DisplayName("ObjectArrayAssert containsOnlyOnceElementsOf")
class ObjectArrayAssert_containsOnlyOnceElementsOf_Test extends ObjectArrayAssertBaseTest {

  private final List<String> values = newArrayList("Yoda", "Luke");

  @Override
  // CS304 (manually written) Issue link: https://github.com/joel-costigliola/assertj-core/issues/1632
  protected ObjectArrayAssert<Object> invoke_api_method() {
    return assertions.containsOnlyOnceElementsOf(values);
  }

  @Override
  // CS304 (manually written) Issue link: https://github.com/joel-costigliola/assertj-core/issues/1632
  protected void verify_internal_effects() {
    verify(arrays).assertContainsOnlyOnce(getInfo(assertions), getActual(assertions), values.toArray());
  }

}
