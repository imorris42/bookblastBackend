package org.metabook.server;

import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

/**
 * @author Ian Morris
 */
public class ClassLoaderTest {

	@Test
	public void foo() {
		URLClassLoader classLoader = (URLClassLoader) getClass().getClassLoader();

		URL[] urls = classLoader.getURLs();

		for (URL url : urls) {
			System.out.println(url);
		}

		System.out.println();
		System.out.println();

		List<Dependency> dependencies = new ArrayList<>();

		for (int i = 0; i < urls.length; i++) {

			Dependency dependency = new Dependency();
			dependency.name = urls[i].toString();
			dependency.index = i;

			dependencies.add(dependency);
		}

		Collections.sort(dependencies);

		for (Dependency dependency : dependencies) {
			System.out.println(dependency);
		}
	}

	static class Dependency implements Comparable<Dependency> {

		String name;
		int index;

		/* 
		 * (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return String.format("%s - %s", name, index);
		}

		/* 
		 * (non-Javadoc)
		 * @see java.lang.Comparable#compareTo(java.lang.Object)
		 */
		@Override
		public int compareTo(Dependency o) {
			return name.compareTo(o.name);
		}
	}
}
