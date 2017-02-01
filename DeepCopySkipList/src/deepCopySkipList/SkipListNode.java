package deepCopySkipList;

public class SkipListNode {
	public int value;
	public SkipListNode next;
	public SkipListNode forward;

	public SkipListNode(int value) {
		this.value = value;
	}
}
