package util.collection.list;

public class DateIterator {

    private DateNode current;

    public DateIterator(DateNode head) {
        this.current = head;
    }

    public boolean hasNext() {
        return this.current != null;
    }

    public DateNode next(){
        assert this.hasNext();

        DateNode element = this.current;
        this.current = this.current.next();
        return element;
    }

}
