/*
 * The MIT License
 *
 * Copyright (C) 2012 by Chris Johnson
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

package org.jenkins_ci.plugins.extra_run_conditions.extendedcausecondition;
import hudson.ExtensionPoint;
import hudson.DescriptorExtensionList;
import hudson.model.AbstractBuild;
import hudson.model.BuildListener;
import hudson.model.Describable;
import hudson.model.Descriptor;
import hudson.model.Hudson;
/**
 * Abstract Build Cause condition that checks the build condition
 *
 * @author Chris Johnson
 */
public abstract class BuildCauseCondition implements Describable<BuildCauseCondition>, ExtensionPoint {

    public static DescriptorExtensionList<BuildCauseCondition, BuildCauseConditionDescriptor> all() {
        return Hudson.getInstance().<BuildCauseCondition, BuildCauseConditionDescriptor>getDescriptorList(BuildCauseCondition.class);
    }

    /**
     * Performs the check of the condition
     *
     * @return true if the condition is allowed
     *         false if not allowed to proceed.
     */
    public abstract boolean runPerform(final AbstractBuild<?, ?> build, final BuildListener listener) throws InterruptedException;

    /**
     * {@inheritDoc}
     */
    @Override
    public Descriptor<BuildCauseCondition> getDescriptor() {
        return (Descriptor) Hudson.getInstance().getDescriptor(getClass());
    }


}