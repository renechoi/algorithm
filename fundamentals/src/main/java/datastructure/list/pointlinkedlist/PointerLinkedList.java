package datastructure.list.pointlinkedlist;

import java.util.Comparator;

public class PointerLinkedList<E> {

	private Node<E> head;
	private Node<E> current;

	static class Node<E> {
		private E data;
		private Node<E> next;

		public Node(E data, Node<E> next) {
			this.data = data;
			this.next = next;
		}
	}

	public PointerLinkedList() {
		head = null;
		current = null;
	}

	/**
	 * 노드 스캔은 다음 두 조건 중 하나가 성립하면 종료된다.
	 * 1. 검색 조건을 만족하는 노드를 찾은 경우
	 * 2. 검색 조건을 만족하는 노드를 찾지 못하고 꼬리 노드를 지나가기 직전인 경우
	 * <p>
	 * 만약 pointer 값이 null이면 더 이상 스캔할 노드가 없음을 의미하므로 null을 리턴한다.
	 * null이 아니라면 스캔을 시작하며 조건 1을 판단한다. 찾고자 하는 데이터와 해당하는 노드의 data 값을 비교한다.
	 * 이와 같은 과정을 수행한다.
	 *
	 * @param value      : 검색할 때 key가 되는 데이터를 넣어둔 value
	 * @param comparator 첫 번째 매개변수와 연결 리스트의 개별 노드 안에 있는 데이터를 비교하기 위한 compartor. 결과가 0이면 조건이 성립하는 것이다.
	 * @return
	 */

	public E search(E value, Comparator<? super E> comparator) {
		Node<E> pointer = head;

		while (pointer != null) {
			if (comparator.compare(value, pointer.data) == 0) {
				current = pointer;
				return pointer.data;
			}
			pointer = pointer.next;
		}
		return null;
	}

	public void addFirst(E value) {
		Node<E> pointer = head;
		current = new Node<E>(value, pointer);
		head = current;
	}

	public void addLast(E value) {
		if (head == null) {
			addFirst(value);
			return;
		}
		Node<E> pointer = head;
		while (pointer.next != null) {
			pointer = pointer.next;
		}
		current = new Node<E>(value, null);
		pointer.next = current;
	}

	public void removeFirst() {
		if (head != null) {
			current = head.next;
			head = current;
		}
	}

	public void removeLast() {
		if (head != null) {
			if (head.next == null) {    // 머리 노드가 하나만 있는 경우
				removeFirst();
			} else {
				Node<E> pointer = head;
				Node<E> previous = head;

				while (pointer.next != null) {
					previous = pointer;
					pointer = pointer.next;
				}
				// while 문 종료시 pointer는 꼬리 노드를 가리키고 previous는 꼬리로부터 두 번째 노드를 나타낸다.
				previous.next = null;
				current = previous;
			}
		}
	}

	public void remove(Node p) {
		if (head == null) {
			if (p == head) {
				removeFirst();
			} else {
				Node<E> pointer = head;

				while (pointer.next != p) {
					pointer = pointer.next;
					if (pointer == null) {
						return;
					}
				}
				pointer.next = p.next;
				current = pointer;
			}
		}
	}

	public void removeCurrentNode() {
		remove(current);
	}

	public void clear() {
		while (head != null) {
			removeFirst();
			;
			current = null;
		}
	}

	public boolean next() {
		if (current == null || current.next == null) {
			return false;
		}
		current = current.next;
		return true;
	}

	public void printCurrentNode() {
		if (current == null) {
			System.out.println("선택한 노드가 없습니다");
		} else {
			System.out.println(current.data);
		}
	}

	public void dump() {
		Node<E> pointer = head;

		while (pointer != null) {
			System.out.println(pointer.data);
			pointer = pointer.next;
		}
	}

}
