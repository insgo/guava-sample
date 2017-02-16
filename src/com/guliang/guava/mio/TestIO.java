package com.guliang.guava.mio;

import com.google.common.base.CharMatcher;
import com.google.common.base.Charsets;
import com.google.common.base.Splitter;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Multiset;
import com.google.common.hash.HashCode;
import com.google.common.hash.Hashing;
import com.google.common.io.Files;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * Created by HuangHailiang on 2017/2/15.
 */
public class TestIO {
    @Test
    public void testGuavaIO() throws IOException {
        File file = new File("../com/guliang/guava/mio/testio.txt");
        ImmutableList<String> lines = Files.asCharSource(file, Charsets.UTF_8).readLines();
        Multiset<String> wordOccurrences = HashMultiset.create(Splitter.on(CharMatcher.WHITESPACE).trimResults().omitEmptyStrings().split(Files.asCharSource(file,Charsets.UTF_8).read()));

        HashCode hashCode = Files.asByteSource(file).hash(Hashing.sha1());

        System.out.println("lines:"+lines+">>>wordOccurrences:"+wordOccurrences+">>>>>hashCode:"+hashCode);

       // Resources.asByteSource("testio.txt").copyTo(Files.asByteSink(file));
    }
}
