public class EmpWageBuilder {

      //Constants
      static final int IS_PART_TIME=1;
      static final int IS_FULL_TIME=2;
      static final int EMPLOYEE_RATE_PER_HOUR=20;

      public static void main(String args[]) {
         //Variables
         int empHrs=0,empWage=0;

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
         empWage = empHrs * EMPLOYEE_RATE_PER_HOUR;
         System.out.println("Employee Wage: "+empWage);
     }
}
