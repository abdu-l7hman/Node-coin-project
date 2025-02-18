/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nodecoin;
class NodeCoin {
    private class Node {
        String date;
        MaxHeap transactions;
        Node nextNode;
        Node prevNode;
        int transactionCounter;

        public Node(String date, int capacity) {
            this.date = date;
            this.transactions = new MaxHeap(capacity);
            this.nextNode = null;
            this.prevNode = null;
            this.transactionCounter = 1;
        }
    }

    private Node head, tail;
    private int nodeCount;

    public NodeCoin() {
        head = tail = null;
        nodeCount = 0;
    }

    // Adds a new transaction to the linked list of dates
    public void addTransaction(String date, double amount) {
        Node node = getNodeByDate(date);

        if (node == null) {
            node = new Node(date, 100000); // Create a new node with capacity for transactions
            addNodeToTail(node); // Append node to the end of the list
        }

        node.transactions.insert(new Transaction(amount, node.transactionCounter));
        node.transactionCounter++;
    }

    // Retrieves the max transaction for a specific date
    public String fetchMaxTransaction(String date) {
        Node node = getNodeByDate(date);
        if (node == null || node.transactions.isEmpty()) return "-1";
        
        Transaction maxTransaction = node.transactions.peek();
        return String.format("%.1f %d", maxTransaction.amount, maxTransaction.insertionOrder);
    }

    // Removes the max transaction for a specific date
    public void deleteMaxTransaction(String date) {
        Node node = getNodeByDate(date);
        if (node != null && !node.transactions.isEmpty()) {
            node.transactions.removeMax();
        }
    }

    // Retrieves all transactions for a specific date and removes the node afterward
    public String retrieveAllTransactions(String date) {
        Node node = getNodeByDate(date);
        if (node == null) return "-1";

        StringBuilder allTransactions = new StringBuilder();
        while (!node.transactions.isEmpty()) {
            Transaction maxTransaction = node.transactions.removeMax();
            allTransactions.append(String.format("%.1f %d\n", maxTransaction.amount, maxTransaction.insertionOrder));
        }

        removeNode(node);
        return allTransactions.toString().trim();
    }

    // Finds the node for a given date
    private Node getNodeByDate(String date) {
        Node currentNode = head;
        while (currentNode != null) {
            if (currentNode.date.equals(date)) return currentNode;
            currentNode = currentNode.nextNode;
        }
        return null;
    }

    // Adds a node to the end of the linked list
    private void addNodeToTail(Node node) {
        if (tail == null) {
            head = tail = node;
        } else {
            tail.nextNode = node;
            node.prevNode = tail;
            tail = node;
        }
        nodeCount++;
    }

    // Removes a node from the linked list
    private void removeNode(Node node) {
        if (node.prevNode != null) node.prevNode.nextNode = node.nextNode;
        else head = node.nextNode;

        if (node.nextNode != null) node.nextNode.prevNode = node.prevNode;
        else tail = node.prevNode;

        nodeCount--;
    }
}

