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

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import org.cactoos.Text;
import org.cactoos.text.TextOf;

/**
 * Note file.
 *
 * @since 0.1
 */
public final class NtFile implements Note {

    /**
     * Path to note.
     */
    private final Path path;

    public NtFile(final Path path) {
        this.path = path;
    }

    @Override
    public Text content() {
        return new TextOf(this.path);
    }

    @Override
    public long created() throws IOException {
        return this.attributes().creationTime().toMillis();
    }

    @Override
    public long modified() throws IOException {
        return this.attributes().lastModifiedTime().toMillis();
    }

    private BasicFileAttributes attributes() throws IOException {
        return Files.readAttributes(this.path, BasicFileAttributes.class);
    }
}
