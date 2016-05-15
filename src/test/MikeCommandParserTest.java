import com.aspiration.core.MikeCommandParser;
import org.junit.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.assertEquals;

public class MikeCommandParserTest {

	@Test
	public void m1keCommandTest() {

		assertEquals(true, MikeCommandParser.isMikeCommand("m1ke".split(" ")));
		assertEquals(false, MikeCommandParser.isMikeCommand("notm1ke".split(" ")));
	}

	@Test
	public void m1keValidCommandTest() {

		assertEquals(false, MikeCommandParser.isValidCommand("m1ke not valid command".split(" ")));
		assertEquals(false, MikeCommandParser.isValidCommand("m1ke qqqqq".split(" ")));
		assertEquals(true,  MikeCommandParser.isValidCommand("m1ke quit".split(" ")));
		assertEquals(true,  MikeCommandParser.isValidCommand("m1ke integrate".split(" ")));
	}

	@Test
	public void m1keCommandParamsTest() {
		Path currentRelativePath = Paths.get("");
		String currentDirIntegrate = "m1ke integrate "     + currentRelativePath.toAbsolutePath().toString();
		String currentDirRemove    = "m1ke remove-branch " + currentRelativePath.toAbsolutePath().toString();

		assertEquals(true,  MikeCommandParser.isCommandParamsValid("m1ke quit".split(" ")));
		assertEquals(false, MikeCommandParser.isCommandParamsValid("m1ke integrate wrongDir".split(" ")));

		assertEquals(true,  MikeCommandParser.isCommandParamsValid(currentDirIntegrate.split(" ")));
		assertEquals(false, MikeCommandParser.isCommandParamsValid(currentDirRemove.split(" ")));

	}
}
