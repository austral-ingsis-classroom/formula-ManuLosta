package edu.austral.ingsis.math;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.empty;

import edu.austral.ingsis.math.visitor.VariableCollector;
import java.util.List;
import org.junit.jupiter.api.Test;

public class ListVariablesTest {

  /** Case 1 + 6 */
  @Test
  public void shouldListVariablesFunction1() {
    final Expression e = new Sum(new Number(1d), new Number(6d));
    final List<String> result = VariableCollector.getVariables(e);

    assertThat(result, empty());
  }

  /** Case 12 / div */
  @Test
  public void shouldListVariablesFunction2() {
    final Expression e = new Divide(new Number(12d), new Variable("div"));
    final List<String> result = VariableCollector.getVariables(e);

    assertThat(result, containsInAnyOrder("div"));
  }

  /** Case (9 / x) * y */
  @Test
  public void shouldListVariablesFunction3() {
    final Expression e =
        new Multiply(new Divide(new Number(9d), new Variable("x")), new Variable("y"));
    final List<String> result = VariableCollector.getVariables(e);

    assertThat(result, containsInAnyOrder("x", "y"));
  }

  /** Case (27 / a) ^ b */
  @Test
  public void shouldListVariablesFunction4() {
    final Expression e =
        new Power(new Divide(new Number(27d), new Variable("a")), new Variable("b"));
    final List<String> result = VariableCollector.getVariables(e);

    assertThat(result, containsInAnyOrder("a", "b"));
  }

  /** Case z ^ (1/2) */
  @Test
  public void shouldListVariablesFunction5() {
    final Expression e = new Power(new Variable("z"), new Divide(new Number(1d), new Number(2d)));
    final List<String> result = VariableCollector.getVariables(e);

    assertThat(result, containsInAnyOrder("z"));
  }

  /** Case |value| - 8 */
  @Test
  public void shouldListVariablesFunction6() {
    final Expression e = new Subtract(new Modulus(new Variable("value")), new Number(8d));
    final List<String> result = VariableCollector.getVariables(e);

    assertThat(result, containsInAnyOrder("value"));
  }

  /** Case (5 - i) * 8 */
  @Test
  public void shouldListVariablesFunction8() {
    final Expression e =
        new Multiply(new Subtract(new Number(5d), new Variable("i")), new Number(8d));
    final List<String> result = VariableCollector.getVariables(e);

    assertThat(result, containsInAnyOrder("i"));
  }
}
