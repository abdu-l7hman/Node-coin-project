# nodeCoin Blockchain Implementation

## Project Description
nodeCoin is a cryptocurrency simulation designed for educational purposes, focusing on data structures and algorithms. It utilizes a doubly linked list to represent the blockchain and binary max heaps to manage transactions within each block. Each block corresponds to a date and stores transactions prioritized by their value, providing efficient insertion, deletion, and retrieval operations.

## Features
- **Insert Transactions**: Add transactions to a specific date's block.
- **Fetch Max Transaction**: Retrieve the highest-value transaction for a given date.
- **Remove Max Transaction**: Delete the highest-value transaction from a date's block.
- **Retrieve All Transactions**: Extract all transactions for a date in descending order and remove the block.

## Data Structures Used
- **Doubly Linked List**: Maintains blocks (nodes) in chronological order.
- **Binary Max Heap**: Stores transactions in each block, ensuring the highest value is always at the root.

## Getting Started
### Prerequisites
- Java Development Kit (JDK) 8 or later.

### Compilation and Execution
1. **Compile the Code**:
   ```bash
   javac Solution.java

    Run the Program:
    bash
    Copy

    java Solution

    Input Commands via standard input. The program processes commands until terminated.

Commands
Command	Description	Input Format	Output Format
1	Insert Transaction	1 DDMMYYYY AMOUNT	None
2	Fetch Max Transaction	2 DDMMYYYY	AMOUNT INSERT_ORDER or -1 if none
3	Remove Max Transaction	3 DDMMYYYY	None
4	Retrieve All Transactions	4 DDMMYYYY	All transactions in descending order (one per line) or -1
Input Example
Copy

1 01072024 10.0
1 01072024 15.0
1 25092024 35.2
2 01072024

Output Example
Copy

15.0 2

Notes

    Date Handling: Input dates must be in DDMMYYYY format. If the month is a single digit, a leading zero is added automatically (e.g., 1072024 becomes 01072024).

    Transaction Order: Each transaction per date is assigned a unique insertion order for tie-breaking in max heap comparisons.

    Block Removal: Using Command 4 removes the entire block after retrieving all transactions.

Implementation Details

    Each block (node) in the doubly linked list contains a max heap with a capacity of 100,000 transactions.

    The max heap ensures O(log n) insertion and O(1) access to the maximum transaction.

    The doubly linked list allows O(n) traversal for date-based operations.
