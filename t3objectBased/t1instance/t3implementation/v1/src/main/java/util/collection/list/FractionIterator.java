package util.collection.list;

public class FractionIterator {

    private FractionNode current;

    public FractionIterator(FractionNode head) {
        this.current = head;
    }

    public boolean hasNext() {
        return this.current != null;
    }

    public FractionNode next(){
        assert this.hasNext();

        FractionNode element = this.current;
        this.current = this.current.next();
        return element;
    }

}
