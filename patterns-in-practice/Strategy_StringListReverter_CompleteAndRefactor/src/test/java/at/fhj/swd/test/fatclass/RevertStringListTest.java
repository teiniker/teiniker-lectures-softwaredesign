package at.fhj.swd.test.fatclass;

import at.fhj.swd.RevertFlavor;
import at.fhj.swd.fatclass.RevertStringList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RevertStringListTest {
    private List<String> list;
    private List<String> reverseList;
    private RevertStringList reverter;

    @BeforeEach
    void setUp() {
        list = new ArrayList<>(Arrays.stream(new String[]{"This", "is a", "list of", "text tokens."}).toList());
        reverseList = new ArrayList<>(Arrays.stream(new String[]{"text tokens.", "list of", "is a", "This"}).toList());
        reverter = new RevertStringList();
    }

    @Test
    void revertShallowFlavorTest() {
        List<String> result = reverter.revert(list, RevertFlavor.SHALLOW_COPY);
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
        assertEquals(list.get(list.size()-1), result.get(0));
        assertSame(list.get(list.size()-1), result.get(0));

        // CHECK that result is MUTABLE
        int originalResultSize = result.size();
        result.remove(0);
        assertEquals(originalResultSize-1, result.size());
    }

    @Test
    void revertDeepFlavorTest() {
        List<String> result = reverter.revert(list, RevertFlavor.DEEP_COPY);
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
        assertEquals(list.get(list.size()-1), result.get(0));
        assertNotSame(list.get(list.size()-1), result.get(0));

        // CHECK that result is MUTABLE
        int originalResultSize = result.size();
        result.remove(0);
        assertEquals(originalResultSize-1, result.size());
    }

    @Test
    void revertInPlaceFlavorTest() {
        List<String> result = reverter.revert(list, RevertFlavor.IN_PLACE);
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
        assertSame(list.get(list.size()-1), result.get(list.size()-1));

        // CHECK that result is MUTABLE
        int originalResultSize = result.size();
        result.remove(0);
        assertEquals(originalResultSize-1, result.size());
    }

    @Test
    void revertImmutableFlavorTest() {
        List<String> result = reverter.revert(list, RevertFlavor.IMMUTABLE);
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