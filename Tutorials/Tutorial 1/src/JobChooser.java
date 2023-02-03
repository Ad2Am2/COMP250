/**
 * This is the solutions file, the methods amountInCad and whichJob will be completely removed for the myCourses post and we will ask students to write them.
 *
 * This exercise should familiarize students with types and methods.
 */
public class JobChooser {

    static final double exchangeRate = 1.31;


    private static double amountInCAD(double usd) {
        return usd*exchangeRate;
    }

    private static double amountInUSD(double cad) {
        return cad/exchangeRate;
    }


    private static String whichJob(double jobOnePay, double cityOneRent, double cityOneTaxPercent, double jobTwoPay, double cityTwoRent, double cityTwoTaxPercent, String currency) {

        double jobOneNetPay = jobOnePay*(1-cityOneTaxPercent) - cityOneRent;
        double jobTwoNetPay = jobTwoPay*(1-cityTwoTaxPercent) - cityTwoRent;

        if (jobOneNetPay > jobTwoNetPay) {
            return "Job one is more profitable by " + (jobOneNetPay-jobTwoNetPay) + " " + currency + " per month!";
        } else if (jobTwoNetPay > jobOneNetPay) {
            return "Job two is more profitable by " + (jobTwoNetPay-jobOneNetPay) + " " + currency + " per month!";
        } else {
            return "Both jobs are equally as profitable! Pick whichever you are most interested in :)";
        }
    }


    public static void main(String[] args) {
        double jobOnePayCAD = 5000;
        double jobTwoPayUSD = 7000;
        double cityOneRentCAD = 1500;
        double cityTwoRentUSD = 2000;
        double cityOneTaxPercent = 0.4;
        double cityTwoTaxPercent = 0.33;


        double jobTwoPayCAD = amountInCAD(jobTwoPayUSD);
        double cityTwoRentCAD = amountInCAD(cityTwoRentUSD);

        System.out.println(whichJob(jobOnePayCAD, cityOneRentCAD, cityOneTaxPercent, jobTwoPayCAD, cityTwoRentCAD, cityTwoTaxPercent, "USD"));

    }
}







//    public static double amountInCAD(double usd){
//        double exchangeRate = 1.31;
//        return usd * exchangeRate;
//    }
//
//    public static String whichJob(double payOneCad, double payTwoCad, double rentOneCad, double rentTwoCad, double taxOnePercent, double taxTwoPercent){
//        double totalCompOne = payOneCad * (1 -  taxOnePercent) - rentOneCad;
//        double totalCompTwo = payTwoCad * (1 - taxTwoPercent) - rentTwoCad;
//        if (totalCompTwo > totalCompOne) {
//            return "City two is $" + (totalCompTwo - totalCompOne) + " more profitable!";
//        } else if (totalCompTwo == totalCompOne){
//            return "Both cities are equal!";
//        }
//        else {
//            return "City one is $" + (totalCompOne - totalCompTwo) + " more profitable!";
//        }
//    }