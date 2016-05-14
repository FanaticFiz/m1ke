import com.aspiration.handlers.DirectoryHandler;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class DirHandlerTest {
	private DirectoryHandler directoryHandler;
	private List<String> list1;
	private List<String> list2;

	@Before
	public void test() {
		directoryHandler = new DirectoryHandler();
		list1 = new ArrayList<>();
		list2 = new ArrayList<>();
	}

	@Test
	public void equalsTest() {
		list1.add("one.file");
		list2.add("one.file");

		assertEquals(0, directoryHandler.difference(list1, list2).size());
	}

	@Test
	public void firstTest() {
		list1.add("one.file");
		list1.add("two.file");

		list2.add("one.file");
		assertEquals(1, directoryHandler.difference(list1, list2).size());
	}

	@Test
	public void secondTest() {
		list1.add("one.file");
		list1.add("file5");

		list2.add("one.file");
		list2.add("two.file");
		list2.add("file");
		list2.add("file2");
		assertEquals(4, directoryHandler.difference(list1, list2).size());
	}

}