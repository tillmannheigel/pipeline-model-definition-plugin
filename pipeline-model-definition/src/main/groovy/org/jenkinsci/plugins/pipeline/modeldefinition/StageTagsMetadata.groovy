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


package org.jenkinsci.plugins.pipeline.modeldefinition


public class StageTagsMetadata {
    public static final String STAGE_STATUS_TAG = "DECLARATIVE_STAGE_STATUS"

    public static final String STAGE_STATUS_SKIPPED_FOR_FAILURE = "SKIPPED_FOR_FAILURE"

    public static final String STAGE_STATUS_SKIPPED_FOR_CONDITIONAL = "SKIPPED_FOR_CONDITIONAL"

    public static final String SYNTHETIC_STAGE_TAG = "SYNTHETIC_STAGE"

    public static final String SYNTHETIC_PRE = "PRE"

    public static final String SYNTHETIC_POST = "POST"

    public static String checkout() {
        return "Checkout SCM"
    }

    public static String agentSetup() {
        return "Agent Setup"
    }

    public static String toolInstall() {
        return "Tool Install"
    }

    public static String postBuild() {
        return "Post Build Actions"
    }
}