package com.gzoltar.core.instr.matchers;

import javassist.CtBehavior;
import javassist.CtClass;
import javassist.CtField;

public class MethodAttributeMatcher extends AbstractAttributeMatcher {

  public MethodAttributeMatcher(final String attribute) {
    super(attribute);
  }

  @Override
  public boolean matches(final CtClass ctClass) {
    for (CtBehavior ctBehavior : ctClass.getMethods()) {
      if (this.matches(ctBehavior)) {
        return true;
      }
    }
    return false;
  }

  @Override
  public boolean matches(final CtBehavior ctBehavior) {
    return super.matches(ctBehavior);
  }

  @Override
  public boolean matches(final CtField ctField) {
    return this.matches(ctField.getDeclaringClass());
  }

}
