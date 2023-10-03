public class TipCalculator {
    private int numPeople;
    private int tipPercentage;
    private double totalBillBeforeTip;

    public TipCalculator(int numPeople, int tipPercentage){
        this.numPeople = numPeople;
        this.tipPercentage = tipPercentage;
        totalBillBeforeTip = 0.0;
    }
    public double getTotalBillBeforeTip(){
        return totalBillBeforeTip;
    }
    public int getTipPercentage(){
        return tipPercentage;
    }
    public int getNumPeople(){
        return numPeople;
    }
    public void addMeal(double cost){
        totalBillBeforeTip += cost;
    }
    public double tipAmount(){
        return (tipPercentage / 100.0) * totalBillBeforeTip;
    }
    public double totalBill(){
        return tipAmount() + totalBillBeforeTip;
    }
    public double perPersonCostBeforeTip(){
        return totalBillBeforeTip / numPeople;
    }
    public double perPersonTipAmount(){
        return tipAmount() / numPeople;
    }
    public double perPersonTotalCost(){
        return totalBill() / numPeople;
    }
}
