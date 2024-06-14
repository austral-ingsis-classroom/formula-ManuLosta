package edu.austral.ingsis.math;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class ResolutionWithVariablesTest {

  /** Case 1 + x where x = 3 */
  @Test
  public void shouldResolveFunction1() {
    final Variable x = new Variable("x");

    Map<String, Expression> variables = new HashMap<>();
    variables.put("x", new Number(3d));

    final Double formula = new Sum(new Number(1d), x).calculate(variables);
    final Double result = 4d;

    assertThat(result, equalTo(formula));
  }

  /** Case 12 / div where div = 4 */
  @Test
  public void shouldResolveFunction2() {
    final Variable div = new Variable("div");

    Map<String, Expression> variables = new HashMap<>();
    variables.put("div", new Number(4d));

    final Double formula = new Divide(new Number(12d), div).calculate(variables);
    final Double result = 3d;

    assertThat(result, equalTo(formula));
  }

  /** Case (9 / x) * y where x = 3 and y = 4 */
  @Test
  public void shouldResolveFunction3() {
    final Variable x = new Variable("x");
    final Variable y = new Variable("y");

    Map<String, Expression> variables = new HashMap<>();
    variables.put("x", new Number(3d));
    variables.put("y", new Number(4d));

    final Double formula = new Multiply(new Divide(new Number(9d), x), y).calculate(variables);
    final Double result = 12d;

    assertThat(result, equalTo(formula));
  }

  /** Case (27 / a) ^ b where a = 9 and b = 3 */
  @Test
  public void shouldResolveFunction4() {
    final Variable a = new Variable("a");
    final Variable b = new Variable("b");

    Map<String, Expression> variables = new HashMap<>();
    variables.put("a", new Number(9d));
    variables.put("b", new Number(3d));

    final Double formula = new Power(new Divide(new Number(27d), a), b).calculate(variables);
    final Double result = 27d;

    assertThat(result, equalTo(formula));
  }

  /** Case z ^ (1/2) where z = 36 */
  @Test
  public void shouldResolveFunction5() {
    final Variable z = new Variable("z");

    Map<String, Expression> variables = new HashMap<>();
    variables.put("z", new Number(36d));

    final Double formula =
        new Power(z, new Divide(new Number(1d), new Number(2d))).calculate(variables);
    final Double result = 6d;

    assertThat(result, equalTo(formula));
  }

  /** Case |value| - 8 where value = 8 */
  @Test
  public void shouldResolveFunction6() {
    final Variable value = new Variable("value");

    Map<String, Expression> variables = new HashMap<>();
    variables.put("value", new Number(8d));

    final Double formula = new Modulus(new Subtract(value, new Number(8d))).calculate(variables);
    final Double result = 0d;

    assertThat(result, equalTo(formula));
  }

  /** Case (5 - i) * 8 where i = 2 */
  @Test
  public void shouldResolveFunction7() {
    final Variable i = new Variable("i");

    Map<String, Expression> variables = new HashMap<>();
    variables.put("i", new Number(2d));

    final Double formula =
        new Multiply(new Subtract(new Number(5d), i), new Number(8d)).calculate(variables);
    final Double result = 24d;

    assertThat(result, equalTo(formula));
  }
}
