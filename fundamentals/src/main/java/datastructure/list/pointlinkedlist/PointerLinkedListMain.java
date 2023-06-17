package datastructure.list.pointlinkedlist;

import datastructure.list.pointlinkedlist.PointerLinkedListTestSets.Data;

public class PointerLinkedListMain {

	public static void main(String[] args) {
		PointerLinkedList<Data> list = new PointerLinkedList<>();

		// 데이터 객체 생성
		Data data1 = new Data();
		data1.no = 3;
		data1.name = "Kim";

		Data data2 = new Data();
		data2.no = 2;
		data2.name = "Lee";

		Data data3 = new Data();
		data3.no = 1;
		data3.name = "Choi";

		// addFirst 메서드를 사용하여 데이터 객체를 리스트의 첫 번째에 추가
		list.addFirst(data1);
		list.addFirst(data2);
		list.addFirst(data3);

		// dump 메서드를 호출하여 리스트 출력
		System.out.println("리스트:");
		list.dump();
		System.out.println();

		// search 메서드를 호출하여 "Kim"을 검색
		System.out.println("Kim 검색");
		Data searchData = new Data();
		searchData.name = "Kim";
		Data result = list.search(searchData, Data.NAME_ORDER);
		if (result != null) {
			System.out.println("결과: " + result);
		} else {
			System.out.println("해당 요소 없음");
		}
		System.out.println();

		// addLast 메서드를 사용하여 데이터 객체를 리스트의 마지막에 추가
		Data data4 = new Data();
		data4.no = 4;
		data4.name = "Lee";
		list.addLast(data4);

		// dump 메서드를 호출하여 리스트 출력
		System.out.println("리스트:");
		list.dump();
		System.out.println();

		// removeFirst 메서드를 호출하여 첫 번째 노드 삭제
		System.out.println("첫 번째 노드 삭제:");
		list.removeFirst();
		list.dump();
		System.out.println();
	}
}
