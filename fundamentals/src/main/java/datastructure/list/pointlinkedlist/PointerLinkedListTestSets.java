package datastructure.list.pointlinkedlist;

import java.util.Comparator;

public class PointerLinkedListTestSets {
	static class Data {
		static final int NO = 1;
		static final int NAME = 2;

		Integer no;
		String name;

		public String toString() {
			return String.format("%d %s", no, name);
		}

		public static final Comparator<Data> NO_ORDER = new NoOrderComparator();

		private static class NoOrderComparator implements Comparator<Data> {

			@Override
			public int compare(Data d1, Data d2) {
				return d1.no.compareTo(d2.no);
			}
		}

		public static final Comparator<Data> NAME_ORDER = new NameOrderComparator();

		private static class NameOrderComparator implements Comparator<Data> {

			@Override
			public int compare(Data d1, Data d2) {
				return d1.name.compareTo(d2.name);
			}
		}
	}
}
