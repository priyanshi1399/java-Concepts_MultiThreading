public class Chat {
    boolean flag=false;
    public  void question(String msg){
        if(flag){
           // System.out.println("Question Wait");
            try{
                wait();
            }
            catch(InterruptedException e){
                e.printStackTrace();
            }
        }
       System.out.println("Question" + msg);
        flag=true;
        notify();
    }
    public  void answer(String msg){
        if(!flag){
           // System.out.println("Answer Wait");
            try{
                wait();
            }
            catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.println("Answer" + msg);
        flag=false;
        notify();
    }


}
