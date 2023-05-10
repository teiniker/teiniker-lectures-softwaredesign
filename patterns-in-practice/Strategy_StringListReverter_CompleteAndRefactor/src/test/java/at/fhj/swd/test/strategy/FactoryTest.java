package at.fhj.swd.test.strategy;

import at.fhj.swd.RevertFlavor;
import at.fhj.swd.strategy.RevertFactory;
import at.fhj.swd.strategy.RevertStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FactoryTest {
    RevertFactory rf = null;

    @BeforeEach
    void setup(){
        // ATTENTION:
        // if the following code-loine works, the visibility is not correctly set
        // RevertFactory rf = new RevertFactoryImplI();
        rf = RevertFactory.INSTANCE;
    }

    @Test
    void factorySingletonTest(){
        // the factory instances MUST be equal AND same
        assertNotNull(rf);
        assertEquals(rf, RevertFactory.INSTANCE);
        assertSame(rf, RevertFactory.INSTANCE);
    }

    @Test
    void factoryCreateShallowTest(){
        RevertStrategy strategy = rf.createRevertAlgorithm(RevertFlavor.SHALLOW_COPY);
        assertNotNull(strategy);
        assertEquals("ShallowCopyRevert", strategy.getClass().getSimpleName());
    }

    @Test
    void factoryCreateDeepTest(){
        RevertStrategy strategy = rf.createRevertAlgorithm(RevertFlavor.DEEP_COPY);
        assertNotNull(strategy);
        assertEquals("DeepCopyRevert", strategy.getClass().getSimpleName());
    }

    @Test
    void factoryCreateInplaceTest(){
        RevertStrategy strategy = rf.createRevertAlgorithm(RevertFlavor.IN_PLACE);
        assertNotNull(strategy);
        assertEquals("InplaceRevert", strategy.getClass().getSimpleName());
    }

    @Test
    void factoryCreateImmutableTest(){
        RevertStrategy strategy = rf.createRevertAlgorithm(RevertFlavor.IMMUTABLE);
        assertNotNull(strategy);
        assertEquals("ImmutableRevert", strategy.getClass().getSimpleName());
    }

}
