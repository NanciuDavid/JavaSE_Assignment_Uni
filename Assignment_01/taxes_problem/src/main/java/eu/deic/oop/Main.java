package eu.deic.oop;
import java.util.*;



public class Main 
{

    public static void main( String[] args )
    {
        Scanner scan = new Scanner(System.in);

        int income;
        System.out.print("Enter the income:");
        income = Integer.valueOf(scan.nextLine());

        System.out.println();

        int typeOfStatus;


        ArrayList<String> statusList = new ArrayList<>();
        statusList.add("Single");
        statusList.add("Married Filling Jointly or Qualified Widow(er)");
        statusList.add("Married Filling Separately");
        statusList.add("Head of Household");


        System.out.println("Enter the type status:");
        System.out.println("0 - Single");
        System.out.println("1 - Married Filling Jointly or Qualified Widow(er)");
        System.out.println("2 - Married Filling Separately");
        System.out.println("3 - Head of household");
        typeOfStatus = Integer.parseInt(scan.nextLine());
        
        if (typeOfStatus >= 0 && typeOfStatus < statusList.size()) {
            System.out.println();
            calculateTax(income, statusList.get(typeOfStatus));
        } else {
            System.out.println("Status doesn't exist");
        }
        
        scan.close();

    }


    public static void calculateTax(int value, String typeOfStatus) {
        switch(typeOfStatus){
            case "Single" :
                if(value >=0 && value <=8350) {
                    System.out.println("The Marginal Tax Rate is 10% with a tax of : ");
                    System.out.print(value*10/100);
                }
                else if(value > 8350 && value <= 33950) {
                    System.out.println("The Marginal Tax Rate is 15% with a tax of : ");
                    System.out.print(value*15/100);
                }
                else if(value > 33951 && value <= 82250) {
                    System.out.println("The Marginal Tax Rate is 25% with a tax of :");
                    System.out.print(value*25/100);
                }
                else if(value > 82251 && value <= 171550) {
                    System.out.println("The Marginal Tax Rate is 28% with a tax of :");
                    System.out.print(value*28/100);
                }
                else if(value > 171551 && value <= 372950) {
                    System.out.println("The Marginal Tax Rate is 33% with a tax of: ");
                    System.out.print(value*33/100);
                } else {
                    System.out.println("The Marginal Tax Rate is 35% witx a tax of: ");
                    System.out.print(value*35/100);
                }
                break;
            case "Married Filling Jointly or Qualified Widow(er)" :
                if(value >=0 && value <=16700){
                System.out.println("The Marginal Tax Rate is 10% with a tax of : ");
                System.out.print(value*10/100);
                }
                else if(value > 16700 && value <= 67900) {
                System.out.println("The Marginal Tax Rate is 15% with a tax of : ");
                System.out.print(value*15/100);
                } else if(value > 67900 && value <= 137050) {
                System.out.println("The Marginal Tax Rate is 25% with a tax of :");
                System.out.print(value*25/100);
                }
                else if(value > 137050 && value <= 208850) {
                System.out.println("The Marginal Tax Rate is 28% with a tax of :");
                System.out.print(value*28/100);
                }
                else if(value > 208851 && value <= 372950) {
                System.out.println("The Marginal Tax Rate is 33% with a tax of :");
                System.out.print(value*33/100);
                } else {
                System.out.println("The Marginal Tax Rate is 35% with a tax of :");
                System.out.print(value*35/100);
                }
                return;

            case "Married Filling Separately" :
            if(value >=0 && value <=8350){
                System.out.println("The Marginal Tax Rate is 10% with a tax of : ");
                System.out.print(value*10/100);
                }
                else if(value > 8350 && value <= 33950) {
                System.out.println("The Marginal Tax Rate is 15% with a tax of : ");
                System.out.print(value*15/100);
                } else if(value > 33950 && value <= 68525) {
                System.out.println("The Marginal Tax Rate is 25% with a tax of :");
                System.out.print(value*25/100);
                }
                else if(value > 68525 && value <= 104425) {
                System.out.println("The Marginal Tax Rate is 28% with a tax of :");
                System.out.print(value*28/100);
                }
                else if(value > 104426 && value <= 186475) {
                System.out.println("The Marginal Tax Rate is 33% with a tax of :");
                System.out.print(value*33/100);
                } else {
                System.out.println("The Marginal Tax Rate is 35% with a tax of :");
                System.out.print(value*35/100);
                }
                    break;
            
            case "Head of Household" :
            if(value >=0 && value <=11950){
                System.out.println("The Marginal Tax Rate is 10% with a tax of : ");
                System.out.print(value*10/100);
                }
                else if(value > 11950 && value <= 45500) {
                System.out.println("The Marginal Tax Rate is 15% with a tax of : ");
                System.out.print(value*15/100);
                } else if(value > 45500 && value <= 117450) {
                System.out.println("The Marginal Tax Rate is 25% with a tax of :");
                System.out.print(value*25/100);
                }
                else if(value > 117450 && value <= 190200) {
                System.out.println("The Marginal Tax Rate is 28% with a tax of :");
                System.out.print(value*28/100);
                }
                else if(value > 190200 && value <= 371950) {
                System.out.println("The Marginal Tax Rate is 33% with a tax of :");
                System.out.print(value*33/100);
                } else {
                System.out.println("The Marginal Tax Rate is 35% with a tax of :");
                System.out.print(value*35/100);
                }
                    break;
            
            default: 
                    break;
        }
    }
}
