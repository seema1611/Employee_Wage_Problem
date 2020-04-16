public class EmpWageBuilder {

      //Constants
      static final int IS_PART_TIME=1;
      static final int IS_FULL_TIME=2;

      //Variables
      String companyName;
      int empHrs=0,emp_Rate_Per_Hour=0;
      int max_Days=0,max_Hours=0;
      int salary=0,total_Salary=0;
      int total_Working_Days=0,total_Working_Hours=0;

      //Constructor
      public EmpWageBuilder(String companyName, int emp_Rate_Per_Hour, int max_Hours, int max_Days) {
         this.companyName=companyName;
         this.emp_Rate_Per_Hour=emp_Rate_Per_Hour;
         this.max_Hours=max_Hours;
         this.max_Days=max_Days;
      }

      //Function to calculate wage of multiple company
      public void calculateWage() {
         while( total_Working_Days <this.max_Days && total_Working_Hours <this.max_Hours ) {
            total_Working_Days++;

            int empCheck=(int) (Math.random() *10)% 3;
            switch(empCheck) {
            case IS_FULL_TIME:
               empHrs=8;
               break;
            case IS_PART_TIME:
               empHrs=4;
               break;
            default:
               break;
            }
            total_Working_Hours=total_Working_Hours+empHrs;
            total_Salary=total_Working_Hours * emp_Rate_Per_Hour;
         }
         System.out.println("Total Employee Salary: "+total_Salary);
     }

     //Main method
     public static void main(String args[]) {
        System.out.println("-----D-Mart Employee-----");
        EmpWageBuilder e1=new EmpWageBuilder("D-Mart", 20, 100, 20);
        e1.calculateWage();

        System.out.println("-----K-mart Employee-----");
        EmpWageBuilder e2=new EmpWageBuilder("K-MArt", 50, 200, 22);
        e2.calculateWage();

     }
}

