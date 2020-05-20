package bakery.main;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class OrderGenerator {
    public int[][] products;
    public String date;
    public int paymentId;
    public int packingId;
    public int customerId;
    public boolean done;

    public OrderGenerator() {
        sqlQueries q = new sqlQueries();
        q.connect();
        Random random = new Random();
        int[] idsProduct = q.getAllIds("Product");
        int[] idsPayment = q.getAllIds("Payment");
        int[] idsPacking = q.getAllIds("Packing");
        int[] idsCustomer = q.getAllIds("Customer");
        int r = random.nextInt(5)+1;
        products = new int[r][2];
        for (int i = 0; i < r; i++) {
            products[i][0] = idsProduct[random.nextInt(idsProduct.length)];
            for (int j = 0; j < i; j++) {
                if (products[i] == products[j]) {
                    i--;
                    break;
                }
            }
            products[i][1] = random.nextInt(5)+1;
        }
        r = random.nextInt(idsPayment.length);
        paymentId = idsPayment[r];
        r = random.nextInt(idsPacking.length);
        packingId = idsPacking[r];
        r = random.nextInt(idsCustomer.length);
        customerId = idsCustomer[r];
        Date Date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        date = dateFormat.format(Date);
        done = false;
    }
}
