import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class TestUtil {
  Util util;

  @Before
  public void setUp() { util = new Util(); }

  @Test
  public void example() { assertTrue(true); }

  @Test
  public void testCompute_SingleArgument() {
    assertFalse(util.compute(5));
  }

  @Test
  public void testCompute_EvenNumberOfArguments() {
    assertFalse(util.compute(1, 2));
  }
  
  @Test(expected = RuntimeException.class)
  public void testCompute_ZeroAsArgument_ThrowsRuntimeException() {
    assertFalse(util.compute(1, 0, -1)); // Adding more arguments to ensure it's not a single or even number scenario
  }

  @Test
  public void testCompute_OddNumberOfArguments_SumNotDivisibleByAny() {
    assertTrue(util.compute(2, 4, 1)); // Sum is 7, which is not divisible by 2, 4, or 1
  }

  @Test
  public void testCompute_OddNumberOfArguments_SumDivisibleByOneArgument() {
    assertFalse(util.compute(6, 3, -2)); // Sum is 7, which is divisible by 7 itself
  }
}