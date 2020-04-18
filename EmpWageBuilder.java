import java.util.*;
import java.lang.*;

class EmpWageBuilder{
   static Scanner sc = new Scanner(System.in);
   static Map<String,Integer> companyWages = new HashMap<String,Integer>();
   static ArrayList<CompanyEmpWage> companiesArray = new ArrayList<>();

   //Method to add company details
   static void addCompany(){
      int wage;
      int totalDays;
      int hoursInDay;
      int totalHours;
      String name="";
      int numberOfCompanies;

      System.out.println("Enter number of companies you want to add");
      numberOfCompanies=sc.nextInt();

      for(int i=0; i<numberOfCompanies; i++){
         System.out.println("Enter name of Company");
         name=sc.next();

         System.out.println("Enter emp rate per hour");
         wage=sc.nextInt();

         System.out.println("Enter hours per day");
         hoursInDay=sc.nextInt();

         System.out.println("Enter the total working days");
         totalDays=sc.nextInt();

         System.out.println("Enter total working hours");
         totalHours=sc.nextInt();

          companiesArray.add(new CompanyEmpWage(name,wage,hoursInDay,totalDays,totalHours));
        }
    }

    //Method to compute wages and size
    static void computeWages(){
        for(int index=companyWages.size(); index<companiesArray.size(); index++)
            computeEmployeeWage(companiesArray.get(index).companyName,companiesArray.get(index).FULL_DAY_HOUR,companiesArray.get(index).MAX_HOURS,
                                                      companiesArray.get(index).MAX_DAYS,companiesArray.get(index).EMP_RATE_PER_HOUR);
    }

   //Method to calculate total employee wage
   static void computeEmployeeWage(String companyName, int FULL_DAY_HOUR,int MAX_HOURS, int MAX_DAYS,int EMP_RATE_PER_HOUR){
      int dailyHours=0;
      int monthlyHours=0;
      int hours=0;
      int days=0;
      ArrayList<Integer> alist = new ArrayList<>();
      final int IS_FULL_TIME = 1;
      final int IS_PART_TIME = 2;

         while( hours <= MAX_HOURS && days <= MAX_DAYS ) {
            dailyHours=0;
            int employeeCheck = (int) Math.round(Math.random()*10)%3;
            switch (employeeCheck){
            case IS_FULL_TIME:
                  dailyHours = FULL_DAY_HOUR+dailyHours;
                  break;
            case IS_PART_TIME:
                  dailyHours=FULL_DAY_HOUR/2+dailyHours;
                  break;
            default:
                  dailyHours+=0;
            }
            alist.add(dailyHours*EMP_RATE_PER_HOUR);
            hours+=dailyHours;
            days++;
            monthlyHours+=dailyHours;
         }
        for(int listIndex=0;listIndex<companiesArray.size();listIndex++) {
            if(companiesArray.get(listIndex).companyName.toString().equals(companyName)) {
                companiesArray.get(listIndex).set(alist,(EMP_RATE_PER_HOUR*monthlyHours));
            }
        }
        companyWages.put(companyName,(EMP_RATE_PER_HOUR*monthlyHours));
    }


   static void printDailyandTotalWage(){
      String name="";
      System.out.println("Enter company name");
      name=sc.next();
      for(int index=0;index<companiesArray.size();index++){
         if((companiesArray.get(index).companyName.toString().toLowerCase().equals(name.toLowerCase()))){
            System.out.println("--------"+companiesArray.get(index).companyName.toString()+"--------");
               for(int listIndex=0;listIndex<companiesArray.get(index).dailywages.size();listIndex++) {
                  int daily=companiesArray.get(index).dailywages.get(listIndex);
                   System.out.println("daily wages are: "+daily+" and total wages is "+companiesArray.get(index).totalwage);
               }
            }
         }
      }

   //Main method
   public static void main(String[] args) {
      System.out.println("1.Add company 2.Exit");
      int choice = sc.nextInt();

         switch(choice) {
         case 1: addCompany();
                 computeWages();
                 printDailyandTotalWage();
                 break;
         case 2:System.out.println("----Exit-----");
                 break;
         default:System.out.println("-----Invalid choice-----");
         }
         companyWages.forEach((company,wage)->System.out.println("Total wage for company "+company+" is: "+wage));
      }

}

//Company Employee wage
class CompanyEmpWage{
   final int EMP_RATE_PER_HOUR ;
   final int FULL_DAY_HOUR ;
   final int MAX_DAYS;
   final int MAX_HOURS;
   String companyName ;
   ArrayList<Integer> dailywages;
   int totalwage;

   CompanyEmpWage(String companyName,int wagePerHour, int fullDayHours, int total_Working_Days,int total_Working_Hours){
      this.companyName=companyName;
      this.EMP_RATE_PER_HOUR=wagePerHour;
      this.FULL_DAY_HOUR=fullDayHours;
      this.MAX_DAYS=total_Working_Days;
      this.MAX_HOURS=total_Working_Hours;
   }
    public void set(ArrayList<Integer> dailyWages, int totalWage){
        this.dailywages=dailyWages;
        this.totalwage=totalWage;
    }
}
