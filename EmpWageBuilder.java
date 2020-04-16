public class EmpWageBuilder {

      //Constants
      static final int IS_PART_TIME=1;
      static final int IS_FULL_TIME=2;
      static final int EMPLOYEE_RATE_PER_HOUR=20;
      static final int MAXIMUM_WORKING_DAYS=20;
      static final int MAXIMUM_WORKING_HOURS=100;

      public void calculateWage() {
         //Variables
         int empHrs=0;
         int salary=0,total_Salary=0;
         int total_Working_Days=0,total_Working_Hours=0;

         while( total_Working_Days <= MAXIMUM_WORKING_DAYS && total_Working_Hours <= MAXIMUM_WORKING_HOURS ) {
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
            total_Salary=total_Working_Hours * EMPLOYEE_RATE_PER_HOUR;
         }
         System.out.println("Total Employee Salary: "+total_Salary);
     }

     public static void main(String args[]) {
        EmpWageBuilder e1=new EmpWageBuilder();
        e1.calculateWage();
     }
}
