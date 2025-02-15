/*
 * MIT License
 *
 * Copyright (c) 2025 Artem Getmanskii
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package io.github.artemget.blognote.overseer;

import io.github.artemget.blognote.notes.Notes;
import org.cactoos.io.Directory;

/**
 * Watches for new notes.
 *
 * @since 0.1
 * @todo #1:90min I suggest implement {@code OsNew} by adding matching logic
 *  Overseer should accept matchers that filters only notes that are new and synch it with tojos.
 */
@SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
public final class OsNew implements Overseer {

    /**
     * Root dir.
     */
    private final Directory dir;

    public OsNew(final Directory directory) {
        this.dir = directory;
    }

    @Override
    public Notes inspected() {
        throw new UnsupportedOperationException("not implemented");
    }
}
