package se.kth.iv1350.seminartask.view;

import se.kth.iv1350.seminartask.model.SaleObserver;
import se.kth.iv1350.seminartask.util.Cash;

public abstract class TotalRevenuePrint implements SaleObserver {
    protected double totalIncome = 0;
    protected int saleNum = 0;


    /**
     * Calculates the total income and adds one to the saleNum
     * @param totalPriceWithVatAndDiscount The total income for the current sale
     */
    private void calcuateTotalIncome(Cash totalPriceWithVatAndDiscount) {
        totalIncome += totalPriceWithVatAndDiscount.getAmount();
        saleNum++;
    }

    /**
     * Prints the Total revenue to both a file and the console
     * @param totalPriceWithVATAndDiscount revenue for the current sale
     */
    @Override 
    public void newSale(Cash totalPriceWithVATAndDiscount) {
        calcuateTotalIncome(totalPriceWithVATAndDiscount);
        showTotalIncome();
    }
    private void showTotalIncome() {
        try {
            doShowTotalIncome();
        } catch (Exception e) {
            handleErrors(e);
        }
    }
    /**
     * Shows the total revenue either by printing to console or to file
     * @throws Exception
     */
    protected abstract void doShowTotalIncome() throws Exception;

    /**
     * Handles Exceptions by printing them with ErrorMessageHandler
     * @param e the error
     */
    protected abstract void handleErrors(Exception e);

}
