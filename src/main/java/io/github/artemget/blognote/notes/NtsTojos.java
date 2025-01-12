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

package io.github.artemget.blognote.notes;

import java.nio.file.Path;
import java.util.Collection;

/**
 * Tojo notes.
 *
 * @since 0.1
 * @todo #1:90min I suggest adding tojos db dependency and
 *  implement {@code NtsTojos}. NtTojo could be implemented if needed. Tests are required.
 */
public final class NtsTojos implements Notes {
    @Override
    public Note add(final Path path) {
        throw new UnsupportedOperationException("not implemented");
    }

    @Override
    public Collection<Note> unPosted() {
        throw new UnsupportedOperationException("not implemented");
    }
}
