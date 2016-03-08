package org.funckit.io;

import static com.google.common.base.Predicates.and;
import static java.util.Arrays.asList;
import static org.funckit.io.FileFunctions.fileFromPath;
import static org.funckit.io.FileFunctions.fis;
import static org.funckit.io.FileFunctions.lastModified;
import static org.funckit.io.FileFunctions.tree;
import static org.funckit.io.FilePredicates.exists;
import static org.funckit.io.FilePredicates.isFile;
import static org.funckit.io.FilePredicates.matchesWildcard;
import static org.funckit.io.PropertiesFunctions.load;
import static org.funckit.lang.ObjectFunctions.checkField;
import static org.funckit.lang.PrimitivePredicates.gt;
import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Properties;

import org.junit.Test;

import com.google.common.collect.FluentIterable;

public class StreamFunctionsTest {
	@Test
	public void notAvailableEmptyStream() {
		available(new ByteArrayInputStream(new byte[0]), 0);
	}

	private void available(InputStream in, int expected) {
		 assertEquals(expected, StreamFunctions.available.apply(in).intValue());
	}
	
	
	public static void examples() {
		FluentIterable.from(Arrays.asList("foo.txt", "bar.txt"))
				.transform(fileFromPath)
				.filter(exists).transform(fis);

		Properties props = new Properties();
		FluentIterable.from(Arrays.asList("foo.txt", "bar.txt"))
				.transform(fileFromPath).filter(exists)
				.transform(fis).transform(load(props));
		
		// Get recursively tree of existing properties files older than 1 hour starting from current directory and load their content  into single Properties object  
		FluentIterable
				.from(asList(tree(matchesWildcard("*.properties")).apply(new File("."))))
				.filter(and(isFile, exists)).filter(checkField(lastModified, gt(3600000L)))
				.transform(fis)
				.transform(load(props));
		
	}
	
}
