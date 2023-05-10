package at.fhj.swd.fatclass;

import at.fhj.swd.RevertFlavor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static at.fhj.swd.utils.MethArgs.requireNonNull;

public class RevertStringList {
    public List<String> revert(List<String> list, RevertFlavor flavor) {
        requireNonNull(list);
        switch (flavor) {
            case SHALLOW_COPY -> {
                // create a list and copy the elements in reverse order
                // return destinationList;
                List<String> reversedList = new ArrayList<>();
                for(int i=list.size()-1; i>=0; i--)
                    reversedList.add(list.get(i));
                return reversedList;
            }
            case DEEP_COPY -> {
                // create a list with the same size
                // add newly created String-Elements which resemble the elements
                // from the original list.
                // that means:
                // the objects (Strings) in the new list have EQUAL values
                // BUT are not the SAME (have the same reference) hence they
                // must be created.
                // return destinationList;
                List<String> reversedList = new ArrayList<>();
                for(int i=list.size()-1; i>=0; i--)
                    reversedList.add(new String(list.get(i)));
                return reversedList;
            }
            case IN_PLACE -> {
                // reverse the order of the elements within the list by, e.g.,
                // simply exchanging the elements, first <-> last, second <-> forelast ...
                // return list;
                Collections.reverse(list);
                return list;
            }
            case IMMUTABLE -> {
                // create  a reveresed list - have a look at the specification in the
                // TODO.txt file
                // Consider to use the Java tools-classes for reversing a collections.
                // create an unmodifieable version of the list
                // return unmodifiableList;
                List<String> reversedList = new ArrayList<>();
                for(int i=list.size()-1; i>=0; i--)
                    reversedList.add(list.get(i));
                return Collections.unmodifiableList(reversedList);
            }
            default -> throw new IllegalArgumentException("Unknown flavor: " + flavor);
        }
    }
}
