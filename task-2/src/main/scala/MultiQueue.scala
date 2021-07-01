package task2

/*
 * This file presents the abstract interface for a concurrent multi-queue implementation of a prioritiy queue.
 *
 * The queue will be used in a tight loop in a performant-relevant setting with multiple consumer and producer
 * threads using it. The workers using this queue should check for both `isClosed` and the presence of `null`s
 * when polling the queue e.g:
 *
 *  class ConsumerWorker(queue: MultiQueue) extends Runnable {
 *    def run(): Unit = {
 *      while(!queue.isEmpty && !queue.isClosed) {
 *        val work = queue.poll()
 *        if (work != null) doWork(work)
 *      }
 *    }
 *  }
 *
 * YOU SHOULD NOT MODIFY THIS FILE.
 */
abstract class MultiQueue[A >: Null : Ordering] {
  /*
    * Should only return true if there are no elements in the queue at all. Closed status doesn't matter.
    */
  def isEmpty: Boolean

  /*
   * Best effort size estimation.
   */
  def size: Int

  /*
   * Returns true iff `setClosed` was called on this loop.
   */
  def isClosed: Boolean

  /*
   * Closes the queue. A closed queue will not accept any more elements via the insert method but accepts
   * poll() and other operations.
   */
  def setClosed(): Unit

  /*
   * If not closed inserts the element into the queue. If closed this operation does nothig.
   */
  def insert(element: A): Unit

  /*
   * Best effort polling for the smallest element (with respect to Ordering) of the queue.
   *
   *   * it might return `null` as a normal operating procedure even if `isEmpty` == false or `size` is close.
   *   * it might return an element that's not strictly the smallest one (with respect to Ordering)
   */
  def poll(): A
}
