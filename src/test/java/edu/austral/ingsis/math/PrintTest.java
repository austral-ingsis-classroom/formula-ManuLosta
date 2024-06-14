package edu.austral.ingsis.math;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import edu.austral.ingsis.math.visitor.Printer;
import org.junit.jupiter.api.Test;

public class PrintTest {

  /** Case 1 + 6 */
  @Test
  public void shouldPrintFunction1() {
    final Expression expression = new Sum(new Number(1d), new Number(6d));
    final String expected = "1.0 + 6.0";

    final String result = Printer.print(expression);

    assertThat(result, equalTo(expected));
  }

  /** Case 12 / 2 */
  @Test
  public void shouldPrintFunction2() {
    final Expression e = new Divide(new Number(12d), new Number(2d));
    final String expected = "12.0 / 2.0";

    final String result = Printer.print(e);

    assertThat(result, equalTo(expected));
  }

  /** Case (9 / 2) * 3 */
  @Test
  public void shouldPrintFunction3() {
    final Expression e = new Multiply(new Divide(new Number(9d), new Number(2d)), new Number(3d));
    final String expected = "(9.0 / 2.0) * 3.0";

    final String result = Printer.print(e);

    assertThat(result, equalTo(expected));
  }

  /** Case (27 / 6) ^ 2 */
  @Test
  public void shouldPrintFunction4() {
    final Expression e = new Power(new Divide(new Number(27d), new Number(6d)), new Number(2d));
    final String expected = "(27.0 / 6.0) ^ 2.0";

    final String result = Printer.print(e);

    assertThat(result, equalTo(expected));
  }

  /** Case |value| - 8 */
  @Test
  public void shouldPrintFunction6() {
    final Expression e = new Subtract(new Modulus(new Variable("value")), new Number(8d));
    final String expected = "|value| - 8.0";

    final String result = Printer.print(e);

    assertThat(result, equalTo(expected));
  }

  /** Case (5 - i) * 8 */
  @Test
  public void shouldPrintFunction8() {
    final Expression e =
        new Multiply(new Subtract(new Number(5d), new Variable("i")), new Number(8d));
    final String expected = "(5.0 - i) * 8.0";

    final String result = Printer.print(e);

    assertThat(result, equalTo(expected));
  }
}
