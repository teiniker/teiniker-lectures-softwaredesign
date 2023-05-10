package at.fhj.swd.test.strategy;

import at.fhj.swd.RevertFlavor;
import at.fhj.swd.strategy.RevertFactory;
import at.fhj.swd.strategy.RevertStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StrategyTest {
    private List<String> list;
    private List<String> reverseList;
    RevertFactory revertFactory = null;

    @BeforeEach
    void setUp() {
        revertFactory = RevertFactory.INSTANCE;
        list = new ArrayList<>(Arrays.stream(new String[]{"This", "is a", "list of", "text tokens."}).toList());
        reverseList = new ArrayList<>(Arrays.stream(new String[]{"text tokens.", "list of", "is a", "This"}).toList());
    }


    @Test
    void revertShallowFlavorWithNullParamTest() {
        RevertStrategy reverter = revertFactory.createRevertAlgorithm(RevertFlavor.SHALLOW_COPY);
        assertThrows(IllegalArgumentException.class, () -> reverter.revert(null));
    }

    @Test
    void revertShallowFlavorTest() {
        RevertStrategy reverter = revertFactory.createRevertAlgorithm(RevertFlavor.SHALLOW_COPY);

        List<String> result = reverter.revert(list);
        assertNotNull(result);
        System.out.println("shallow copy result: " + result);
        System.out.println("original strList: " + list);

        // check simple functionality
        // (i.e., reverse order)
        assertEquals(reverseList, result);          // must match expected (reversed) list

        // --- flavor unique part of the test
        // check identities
        assertNotEquals(list, result);              // must differ since result shall be reversed
        assertNotSame(list, result);                // must be another instance than the original

        // Proof that this is a shallow-copy
        // elements are reused in result with another order
        // last element of the original list AND first element of result list
        // must be identical
        assertEquals(list.get(list.size() - 1), result.get(0));
        assertSame(list.get(list.size() - 1), result.get(0));

        // CHECK that result is MUTABLE
        int originalResultSize = result.size();
        result.remove(0);
        assertEquals(originalResultSize - 1, result.size());
    }

    @Test
    void revertDeepFlavorWithNullParameterTest() {
        RevertStrategy reverter = revertFactory.createRevertAlgorithm(RevertFlavor.DEEP_COPY);
        assertThrows(IllegalArgumentException.class, () -> reverter.revert(null));
    }

    @Test
    void revertDeepFlavorTest() {
        RevertStrategy reverter = revertFactory.createRevertAlgorithm(RevertFlavor.DEEP_COPY);

        List<String> result = reverter.revert(list);
        assertNotNull(result);
        System.out.println("deep copy result: " + result);
        System.out.println("original strList: " + list);

        // check simple functionality
        // (i.e., reverse order)
        assertEquals(reverseList, result);          // must match expected (reversed) list

        // --- flavor unique part of the test
        // check identities
        assertNotSame(list, result);                // must be another instance than the original

        // Proof that this is a DEEP_COPY
        // last element of the original List AND first element of result list
        // must be separate identities BUT
        // must be equal
        assertEquals(list.get(list.size() - 1), result.get(0));
        assertNotSame(list.get(list.size() - 1), result.get(0));

        // CHECK that result is MUTABLE
        int originalResultSize = result.size();
        result.remove(0);
        assertEquals(originalResultSize - 1, result.size());
    }

    @Test
    void revertInPlaceFlavorNullParameterTest() {
        RevertStrategy reverter = revertFactory.createRevertAlgorithm(RevertFlavor.IN_PLACE);
        assertThrows(IllegalArgumentException.class, () -> reverter.revert(null));
    }


    @Test
    void revertInPlaceFlavorTest() {
        RevertStrategy reverter = revertFactory.createRevertAlgorithm(RevertFlavor.IN_PLACE);
        List<String> result = reverter.revert(list);
        assertNotNull(result);
        System.out.println("in-place copy result: " + result);
        System.out.println("original strList: " + list);

        // check simple functionality
        // (i.e., reverse order)
        assertEquals(reverseList, result);          // must match expected (reversed) list

        // --- flavor unique part of the test
        // MUST be equal to the passed list
        // AND
        // MUST be the same as the passed list
        // reverting is done IN_PLACE
        assertEquals(list, result);
        assertSame(list, result);

        // Proof that also items are the same instances
        assertSame(list.get(0), result.get(0));
        assertSame(list.get(list.size() - 1), result.get(list.size() - 1));

        // CHECK that result is MUTABLE
        int originalResultSize = result.size();
        result.remove(0);
        assertEquals(originalResultSize - 1, result.size());
    }

    @Test
    void revertImmutableFlavorNullParameterTest() {
        RevertStrategy reverter = revertFactory.createRevertAlgorithm(RevertFlavor.IMMUTABLE);
        assertThrows(IllegalArgumentException.class, ()-> reverter.revert(null));
    }


    @Test
    void revertImmutableFlavorTest() {
        RevertStrategy reverter = revertFactory.createRevertAlgorithm(RevertFlavor.IMMUTABLE);
        List<String> result = reverter.revert(list);
        assertNotNull(result);
        System.out.println("immutable copy result: " + result);
        System.out.println("original strList: " + list);

        // check simple functionality
        // (i.e., reverse order)
        assertEquals(reverseList, result);          // must match expected (reversed) list

        // --- flavor unique part of the test
        // check identities
        assertNotSame(list, result);                // must be another instance than the original

        // Proof that this is another IMMUTABLE instance
        // last element of the original List AND first element of result list
        // must be separate identities BUT
        // must be equal
        assertEquals(list.get(list.size()-1), result.get(0));       // elements must be equal
        assertSame(list.get(list.size()-1), result.get(0));         // AND are the same

        // CHECK that result is MUTABLE
        int originalResultSize = result.size();
        assertThrows(UnsupportedOperationException.class, ()-> result.remove(0));
    }

}