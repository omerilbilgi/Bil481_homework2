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

  public void testCompute_EvenNumberOfArguments() {
    assertFalse(util.compute(1, 2));
  }
 



  
}