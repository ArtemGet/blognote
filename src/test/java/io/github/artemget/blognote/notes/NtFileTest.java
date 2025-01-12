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

import com.yegor256.Mktmp;
import com.yegor256.MktmpResolver;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.FileTime;
import org.cactoos.io.WriterTo;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

/**
 * Test case for {@link NtFile}.
 *
 * @since 0.1
 */
@ExtendWith(MktmpResolver.class)
final class NtFileTest {

    @Test
    void shouldThrowAtCreatedWhenFileNoFile(@Mktmp final Path root) {
        Assertions.assertThrows(
            IOException.class,
            () -> new NtFile(root.resolve("petuche.txt")).created()
        );
    }

    @Test
    void shouldThrowAtModifiedWhenFileNoFile(@Mktmp final Path root) {
        Assertions.assertThrows(
            IOException.class,
            () -> new NtFile(root.resolve("petuche.txt")).modified()
        );
    }

    @Test
    void shouldReturnCorrectModifiedDate(@Mktmp final Path root) throws Exception {
        final Path file = root.resolve("zarifivoe.large");
        file.toFile().mkdir();
        long expected = System.currentTimeMillis();
        Files.setLastModifiedTime(
            file,
            FileTime.fromMillis(expected)
        );
        MatcherAssert.assertThat(
            "Wrong note modified date",
            new NtFile(file).modified(),
            Matchers.equalTo(expected)
        );
    }

    @Test
    void shouldRetrieveProperContent(@Mktmp final Path root) throws Exception {
        final Path file = root.resolve("zarifivoe.large");
        try (Writer writer = new WriterTo(file)) {
            writer.write("kekus");
        }
        MatcherAssert.assertThat(
            "Note content differs from file",
            new NtFile(file).content().asString(),
            Matchers.equalTo("kekus")
        );
    }
}
