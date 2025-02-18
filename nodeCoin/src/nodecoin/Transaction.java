/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nodecoin;
class Transaction {
    double amount;
    int insertionOrder;

    public Transaction(double amount, int insertionOrder) {
        this.amount = amount;
        this.insertionOrder = insertionOrder;
    }
}
