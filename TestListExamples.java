import static org.junit.Assert.*;
import org.junit.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class TestListExamples implements StringChecker{
    ListExamples input;
    List<String> empty;
    List<String> all;
    List<String> some;
    List<String> some2;

    public TestListExamples() {
        empty = new ArrayList<>();
        all = new ArrayList<>();
        some = new ArrayList<>();
        some2 = new ArrayList<>();
        input = new ListExamples();
    }

    public void addAll(List<String> l) {
        l.add("a");
        l.add("b");
        l.add("c");
    }

    public void addSome() {
        some.add("a");
        some.add("a");
        some.add("c");
        some.add("Some");
        some.add("Some");
    }

    public void addSome2() {
        some2.add("a");
        some2.add("c");
        some2.add("Some");
        some2.add("z");
        some2.add("z");
    }

  // Write your grading tests here!
    @Test
    public void testFilterEmpty() {
        List<String> empty_again = Arrays.asList();
        assertEquals(empty_again, input.filter(empty, new TestListExamples()));
    }

    @Test
    public void testFilterAll() {
        addAll(all);
        List<String> all_again = new ArrayList<>();
        addAll(all_again);
        assertEquals(all_again, input.filter(all, new TestListExamples()));
    }

    @Test
    public void testFilterSome() {
        addSome();
        List<String> some_filtered = Arrays.asList("a", "a", "c");
        assertEquals(some_filtered, input.filter(some, new TestListExamples()));
    }

    @Test
    public void testMergeDoubleEmpty() {
        List<String> empty_again = Arrays.asList();
        assertEquals(empty_again, input.merge(empty_again, empty));
    }

    @Test
    public void testMergeWithEmpty() {
        addAll(all);
        List<String> all_again = new ArrayList<>();
        addAll(all_again);
        assertEquals(all_again, input.merge(all, empty));
    }

    @Test
    public void testMergeEmptyWith() {
        addAll(all);
        List<String> all_again = new ArrayList<>();
        addAll(all_again);
        assertEquals(all_again, input.merge(empty, all));
    }

    @Test
    public void testMergeDoubleAll() {
        addAll(all);
        List<String> all_again = new ArrayList<>();
        addAll(all_again);
        List<String> doubleAll = Arrays.asList("a", "a", "b", "b", "c", "c");
        assertEquals(doubleAll, input.merge(all_again, all));
    }

    @Test
    public void testMergeSomes() {
        addSome();
        addSome2();
        List<String> somes = Arrays.asList("a", "a", "a", "c", "c", "Some", "Some", "Some", "z", "z");
        assertEquals(somes, input.merge(some2, some));
    }

    @Override
    public boolean checkString(String s) {
        return (s.length() == 1);
    }
}
