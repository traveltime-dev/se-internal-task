package task2.j;

/*
 * This file presents the abstract interface for a concurrent multi-queue implementation of a prioritiy queue.
 *
 * The queue will be used in a tight loop in a performance-relevant setting with multiple consumer and producer
 * threads using it. The workers using this queue should check for both `isClosed` and the presence of `null`s
 * when polling the queue e.g:
 *
 *  class ConsumerWorker(queue: MultiQueue) extends Runnable {
 *    void run() {
 *      while(!queue.isEmpty && !queue.isClosed) {
 *        work = queue.poll()
 *        if (work != null) doWork(work)
 *      }
 *    }
 *  }
 *
 * YOU SHOULD NOT MODIFY THIS FILE.
 */
public interface MultiQueue<A> {
  /*
    * Should only return true if there are no elements in the queue at all. Closed status doesn't matter.
    */
  public boolean isEmpty();

  /*
   * Best effort size estimation.
   */
  public int size();

  /*
   * Returns true iff `setClosed` was called on this loop.
   */
  public boolean isClosed();

  /*
   * Closes the queue. A closed queue will not accept any more elements via the insert method but accepts
   * poll() and other operations.
   */
  public void setClosed();

  /*
   * If not closed inserts the element into the queue. If closed this operation does nothig.
   */
  public void insert(A element);

  /*
   * Best effort polling for the smallest element (with respect to natural ordering or a provided Comparator) of the queue.
   *
   *   * it might return `null` as a normal operating procedure even if `isEmpty` == false or `size` is close.
   *   * it might return an element that's not strictly the smallest one (with respect to natural ordering/given comparator)
   */
  public A poll();
}
