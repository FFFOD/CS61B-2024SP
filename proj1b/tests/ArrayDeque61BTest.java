import jh61b.utils.Reflection;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.List;

import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assertWithMessage;

public class ArrayDeque61BTest {

//     @Test
//     @DisplayName("ArrayDeque61B has no fields besides backing array and primitives")
//     void noNonTrivialFields() {
//         List<Field> badFields = Reflection.getFields(ArrayDeque61B.class)
//                 .filter(f -> !(f.getType().isPrimitive() || f.getType().equals(Object[].class) || f.isSynthetic()))
//                 .toList();
//
//         assertWithMessage("Found fields that are not array or primitives").that(badFields).isEmpty();
//     }

    @Test
    void Array(){
        ArrayDeque61B<Integer> ad = new ArrayDeque61B<>();
        ad.addFirst(1101);
        ad.addFirst(2202);
        ad.addLast(-1001);
        System.out.println(ad.size());
//        System.out.println(ad.get(1));
//         ad.printDeque();
         ad.removeFirst();
         ad.removeLast();
                 ad.printDeque();
    }


}
