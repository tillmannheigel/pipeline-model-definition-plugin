/*
 * The MIT License
 *
 * Copyright (c) 2016, CloudBees, Inc.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package org.jenkinsci.plugins.pipeline.modeldefinition;

import hudson.Extension;
import org.jenkinsci.plugins.workflow.cps.CpsScript;
import org.jenkinsci.plugins.workflow.cps.CpsThread;
import org.jenkinsci.plugins.workflow.cps.GlobalVariable;

import javax.annotation.Nonnull;

/**
 * Loads the main "pipeline" step as well as the additional CPS-transformed code it depends on.
 *
 * @author Andrew Bayer
 */
@Extension
public class ModelStepLoader extends GlobalVariable {
    public static final String STEP_NAME = "pipeline";

    @Override
    @Nonnull
    public String getName() {
        return STEP_NAME;
    }

    @Override
    @Nonnull
    public Object getValue(@Nonnull CpsScript script) throws Exception {
        CpsThread c = CpsThread.current();
        if (c == null)
            throw new IllegalStateException("Expected to be called from CpsThread");

        // Make sure we've already loaded ClosureModelTranslator or load it now.
        script.getClass().getClassLoader().loadClass("org.jenkinsci.plugins.pipeline.modeldefinition.ClosureModelTranslator");
        script.getClass().getClassLoader().loadClass("org.jenkinsci.plugins.pipeline.modeldefinition.PropertiesToMapTranslator");
        script.getClass().getClassLoader().loadClass("org.jenkinsci.plugins.pipeline.modeldefinition.MethodsToListTranslator");

        return script.getClass()
                .getClassLoader()
                .loadClass("org.jenkinsci.plugins.pipeline.modeldefinition.ModelInterpreter")
                .getConstructor(CpsScript.class)
                .newInstance(script);
    }

}