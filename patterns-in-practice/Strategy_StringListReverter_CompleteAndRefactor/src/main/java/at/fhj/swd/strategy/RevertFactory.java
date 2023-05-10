package at.fhj.swd.strategy;

import at.fhj.swd.RevertFlavor;

// complete to a full working Factory
public interface RevertFactory {
    RevertFactory INSTANCE=null;

    RevertStrategy createRevertAlgorithm(RevertFlavor flavor);

}
