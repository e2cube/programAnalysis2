package com.company;

import worklist.Constraint;
import worklist.TrashSet;

public abstract class Label {
    public abstract Constraint DetectionSignsF(TrashSet info, String nodeName);
}