package edu.austral.ingsis.math;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ResolutionTest {

  /** Case 1 + 6 */
  @Test
  public void shouldResolveSimpleFunction1() {
    final Double sum = new Sum(new Number(1d), new Number(6d)).calculate();
    final Double result = 7d;

    assertThat(result, equalTo(sum));
  }

  /** Case 12 / 2 */
  @Test
  public void shouldResolveSimpleFunction2() {
    final Double division = new Divide(new Number(12d), new Number(2d)).calculate();
    final Double result = 6d;

    assertThat(result, equalTo(division));
  }

  /** Case (9 / 2) * 3 */
  @Test
  public void shouldResolveSimpleFunction3() {
    final Double formula = new Multiply(new Divide(new Number(9d), new Number(2d)), new Number(3d)).calculate();
    final Double result = 13.5;

    assertThat(result, equalTo(formula));
  }

  /** Case (27 / 6) ^ 2 */
  @Test
  public void shouldResolveSimpleFunction4() {
    final Double formula = new Power(new Divide(new Number(27d), new Number(6d)), new Number(2d)).calculate();
    final Double result = 20.25;

    assertThat(result, equalTo(formula));
  }

  /** Case 36 ^ (1/2) */
  @Test
  public void shouldResolveSimpleFunction5() {
    final Double formula = new Power(new Number(36d), new Divide(new Number(1d), new Number(2d))).calculate();
    final Double result = 6d;

    assertThat(result, equalTo(formula));
  }

  /** Case |136| */
  @Test
  public void shouldResolveSimpleFunction6() {
    final Double formula = new Modulus(new Number(136d)).calculate();
    final Double result = 136d;

    assertThat(result, equalTo(formula));
  }

  /** Case |-136| */
  @Test
  public void shouldResolveSimpleFunction7() {
    final Double formula = new Modulus(new Number(-136d)).calculate();
    final Double result = 136d;

    assertThat(result, equalTo(formula));
  }

  /** Case (5 - 5) * 8 */
  @Test
  public void shouldResolveSimpleFunction8() {
    final Double formula = new Multiply(new Subtract(new Number(5d), new Number(5d)), new Number(8d)).calculate();
    final Double result = 0d;

    assertThat(result, equalTo(formula));
  }
}
