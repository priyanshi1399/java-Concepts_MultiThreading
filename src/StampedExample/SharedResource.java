package StampedExample;

import java.util.concurrent.locks.StampedLock;

public class SharedResource {

   /* boolean isAvailable=false;

    StampedLock lock=new StampedLock();

    public void producer(){
        long stamp=lock.readLock();
        try{
            System.out.println("Read Lock acquired by "+Thread.currentThread().getName());
            isAvailable=true;
            Thread.sleep(3000);
        }
        catch(Exception e){

        }
        finally{
            lock.unlockRead(stamp);
            System.out.println("Read Lock released by "+Thread.currentThread().getName());
        }
    }

    public void consume(){
        long stamp=lock.writeLock();
        try{
            System.out.println("Write Lock acquired by "+Thread.currentThread().getName());
            isAvailable=false;
        }
        catch(Exception e){

        }
        finally{
            lock.unlockWrite(stamp);
            System.out.println("Write Lock released by "+Thread.currentThread().getName());
        }
    }
*/

    int a=10;
    StampedLock lock=new StampedLock();

    public void producer(){
        //by the time I read or I write any other update happens keep checking

        long stamp=lock.tryOptimisticRead();
        try {
            System.out.println("Take optimistix lock");
            a = 11;
            Thread.sleep(9000);
            if (lock.validate(stamp)) {
                System.out.println("updated a value succcessfully");
            } else {
                System.out.println("rollback of work");
                a = 10; //rollback
            }
        }

            catch (Exception e){

            }
        }

        public void consume(){
            long stamp=lock.writeLock();

                System.out.println("Write Lock acquired by "+Thread.currentThread().getName());
               try{
                   System.out.println("performing work");
                   a=9;
               }
               finally{
                   lock.unlockWrite(stamp);
                   System.out.println("Write lock released by "+Thread.currentThread().getName());
               }
            }
    }


