package edu.austral.ingsis.math;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ResolutionWithVariablesTest {

  /** Case 1 + x where x = 3 */
  @Test
  public void shouldResolveFunction1() {
    final Variable x = new Variable("x", new Number(3d));
    final Double formula = new Sum(new Number(1d), x).calculate();
    final Double result = 4d;

    assertThat(result, equalTo(formula));
  }

  /** Case 12 / div where div = 4 */
  @Test
  public void shouldResolveFunction2() {
    final Variable div = new Variable("div", new Number(4d));
    final Double formula = new Divide(new Number(12d), div).calculate();
    final Double result = 3d;

    assertThat(result, equalTo(formula));
  }

  /** Case (9 / x) * y where x = 3 and y = 4 */
  @Test
  public void shouldResolveFunction3() {
    final Variable x = new Variable("x", new Number(3d));
    final Variable y = new Variable("y", new Number(4d));
    final Double formula = new Multiply(new Divide(new Number(9d), x), y).calculate();
    final Double result = 12d;

    assertThat(result, equalTo(formula));
  }

  /** Case (27 / a) ^ b where a = 9 and b = 3 */
  @Test
  public void shouldResolveFunction4() {
    final Variable a = new Variable("a", new Number(9d));
    final Variable b = new Variable("b", new Number(3d));
    final Double formula = new Power(new Divide(new Number(27d), a), b).calculate();
    final Double result = 27d;

    assertThat(result, equalTo(formula));
  }

  /** Case z ^ (1/2) where z = 36 */
  @Test
  public void shouldResolveFunction5() {
    final Variable z = new Variable("z", new Number(36d));
    final Double formula = new Power(z, new Divide(new Number(1d), new Number(2d))).calculate();
    final Double result = 6d;

    assertThat(result, equalTo(formula));
  }

  /** Case |value| - 8 where value = 8 */
  @Test
  public void shouldResolveFunction6() {
    final Variable value = new Variable("value", new Number(8d));
    final Double formula = new Modulus(new Subtract(value, new Number(8d))).calculate();
    final Double result = 0d;

    assertThat(result, equalTo(formula));
  }

  /** Case (5 - i) * 8 where i = 2 */
  @Test
  public void shouldResolveFunction7() {
    final Variable i = new Variable("i", new Number(2d));
    final Double formula = new Multiply(new Subtract(new Number(5d), i), new Number(8d)).calculate();
    final Double result = 24d;

    assertThat(result, equalTo(formula));
  }
}
