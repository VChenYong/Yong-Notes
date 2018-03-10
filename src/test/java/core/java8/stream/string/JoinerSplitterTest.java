package core.java8.stream.string;

import junit.framework.TestCase;
import org.junit.Before;

import java.util.Arrays;
import java.util.List;

/**
 * Created by yong on 3/9/18.
 */
public class JoinerSplitterTest extends TestCase {

    private String languages = "Scala,Java,Go,Javascript,typeScript,Gradle,Groove";
    private List<String> listOfLanguages = Arrays.asList("Scala", "Java", "Go", "Javascript", "typeScript", "Gradle", "Groove");


    @Before
    public void setUp() throws Exception {
    }

    public void testSplit() {

        assertEquals(listOfLanguages, JoinerSplitter.split(languages));

    }


    public void testJoin() {

        assertEquals(languages, JoinerSplitter.join(listOfLanguages));


    }
}