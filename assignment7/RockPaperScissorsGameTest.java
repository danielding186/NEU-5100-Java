package assignment7;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RockPaperScissorsGameTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		 Scissors s = new Scissors(5);
	     Paper p = new Paper(7);
	     Rock r = new Rock(15);
	     
	     assertTrue(s.fight(p));
	     assertFalse(p.fight(s));
	     
	     assertTrue(r.fight(p));
	     assertFalse(p.fight(r));
	     
	     assertTrue(r.fight(s));
	     assertFalse(s.fight(r));
	     
	}

}
