public class EmpWageBuilder {

      //Constants
      static final int IS_PART_TIME=1;
      static final int IS_FULL_TIME=2;
      static final int EMPLOYEE_RATE_PER_HOUR=20;

      public static void main(String args[]) {
         //Variables
         int empHrs=0,empWage=0;

         double empCheck=Math.floor(Math.random() *10)% 3;
         if( empCheck == IS_FULL_TIME ) {
               empHrs=8;
         }else if ( empCheck == IS_PART_TIME ) {
               empHrs=4;
         }else {
               empHrs=0;
         }
         empWage = empHrs * EMPLOYEE_RATE_PER_HOUR;
         System.out.println("Employee Wage: "+empWage);
     }
}
