package se.kth.iv1350.seminartask.model;

import se.kth.iv1350.seminartask.util.Cash;

public abstract class TotalRevenuePrint implements SaleObserver {
    protected double totalIncome = 0;
    protected int saleNum = 0;

    private void calcuateTotalIncome(Cash totalPriceWithVatAndDiscount) {
        totalIncome += totalPriceWithVatAndDiscount.getAmount();
        saleNum++;
    }

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
    protected abstract void doShowTotalIncome() throws Exception;

    protected abstract void handleErrors(Exception e);

}
