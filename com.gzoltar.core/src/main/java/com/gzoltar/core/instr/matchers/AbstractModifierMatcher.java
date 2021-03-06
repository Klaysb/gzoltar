/**
 * Copyright (C) 2020 GZoltar contributors.
 * 
 * This file is part of GZoltar.
 * 
 * GZoltar is free software: you can redistribute it and/or modify it under the terms of the GNU
 * Lesser General Public License as published by the Free Software Foundation, either version 3 of
 * the License, or (at your option) any later version.
 * 
 * GZoltar is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even
 * the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser
 * General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License along with GZoltar. If
 * not, see <https://www.gnu.org/licenses/>.
 */
package com.gzoltar.core.instr.matchers;

import javassist.CtBehavior;
import javassist.CtClass;
import javassist.CtField;

public abstract class AbstractModifierMatcher implements IMatcher {

  private final int modifierMask;

  protected AbstractModifierMatcher(final int modifierMask) {
    this.modifierMask = modifierMask;
  }

  @Override
  public boolean matches(final CtClass ctClass) {
    return this.matches(ctClass.getModifiers());
  }

  @Override
  public boolean matches(final CtBehavior ctBehavior) {
    return this.matches(ctBehavior.getMethodInfo().getAccessFlags());
  }

  @Override
  public boolean matches(final CtField ctField) {
    return this.matches(ctField.getFieldInfo().getAccessFlags());
  }

  private final boolean matches(final int modifier) {
    return (modifier & this.modifierMask) != 0;
  }

}
