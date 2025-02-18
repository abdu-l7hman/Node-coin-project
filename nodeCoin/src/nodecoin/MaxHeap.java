/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nodecoin;
class MaxHeap {
    private Transaction[] transactions;
    private int capacity;
    private int size;

    public MaxHeap(int capacity) {
        this.capacity = capacity;
        this.transactions = new Transaction[capacity + 1];
        this.size = 0;
    }

    private int parentIndex(int index) {
        return index / 2;
    }

    private int leftChildIndex(int index) {
        return index * 2;
    }

    private int rightChildIndex(int index) {
        return index * 2 + 1;
    }

    private void bubbleUp(int index) {
        while (index > 1 && transactions[parentIndex(index)].amount < transactions[index].amount) {
            swap(index, parentIndex(index));
            index = parentIndex(index);
        }
    }

    private void bubbleDown(int index) {
        while (leftChildIndex(index) <= size) {
            int largerChildIndex = leftChildIndex(index);
            if (rightChildIndex(index) <= size && transactions[rightChildIndex(index)].amount > transactions[largerChildIndex].amount) {
                largerChildIndex = rightChildIndex(index);
            }
            if (transactions[index].amount >= transactions[largerChildIndex].amount) break;
            swap(index, largerChildIndex);
            index = largerChildIndex;
        }
    }

    public void insert(Transaction transaction) {
        if (size == capacity) throw new IllegalStateException("Heap is full");
        transactions[++size] = transaction;
        bubbleUp(size);
    }

    public Transaction removeMax() {
        if (size == 0) throw new IllegalStateException("Heap is empty");
        Transaction maxTransaction = transactions[1];
        transactions[1] = transactions[size];
        transactions[size--] = null;
        bubbleDown(1);
        return maxTransaction;
    }

    private void swap(int index1, int index2) {
        Transaction temp = transactions[index1];
        transactions[index1] = transactions[index2];
        transactions[index2] = temp;
    }

    public Transaction peek() {
        if (size == 0) throw new IllegalStateException("Heap is empty");
        return transactions[1];
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
